package org.web3j.model;

import io.reactivex.Flowable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.DynamicStruct;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.BaseEventResponse;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple2;
import org.web3j.tuples.generated.Tuple4;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 4.8.7.
 */
@SuppressWarnings("rawtypes")
public class EventManager extends Contract {
    public static final String BINARY = "Bin file was not provided";

    public static final String FUNC_BUYMULTIPLETICKETS = "buyMultipleTickets";

    public static final String FUNC_BUYTICKETS = "buyTickets";

    public static final String FUNC_CREATEEVENT = "createEvent";

    public static final String FUNC_CREATETICKETTYPE = "createTicketType";

    public static final String FUNC_MINTTICKETSFORTYPE = "mintTicketsForType";

    public static final String FUNC_RENOUNCEOWNERSHIP = "renounceOwnership";

    public static final String FUNC_SETTICKETNFT = "setTicketNFT";

    public static final String FUNC_TRANSFEROWNERSHIP = "transferOwnership";

    public static final String FUNC_EVENTS = "events";

    public static final String FUNC_EVENTTICKETS = "eventTickets";

    public static final String FUNC_GETEVENTDETAILS = "getEventDetails";

    public static final String FUNC_OWNER = "owner";

    public static final String FUNC_TICKETTYPEIDSBYEVENT = "ticketTypeIdsByEvent";

