package io.ramoura.howtouse.springboot.grpcservice;

import io.grpc.ServerBuilder;
import io.ramoura.howtouse.springboot.grpcservice.grpc.GrpcServer;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class GrpcServiceApplication implements ApplicationRunner {

	private final GrpcServer grpcServer;

	public static void main(String[] args) {
		SpringApplication.run(GrpcServiceApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		grpcServer.start();
		grpcServer.block();
	}
}
