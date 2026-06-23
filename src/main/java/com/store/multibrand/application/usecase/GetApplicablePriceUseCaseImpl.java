package com.store.multibrand.application.usecase;

import com.store.multibrand.domain.model.Price;
import com.store.multibrand.domain.port.input.GetApplicablePriceUseCase;
import com.store.multibrand.domain.port.output.PriceRepositoryPort;

import java.time.LocalDateTime;
import java.util.Optional;

public class GetApplicablePriceUseCaseImpl implements GetApplicablePriceUseCase {

    private final PriceRepositoryPort priceRepositoryPort;

    public GetApplicablePriceUseCaseImpl(PriceRepositoryPort priceRepositoryPort) {
        this.priceRepositoryPort = priceRepositoryPort;
    }

    @Override
    public Optional<Price> execute(Long brandId, Long productId, LocalDateTime applicationDate) {
        return priceRepositoryPort.findPricesByDate(brandId, productId, applicationDate);
    }
}