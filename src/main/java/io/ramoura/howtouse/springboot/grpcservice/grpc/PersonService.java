package io.ramoura.howtouse.springboot.grpcservice.grpc;



import io.grpc.stub.StreamObserver;
import io.ramoura.api.grpc.v1.PersonServiceGrpc.PersonServiceImplBase;
import org.springframework.stereotype.Service;
import io.ramoura.api.grpc.v1.*;

import java.util.UUID;

@Service
public class PersonService extends PersonServiceImplBase {

    /*
    * Poderiamos utilizar um repositorio por exemplo
    * */
    @Override
    public void create(PersonRequest request, StreamObserver<PersonResponse> responseObserver) {
        var resp = PersonResponse.newBuilder()
                .setCode(UUID.randomUUID().toString())
                .build();

        responseObserver.onNext(resp);
        responseObserver.onCompleted();
    }

    @Override
    public void find(PersonRequestCode request, StreamObserver<PersonResponse> responseObserver) {
        var resp = PersonResponse.newBuilder()
                .setCode(UUID.randomUUID().toString())
                .build();

        responseObserver.onNext(resp);
        responseObserver.onCompleted();
    }
}