    public static final org.web3j.abi.datatypes.Event EVENTCREATED_EVENT = new org.web3j.abi.datatypes.Event("EventCreated", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>(true) {}, new TypeReference<Utf8String>() {}));
    ;

    public static final org.web3j.abi.datatypes.Event OWNERSHIPTRANSFERRED_EVENT = new org.web3j.abi.datatypes.Event("OwnershipTransferred", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}));
    ;

    public static final org.web3j.abi.datatypes.Event TICKETSOLD_EVENT = new org.web3j.abi.datatypes.Event("TicketSold", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>(true) {}, new TypeReference<Address>() {}, new TypeReference<Uint256>() {}));
    ;

    public static final org.web3j.abi.datatypes.Event TICKETTYPECREATED_EVENT = new org.web3j.abi.datatypes.Event("TicketTypeCreated", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>(true) {}, new TypeReference<Uint256>(true) {}, new TypeReference<Utf8String>() {}));
    ;

    @Deprecated
    protected EventManager(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected EventManager(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected EventManager(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected EventManager(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<TransactionReceipt> buyMultipleTickets(BigInteger eventId, List<BigInteger> ticketTypeIds, List<BigInteger> quantities) {
        final Function function = new Function(
                FUNC_BUYMULTIPLETICKETS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(eventId), 
                new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.generated.Uint256>(
                        org.web3j.abi.datatypes.generated.Uint256.class,
                        org.web3j.abi.Utils.typeMap(ticketTypeIds, org.web3j.abi.datatypes.generated.Uint256.class)), 
                new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.generated.Uint256>(
                        org.web3j.abi.datatypes.generated.Uint256.class,
                        org.web3j.abi.Utils.typeMap(quantities, org.web3j.abi.datatypes.generated.Uint256.class))), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> buyTickets(BigInteger eventId, BigInteger ticketTypeId, BigInteger quantity) {
        final Function function = new Function(
                FUNC_BUYTICKETS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(eventId), 
                new org.web3j.abi.datatypes.generated.Uint256(ticketTypeId), 
                new org.web3j.abi.datatypes.generated.Uint256(quantity)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> createEvent(String _organizer, List<BigInteger> TicketPrices, List<BigInteger> TicketQuantities, List<String> MetadataURIs) {
        final Function function = new Function(
                FUNC_CREATEEVENT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_organizer), 
                new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.generated.Uint256>(
                        org.web3j.abi.datatypes.generated.Uint256.class,
                        org.web3j.abi.Utils.typeMap(TicketPrices, org.web3j.abi.datatypes.generated.Uint256.class)), 
                new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.generated.Uint256>(
                        org.web3j.abi.datatypes.generated.Uint256.class,
                        org.web3j.abi.Utils.typeMap(TicketQuantities, org.web3j.abi.datatypes.generated.Uint256.class)), 
                new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.Utf8String>(
                        org.web3j.abi.datatypes.Utf8String.class,
                        org.web3j.abi.Utils.typeMap(MetadataURIs, org.web3j.abi.datatypes.Utf8String.class))), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> createTicketType(BigInteger eventId, BigInteger price, BigInteger quantity, String metadataURI) {
        final Function function = new Function(
                FUNC_CREATETICKETTYPE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(eventId), 
                new org.web3j.abi.datatypes.generated.Uint256(price), 
                new org.web3j.abi.datatypes.generated.Uint256(quantity), 
                new org.web3j.abi.datatypes.Utf8String(metadataURI)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public List<EventCreatedEventResponse> getEventCreatedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(EVENTCREATED_EVENT, transactionReceipt);
        ArrayList<EventCreatedEventResponse> responses = new ArrayList<EventCreatedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            EventCreatedEventResponse typedResponse = new EventCreatedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.eventId = (BigInteger) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.organizer = (String) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<EventCreatedEventResponse> eventCreatedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new io.reactivex.functions.Function<Log, EventCreatedEventResponse>() {
            @Override
            public EventCreatedEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(EVENTCREATED_EVENT, log);
                EventCreatedEventResponse typedResponse = new EventCreatedEventResponse();
                typedResponse.log = log;
                typedResponse.eventId = (BigInteger) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.organizer = (String) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<EventCreatedEventResponse> eventCreatedEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(EVENTCREATED_EVENT));
        return eventCreatedEventFlowable(filter);
    }

    public RemoteFunctionCall<TransactionReceipt> mintTicketsForType(BigInteger eventId, BigInteger ticketTypeId, BigInteger quantity) {
        final Function function = new Function(
                FUNC_MINTTICKETSFORTYPE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(eventId), 
                new org.web3j.abi.datatypes.generated.Uint256(ticketTypeId), 
                new org.web3j.abi.datatypes.generated.Uint256(quantity)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public List<OwnershipTransferredEventResponse> getOwnershipTransferredEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(OWNERSHIPTRANSFERRED_EVENT, transactionReceipt);
        ArrayList<OwnershipTransferredEventResponse> responses = new ArrayList<OwnershipTransferredEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            OwnershipTransferredEventResponse typedResponse = new OwnershipTransferredEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.previousOwner = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.newOwner = (String) eventValues.getIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<OwnershipTransferredEventResponse> ownershipTransferredEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new io.reactivex.functions.Function<Log, OwnershipTransferredEventResponse>() {
            @Override
            public OwnershipTransferredEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(OWNERSHIPTRANSFERRED_EVENT, log);
                OwnershipTransferredEventResponse typedResponse = new OwnershipTransferredEventResponse();
                typedResponse.log = log;
                typedResponse.previousOwner = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.newOwner = (String) eventValues.getIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<OwnershipTransferredEventResponse> ownershipTransferredEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(OWNERSHIPTRANSFERRED_EVENT));
        return ownershipTransferredEventFlowable(filter);
    }

    public RemoteFunctionCall<TransactionReceipt> renounceOwnership() {
        final Function function = new Function(
                FUNC_RENOUNCEOWNERSHIP, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> setTicketNFT(String _ticketNFT) {
        final Function function = new Function(
                FUNC_SETTICKETNFT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _ticketNFT)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public List<TicketSoldEventResponse> getTicketSoldEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(TICKETSOLD_EVENT, transactionReceipt);
        ArrayList<TicketSoldEventResponse> responses = new ArrayList<TicketSoldEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            TicketSoldEventResponse typedResponse = new TicketSoldEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.eventId = (BigInteger) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.buyer = (String) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.totalprice = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<TicketSoldEventResponse> ticketSoldEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new io.reactivex.functions.Function<Log, TicketSoldEventResponse>() {
            @Override
            public TicketSoldEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(TICKETSOLD_EVENT, log);
                TicketSoldEventResponse typedResponse = new TicketSoldEventResponse();
                typedResponse.log = log;
                typedResponse.eventId = (BigInteger) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.buyer = (String) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.totalprice = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<TicketSoldEventResponse> ticketSoldEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(TICKETSOLD_EVENT));
        return ticketSoldEventFlowable(filter);
    }

    public List<TicketTypeCreatedEventResponse> getTicketTypeCreatedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(TICKETTYPECREATED_EVENT, transactionReceipt);
        ArrayList<TicketTypeCreatedEventResponse> responses = new ArrayList<TicketTypeCreatedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            TicketTypeCreatedEventResponse typedResponse = new TicketTypeCreatedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.eventId = (BigInteger) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.ticketTypeId = (BigInteger) eventValues.getIndexedValues().get(1).getValue();
            typedResponse.metadataURI = (String) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<TicketTypeCreatedEventResponse> ticketTypeCreatedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new io.reactivex.functions.Function<Log, TicketTypeCreatedEventResponse>() {
            @Override
            public TicketTypeCreatedEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(TICKETTYPECREATED_EVENT, log);
                TicketTypeCreatedEventResponse typedResponse = new TicketTypeCreatedEventResponse();
                typedResponse.log = log;
                typedResponse.eventId = (BigInteger) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.ticketTypeId = (BigInteger) eventValues.getIndexedValues().get(1).getValue();
                typedResponse.metadataURI = (String) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<TicketTypeCreatedEventResponse> ticketTypeCreatedEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(TICKETTYPECREATED_EVENT));
        return ticketTypeCreatedEventFlowable(filter);
    }

    public RemoteFunctionCall<TransactionReceipt> transferOwnership(String newOwner) {
        final Function function = new Function(
                FUNC_TRANSFEROWNERSHIP, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, newOwner)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<Tuple2<BigInteger, String>> events(BigInteger param0) {
        final Function function = new Function(FUNC_EVENTS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Utf8String>() {}));
        return new RemoteFunctionCall<Tuple2<BigInteger, String>>(function,
                new Callable<Tuple2<BigInteger, String>>() {
                    @Override
                    public Tuple2<BigInteger, String> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple2<BigInteger, String>(
                                (BigInteger) results.get(0).getValue(), 
                                (String) results.get(1).getValue());
                    }
                });
    }

    public RemoteFunctionCall<Tuple4<BigInteger, BigInteger, BigInteger, String>> eventTickets(BigInteger param0, BigInteger param1) {
        final Function function = new Function(FUNC_EVENTTICKETS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(param0), 
                new org.web3j.abi.datatypes.generated.Uint256(param1)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Utf8String>() {}));
        return new RemoteFunctionCall<Tuple4<BigInteger, BigInteger, BigInteger, String>>(function,
                new Callable<Tuple4<BigInteger, BigInteger, BigInteger, String>>() {
                    @Override
                    public Tuple4<BigInteger, BigInteger, BigInteger, String> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple4<BigInteger, BigInteger, BigInteger, String>(
                                (BigInteger) results.get(0).getValue(), 
                                (BigInteger) results.get(1).getValue(), 
                                (BigInteger) results.get(2).getValue(), 
                                (String) results.get(3).getValue());
                    }
                });
    }

    public RemoteFunctionCall<Event> getEventDetails(BigInteger eventId) {
        final Function function = new Function(FUNC_GETEVENTDETAILS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(eventId)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Event>() {}));
        return executeRemoteCallSingleValueReturn(function, Event.class);
    }

    public RemoteFunctionCall<String> owner() {
        final Function function = new Function(FUNC_OWNER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<BigInteger> ticketTypeIdsByEvent(BigInteger param0, BigInteger param1) {
        final Function function = new Function(FUNC_TICKETTYPEIDSBYEVENT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(param0), 
                new org.web3j.abi.datatypes.generated.Uint256(param1)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    @Deprecated
    public static EventManager load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new EventManager(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static EventManager load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new EventManager(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static EventManager load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new EventManager(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static EventManager load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new EventManager(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static class Event extends DynamicStruct {
        public BigInteger eventId;

        public String organizer;

        public Event(BigInteger eventId, String organizer) {
            super(new org.web3j.abi.datatypes.generated.Uint256(eventId),new org.web3j.abi.datatypes.Utf8String(organizer));
            this.eventId = eventId;
            this.organizer = organizer;
        }

        public Event(Uint256 eventId, Utf8String organizer) {
            super(eventId,organizer);
            this.eventId = eventId.getValue();
            this.organizer = organizer.getValue();
        }
    }

    public static class EventCreatedEventResponse extends BaseEventResponse {
        public BigInteger eventId;

        public String organizer;
    }

    public static class OwnershipTransferredEventResponse extends BaseEventResponse {
        public String previousOwner;

        public String newOwner;
    }

    public static class TicketSoldEventResponse extends BaseEventResponse {
        public BigInteger eventId;

        public String buyer;

        public BigInteger totalprice;
    }

    public static class TicketTypeCreatedEventResponse extends BaseEventResponse {
        public BigInteger eventId;

        public BigInteger ticketTypeId;

        public String metadataURI;
    }
}
