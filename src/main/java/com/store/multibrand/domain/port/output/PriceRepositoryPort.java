package com.store.multibrand.domain.port.output;

import com.store.multibrand.domain.model.Price;

import java.time.LocalDateTime;
import java.util.List;

public interface PriceRepositoryPort {
    List<Price> findPricesByDate(Long brandId, Long productId, LocalDateTime applicationDate);
}
