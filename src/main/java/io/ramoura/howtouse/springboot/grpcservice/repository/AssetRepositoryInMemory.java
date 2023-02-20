package io.ramoura.howtouse.springboot.grpcservice.repository;

import io.ramoura.howtouse.springboot.grpcservice.model.Asset;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Component
public class AssetRepositoryInMemory implements AssetRepository {

    private Map<String, Asset> memory = Collections.synchronizedMap(new HashMap<>());

    @Override
    public Asset create(Asset asset) {
        if (asset.getAssetId() != null) throw new IllegalArgumentException("To create an Asset, the id must be null.");
        var id = UUID.randomUUID().toString();

        var savedAsset = asset.withAssetId(id);

        memory.put(id, savedAsset);
        return savedAsset;
    }

    @Override
    public Optional<Asset> find(String id) {
        if (id == null) throw new IllegalArgumentException("To find an Asset, the id not must be null.");

        return memory.containsKey(id)
            ? Optional.of(memory.get(id))
            : Optional.empty();
    }
}
