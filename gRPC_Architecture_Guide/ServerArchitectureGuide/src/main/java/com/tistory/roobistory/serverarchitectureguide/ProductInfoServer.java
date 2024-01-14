package com.tistory.roobistory.serverarchitectureguide;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import java.io.IOException;
import java.util.logging.Logger;

public class ProductInfoServer {

    private static final Logger logger = Logger.getLogger(ProductInfoServer.class.getName());

    private Server server;

    void start() throws IOException {
        /* The port on which the server should run */
        int port = 50051;
        server = ServerBuilder.forPort(port)
                // 서버 인스턴스는 포트 50051로 생성되며, 서버가 바인딩 하여 메시지를 수신하는 포트입니다.
                .addService(new ProductInfoImpl())
                // ProductInfo 서비스 구현이 서버에 추가 됩니다.
                .build()
                .start();
        logger.info("Server started, listening on " + port);
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            // JVM 종료 시 gRPC 서버를 종료하고자 런타임 종료 후크 (Runtime ShutDown Hook) 가 추가됩니다.
            logger.info("*** shutting down gRPC server since JVM is shutting down");
            ProductInfoServer.this.stop();
            logger.info("*** server shut down");
        }));
    }

    private void stop() {
        if (server != null) {
            server.shutdown();
        }
    }

    /**
     * Await termination on the main thread since the grpc library uses daemon threads.
     */
    void blockUntilShutdown() throws InterruptedException {
        if (server != null) {
            server.awaitTermination();
            // 메서드 끝에서 서버 스레드는 서버가 종료될 때까지 기다립니다.
        }
    }
}