package io.ramoura.howtouse.springboot.grpcservice.usecase;

import io.ramoura.howtouse.springboot.grpcservice.model.Asset;
import io.ramoura.howtouse.springboot.grpcservice.repository.AssetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CreateAssetUseCase {

    private final AssetRepository assetRepository;
    public Asset createAsset(Asset asset) {
        return assetRepository.create(asset);
    }

    public Asset find(String id){
        Optional<Asset> asset = assetRepository.find(id);
        return asset.orElseThrow(RuntimeException::new);
    }

}
