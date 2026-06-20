package com.store.multibrand.infrastructure.adapter.output.persistence;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "PRICES")
public class PriceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * foreign key de la cadena del grupo (1 = ZARA)
     */
    @Column(name = "BRAND_ID")
    private Long brandId;

    /**
     * Fecha inicio para el rango de fechas en el que aplica el precio tarifa indicado
     */
    @Column(name = "START_DATE")
    private LocalDateTime startDate;

    /**
     * Fecha fin para el rango de fechas en el que aplica el precio tarifa indicado
     */
    @Column(name = "END_DATE")
    private LocalDateTime endDate;

    /**
     * Identificador de la tarifa de precios aplicable.
     */
    @Column(name = "PRICE_LIST")
    private Integer priceList;

    /**
     *  Identificador código de producto.
     */
    @Column(name = "PRODUCT_ID")
    private Long productId;

    /**
     * Desambiguador de aplicación de precios.
     * Si dos tarifas coinciden en un rago de fechas se aplica la de mayor prioridad (mayor valor numérico).
     */
    @Column(name = "PRIORITY")
    private Integer priority;

    /**
     * Precio final de venta
     */
    @Column(name = "PRICE")
    private BigDecimal price;

    /**
     * Código iso de la moneda
     */
    @Column(name = "CURR")
    private String currency;

    public PriceEntity() {
    }

    public PriceEntity(Long id, Long brandId, LocalDateTime startDate, LocalDateTime endDate,
                       Integer priceList, Long productId, Integer priority, BigDecimal price, String currency) {
        this.id = id;
        this.brandId = brandId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.priceList = priceList;
        this.productId = productId;
        this.priority = priority;
        this.price = price;
        this.currency = currency;
    }

    // --- GETTERS Y SETTERS ---

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getBrandId() { return brandId; }
    public void setBrandId(Long brandId) { this.brandId = brandId; }

    public LocalDateTime getStartDate() { return startDate; }
    public void setStartDate(LocalDateTime startDate) { this.startDate = startDate; }

    public LocalDateTime getEndDate() { return endDate; }
    public void setEndDate(LocalDateTime endDate) { this.endDate = endDate; }

    public Integer getPriceList() { return priceList; }
    public void setPriceList(Integer priceList) { this.priceList = priceList; }

    public Long getProductId() { return productId; }
    public void setProductId(Long productId) { this.productId = productId; }

    public Integer getPriority() { return priority; }
    public void setPriority(Integer priority) { this.priority = priority; }

    public BigDecimal getPrice() { return price; }
    public void setPrice(BigDecimal price) { this.price = price; }

    public String getCurrency() { return currency; }
    public void setCurrency(String currency) { this.currency = currency; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PriceEntity that = (PriceEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}