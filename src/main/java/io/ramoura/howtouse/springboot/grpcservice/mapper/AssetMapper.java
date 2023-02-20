package io.ramoura.howtouse.springboot.grpcservice.mapper;

import io.ramoura.api.grpc.v1.AssetCreateRequest;
import io.ramoura.api.grpc.v1.AssetResponse;
import io.ramoura.howtouse.springboot.grpcservice.model.Asset;
import lombok.experimental.UtilityClass;

@UtilityClass
public class AssetMapper {

    public static AssetResponse toResponse(final Asset dto) {
        return AssetResponse
            .newBuilder()
            .setAssetId(dto.getAssetId())
            .setTicker(dto.getTicker())
            .setLongName(dto.getLongName())
            .setShortName(dto.getShortName())
            .setCurrencyCode(dto.getCurrencyCode())
            .build();
    }

    public static Asset toAsset(final AssetCreateRequest request) {
        return Asset.builder()
            .ticker(request.getTicker())
            .longName(request.getLongName())
            .shortName(request.getShortName())
            .currencyCode(request.getCurrencyCode())
            .build();
    }


}
