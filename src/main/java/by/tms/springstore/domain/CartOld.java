//package by.tms.springstore.domain;
//
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//import java.math.BigDecimal;
//import java.util.ArrayList;
//import java.util.List;
//
//@AllArgsConstructor
//@NoArgsConstructor
//@Getter
//@Setter
//public class Cart {
//
//    private List<Product> products = new ArrayList<>();
//
//    public void addProduct(Product myProduct) {
//        products.add(myProduct);
//    }
//
//    public void deleteProduct(Product myProduct) {
//        products.remove(myProduct);
//    }
//
//    public BigDecimal getTotalPrice() {
//        BigDecimal totalPrice = BigDecimal.ZERO;
//        for (Product product : products) {
//            totalPrice = totalPrice.add(product.getPrice());
//        }
//        return totalPrice;
//    }
//
//}
