package com.example.TicketChain.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.web3j.crypto.Credentials;
import org.web3j.model.EventManager;
import org.web3j.model.TicketNFT;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.gas.DefaultGasProvider;

@Configuration
public class Web3jConfig {
    @Value("${web3j.client-address}")
    private String infuraUrl;
    @Value("${web3j.wallet.private-key}")
    private String privateKey;
    @Value("${contract.event-address}")
    private String eventContract;
    @Value("${contract.ticket-address}")
    private String ticketContract;

    @Bean
    public Web3j web3j() {
        return Web3j.build(new HttpService(infuraUrl));
    }

    @Bean
    public Credentials credentials() {
        return Credentials.create(privateKey);
    }

    @Bean
    public EventManager eventContract(Web3j web3j, Credentials credentials) {
        System.out.println("Loading EventContract from: " + eventContract);
        return EventManager.load(eventContract, web3j, credentials, new DefaultGasProvider());
    }

    @Bean
    public TicketNFT ticketContract(Web3j web3j, Credentials credentials) {
        System.out.println("Loading TicketContract from: " + ticketContract);
        return TicketNFT.load(ticketContract, web3j, credentials, new DefaultGasProvider());
    }

}
