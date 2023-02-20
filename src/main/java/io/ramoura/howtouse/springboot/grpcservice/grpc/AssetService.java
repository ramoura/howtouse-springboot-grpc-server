package io.ramoura.howtouse.springboot.grpcservice.grpc;



import io.grpc.stub.StreamObserver;
import io.ramoura.api.grpc.v1.AssetCreateRequest;
import io.ramoura.api.grpc.v1.AssetFindRequest;
import io.ramoura.api.grpc.v1.AssetResponse;
import io.ramoura.api.grpc.v1.AssetServiceGrpc.AssetServiceImplBase;
import io.ramoura.howtouse.springboot.grpcservice.mapper.AssetMapper;
import io.ramoura.howtouse.springboot.grpcservice.model.Asset;
import io.ramoura.howtouse.springboot.grpcservice.usecase.CreateAssetUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AssetService extends AssetServiceImplBase {

    private final CreateAssetUseCase createAssetUseCase;

    @Override
    public void create(AssetCreateRequest request, StreamObserver<AssetResponse> responseObserver) {

        Asset asset = createAssetUseCase.createAsset(AssetMapper.toAsset(request));
        AssetResponse response = AssetMapper.toResponse(asset);


        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void find(AssetFindRequest request, StreamObserver<AssetResponse> responseObserver) {
        Asset asset = createAssetUseCase.find(request.getAssetId());
        AssetResponse response = AssetMapper.toResponse(asset);

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
