package com.store.multibrand.domain.port.output;

import com.store.multibrand.domain.model.Price;

import java.time.LocalDateTime;
import java.util.Optional;

public interface PriceRepositoryPort {
    Optional<Price> findPricesByDate(Long brandId, Long productId, LocalDateTime applicationDate);
}
