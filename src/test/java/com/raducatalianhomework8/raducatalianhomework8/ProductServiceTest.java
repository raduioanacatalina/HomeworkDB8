package com.raducatalianhomework8.raducatalianhomework8;

import com.raducatalianhomework8.raducatalianhomework8.model.Product;
import com.raducatalianhomework8.raducatalianhomework8.model.Type;
import com.raducatalianhomework8.raducatalianhomework8.repository.ProductRepository;
import com.raducatalianhomework8.raducatalianhomework8.service.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceTest {
    @Mock
    ProductRepository productRepository;

    @InjectMocks
    ProductService productService;

    @Test
    public void it_should_add_product(){
        Product product = new Product(null,"Frigider",100, Type.ELB,false,900);
        when(productRepository.save(any(Product.class))).thenReturn(product);
        Product created = productService.insert(product);
        assertThat(created.getName()).isSameAs(product.getName());
    }
}
