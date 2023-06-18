package by.tms.springstore.dto;


import by.tms.springstore.domain.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CartDetailDto {
    private String name;
    private Long productId;
    private BigDecimal price;
    @Builder.Default
    private Double amount = 1.0;
    private BigDecimal sum;

    public CartDetailDto(Product product) {
        this.name = product.getName();
        this.productId = product.getId();
        this.price = product.getPrice();
        this.amount = 1.0;
        this.sum = product.getPrice();
    }
}
