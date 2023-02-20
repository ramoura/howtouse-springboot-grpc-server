package io.ramoura.howtouse.springboot.grpcservice.repository;

import io.ramoura.howtouse.springboot.grpcservice.model.Asset;

import java.util.Optional;

public interface AssetRepository {
    Asset create(Asset asset);
    Optional<Asset> find(String id);

}
