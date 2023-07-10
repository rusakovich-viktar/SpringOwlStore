package by.tms.springstore.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CartDto {
    private long amountProducts;
    private BigDecimal sum;
    @Builder.Default
    private List<CartDetailDto> cartDetails = new ArrayList<>();

    public void aggregate() {
        this.amountProducts = cartDetails.size();
        this.sum = cartDetails.stream()
                .map(CartDetailDto::getSum)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
