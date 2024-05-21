package abderrazzak.enset.client;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import abderrazzak.enset.stubs.BankServiceGrpc;
import abderrazzak.enset.stubs.Ebank;

public class BankGrpcClient1 {
    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9999)
                .usePlaintext()
                .build();

        BankServiceGrpc.BankServiceBlockingStub blockingStub = BankServiceGrpc.newBlockingStub(channel);

        Ebank.ConvertCurrencyRequest request = Ebank.ConvertCurrencyRequest.newBuilder()
                .setCurrencyFrom("MAD")
                .setCurrencyTo("USD")
                .setAmount(100)
                .build();

        Ebank.ConvertCurrencyResponse response = blockingStub.convert(request);

        System.out.println(response);
    }
}
