package com.store.multibrand.infrastructure.adapter.input.rest.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * DTO inmutable que expone exactamente los campos solicitados como salida.
 */
public record PriceResponse(
        Long productId,
        Long brandId,
        Integer priceList,
        LocalDateTime startDate,
        LocalDateTime endDate,
        BigDecimal price
) { }