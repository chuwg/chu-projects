package com.tistory.roobistory.serverarchitectureguide;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.io.IOException;

@SpringBootApplication
public class ServerArchitectureGuideApplication {
    public static void main(String[] args) throws IOException, InterruptedException {
        SpringApplication.run(ServerArchitectureGuideApplication.class, args);
        final ProductInfoServer server = new ProductInfoServer();
        server.start();
        server.blockUntilShutdown();
    }
}