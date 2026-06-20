package com.store.multibrand.infrastructure.adapter.output.persistence;


import com.store.multibrand.domain.model.Price;
import com.store.multibrand.domain.port.output.PriceRepositoryPort;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PricePersistenceAdapter implements PriceRepositoryPort {

    private final SpringDataPriceRepository repository;

    public PricePersistenceAdapter(SpringDataPriceRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Price> findPricesByDate(Long brandId, Long productId, LocalDateTime applicationDate) {
        List<PriceEntity> entities = repository.findPricesByDate(brandId, productId, applicationDate);

        return entities.stream()
                .map(entity -> new Price(
                        entity.getBrandId(),
                        entity.getStartDate(),
                        entity.getEndDate(),
                        entity.getPriceList(),
                        entity.getProductId(),
                        entity.getPriority(),
                        entity.getPrice(),
                        entity.getCurrency()
                ))
                .collect(Collectors.toList());
    }
}