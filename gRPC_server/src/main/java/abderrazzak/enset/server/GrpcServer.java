package abderrazzak.enset.server;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import abderrazzak.enset.service.BankGrpcService;

import java.io.IOException;

public class GrpcServer {
    public static void main(String[] args) throws InterruptedException, IOException {
        Server server= ServerBuilder.forPort(9999)
                .addService(new BankGrpcService())
                .build();
        server.start();
        server.awaitTermination();
    }
}
