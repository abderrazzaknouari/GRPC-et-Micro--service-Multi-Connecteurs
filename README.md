# gRPC Web Service Example

This project showcases the creation and consumption of a gRPC web service using Java. It includes implementations of the four gRPC communication models: Unary, Server Streaming, Client Streaming, and BiDirectional Streaming.

## Features

- Currency conversion utilizing various gRPC communication models:
    - Unary Model
    - Server Streaming Model
    - Client Streaming Model
    - BiDirectional Streaming Model

## Requirements

- Java Development Kit (JDK)
- Apache Maven
- IntelliJ IDEA (optional)
- BloomRPC (or any other gRPC testing tool)

## Why gRPC?

gRPC (gRPC Remote Procedure Calls) is a remote procedure call framework developed by Google. It facilitates efficient, fast, and scalable communication between applications. gRPC uses HTTP/2 for transport, Protocol Buffers for serialization, and offers features such as bidirectional streaming, concurrency control, timeouts, cancellation, and more.

## Deploying the gRPC Service

1. Clone the repository:
   ```bash
   git clone https://github.com/ELMOUADDIBE/Demo_gRPC
   ```

2. Build and run the gRPC server:
   ```bash
   mvn clean install
   mvn exec:java -Dexec.mainClass="server.abderrazzak.enset.GrpcServer"
   ```

3. The gRPC server will start on port `9999`.


## gRPC Service Architecture

Below is the architecture of the gRPC service with the four communication models defined in `ebank.proto`.

```proto
syntax = "proto3";

option java_package = "ma.enset.stubs";

service BankService {
  rpc convert(ConvertCurrencyRequest) returns (ConvertCurrencyResponse);
  rpc performStream(stream ConvertCurrencyRequest) returns (ConvertCurrencyResponse);
  rpc getStream(ConvertCurrencyRequest) returns (stream ConvertCurrencyResponse);
  rpc fullStream(stream ConvertCurrencyRequest) returns (stream ConvertCurrencyResponse);
}

message ConvertCurrencyRequest {
  double amount = 1;
  string currencyFrom = 2;
  string currencyTo = 3;
}

message ConvertCurrencyResponse {
  double amount = 1;
  string currencyFrom = 2;
  string currencyTo = 3;
  double result = 4;
}
```

## Implementing the gRPC Service

The gRPC service implementation involves several key components:

### gRPC Service

The gRPC service is implemented using the interface generated from the `.proto` file. It defines four main methods corresponding to the four gRPC communication models:
- **Unary Model**: A single request and a single response. Implemented by the `convert` method.
- **Server Streaming Model**: A single request and multiple responses. Implemented by the `getStream` method.
- **Client Streaming Model**: Multiple requests and a single response. Implemented by the `performStream` method.
- **BiDirectional Streaming Model**: Multiple requests and multiple responses. Implemented by the `fullStream` method.

### Starting the gRPC Server

The gRPC server is started using `ServerBuilder` to bind the gRPC service to a specific port (in this case, 9999). Once started, the server listens for connections and remote procedure calls.

### gRPC Client

Two types of gRPC clients are implemented:
- **Unary Model gRPC Client**: Uses a blocking stub to send a request and receive a response.
- **Asynchronous gRPC Client**: Uses an asynchronous stub to send a request and handle the response asynchronously.

## Conclusion

This example demonstrates how to implement and consume a gRPC service using Java, covering all four communication models. gRPC provides efficient and fast communication, making it ideal for modern distributed systems.
