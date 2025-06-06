package com.example.TicketChain.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.TicketChain.core.TicketStatus;
import com.example.TicketChain.dto.request.CreateOrderRequest;
import com.example.TicketChain.dto.request.OrderTicketDTO;
import com.example.TicketChain.dto.request.TransactionDTO;
import com.example.TicketChain.entity.Events;
import com.example.TicketChain.entity.OrderDetail;
import com.example.TicketChain.entity.Orders;
import com.example.TicketChain.entity.TicketType;
import com.example.TicketChain.entity.Tickets;
import com.example.TicketChain.entity.Transactions;
import com.example.TicketChain.entity.Wallet;
import com.example.TicketChain.repository.EventRepository;
import com.example.TicketChain.repository.OrderDetailRepository;
import com.example.TicketChain.repository.OrderRepository;
import com.example.TicketChain.repository.TicketRepository;
import com.example.TicketChain.repository.TicketTypeRepository;
import com.example.TicketChain.repository.TransactionsRepository;
import com.example.TicketChain.repository.WalletRepository;

import jakarta.transaction.Transactional;

@Service
public class OrdersService {
    @Autowired
    private WalletRepository walletRepository;

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private TicketTypeRepository ticketTypeRepository;

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    private TransactionsRepository transactionRepository;

    @Transactional
    public void createOrder(CreateOrderRequest request) {
        // 1. Lấy Wallet
        Wallet wallet = walletRepository.findById(request.getWalletId())
                .orElseThrow(() -> new RuntimeException("Wallet not found"));

        // 2. Lấy Event
        Events event = eventRepository.findById(request.getEventId())
                .orElseThrow(() -> new RuntimeException("Event not found"));

        // 3. Tạo Transaction
        TransactionDTO txDto = request.getTransaction();
        Transactions transaction = new Transactions();
        transaction.setTx_hash(txDto.getTxHash());
        transaction.setFrom_address(txDto.getFromAddress());
        transaction.setTo_address(txDto.getToAddress());
        transaction.setTransaction_date(txDto.getTransactionDate());
        transaction = transactionRepository.save(transaction);

        // 4. Tạo và lưu Tickets, gán transaction
        List<Tickets> tickets = new ArrayList<>();
        for (OrderTicketDTO t : request.getTickets()) {
            TicketType type = ticketTypeRepository.findById(t.getTicketTypeId())
                    .orElseThrow(() -> new RuntimeException("TicketType not found"));
            // Giảm vé khi bán ra
            if (type.getRemaining_amount() <= 0) {
                throw new RuntimeException("Loại vé " + type.getName() + " đã bán hết");
            }
            type.setRemaining_amount(type.getRemaining_amount() - 1);
            ticketTypeRepository.save(type);

            Tickets ticket = new Tickets();
            ticket.setOwner_address(txDto.getToAddress());
            ticket.setToken_id(t.getTokenId());
            ticket.setStatus(TicketStatus.OWNED);
            ticket.setIs_listing(false);
            ticket.setCreated_at(new Timestamp(System.currentTimeMillis()));
            ticket.setTicketType(type);
            ticket.setTransaction(transaction);

            tickets.add(ticketRepository.save(ticket));
        }

        // 5. Tạo Orders, gán transaction, wallet, event, tổng tiền
        Orders order = new Orders();
        order.setTotal_price(request.getTotalPrice());
        order.setIs_resale(request.getIsResale() != null ? request.getIsResale() : false);
        order.setTransaction(transaction);
        order.setEvent(event);
        order.setWallet(wallet);

        order = orderRepository.save(order);

        // 6. Tạo OrderDetail với từng ticket
        for (int i = 0; i < tickets.size(); i++) {
            OrderDetail detail = new OrderDetail();
            detail.setOrder(order);
            detail.setTicket(tickets.get(i));
            detail.setPrice(request.getTickets().get(i).getPrice());
            orderDetailRepository.save(detail);
        }
    }

}
