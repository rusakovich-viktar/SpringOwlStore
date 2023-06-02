package by.tms.springstore.domain;

import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class Cart {
    private Map<Integer, Product> products;
    BigDecimal totalPrice = BigDecimal.ZERO;

    public Cart() {
        this.products = new HashMap<>();
    }

    public void addProduct(Product product) {
        products.put(product.getId(), product);
        totalPrice = totalPrice.add(product.getPrice());
    }

    public void removeProduct(int productId) {
        Product product = products.get(productId);
        products.remove(productId);
        totalPrice = totalPrice.subtract(product.getPrice());
    }

    public List<Product> getProducts() {
        return new ArrayList<>(products.values());
    }

    public void clear() {
        products.clear();
    }

}
