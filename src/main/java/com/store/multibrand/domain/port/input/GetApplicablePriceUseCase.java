package com.store.multibrand.domain.port.input;

import com.store.multibrand.domain.model.Price;

import java.time.LocalDateTime;
import java.util.Optional;

public interface GetApplicablePriceUseCase {
    Optional<Price> execute(Long brandId, Long productId, LocalDateTime applicationDate);
}
