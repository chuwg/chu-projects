package com.tistory.roobistory.productserver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.io.IOException;


@SpringBootApplication
public class ProductServerApplication {
    public static void main(String[] args) throws IOException, InterruptedException {
        SpringApplication.run(ProductServerApplication.class, args);
        final ProductInfoServer server = new ProductInfoServer();
        server.start();
        server.blockUntilShutdown();

    }
}