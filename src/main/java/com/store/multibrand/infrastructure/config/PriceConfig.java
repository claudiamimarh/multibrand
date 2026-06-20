package com.store.multibrand.infrastructure.config;

import com.store.multibrand.application.usecase.GetApplicablePriceUseCaseImpl;
import com.store.multibrand.domain.port.input.GetApplicablePriceUseCase;
import com.store.multibrand.domain.port.output.PriceRepositoryPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PriceConfig {

    @Bean
    public GetApplicablePriceUseCase getApplicablePriceUseCase(PriceRepositoryPort priceRepositoryPort) {
        return new GetApplicablePriceUseCaseImpl(priceRepositoryPort);
    }
}