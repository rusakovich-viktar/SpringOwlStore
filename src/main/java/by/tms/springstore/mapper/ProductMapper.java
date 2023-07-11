package by.tms.springstore.mapper;

import by.tms.springstore.domain.Cart;
import by.tms.springstore.domain.Order;
import by.tms.springstore.domain.Product;
import by.tms.springstore.dto.CartDetailDto;
import by.tms.springstore.dto.CartDto;
import java.util.List;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface ProductMapper {

//    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    Cart cartDtoToCart(CartDto cartDto);

    List<Product> convertToProducts(List<CartDetailDto> cartDetailDtos);

}