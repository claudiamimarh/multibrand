package com.store.multibrand.infrastructure.adapter.output.persistence;

import com.store.multibrand.domain.model.Price;
import com.store.multibrand.domain.port.output.PriceRepositoryPort;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class PricePersistenceAdapter implements PriceRepositoryPort {

    private final SpringDataPriceRepository repository;

    public PricePersistenceAdapter(SpringDataPriceRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<Price> findPricesByDate(Long brandId, Long productId, LocalDateTime applicationDate) {
        Optional<PriceEntity> priceEntity = repository.findFirstByBrandIdAndProductIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityDesc(brandId, productId, applicationDate, applicationDate);

        return priceEntity
                .map(entity -> new Price(
                entity.getBrandId(),
                entity.getStartDate(),
                entity.getEndDate(),
                entity.getPriceList(),
                entity.getProductId(),
                entity.getPriority(),
                entity.getPrice(),
                entity.getCurrency()
        ));
    }
}