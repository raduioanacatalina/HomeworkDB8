package com.raducatalianhomework8.raducatalianhomework8;

import com.raducatalianhomework8.raducatalianhomework8.model.ShoppingCart;
import com.raducatalianhomework8.raducatalianhomework8.repository.ShoppingCartRepository;
import com.raducatalianhomework8.raducatalianhomework8.service.ShoppingCartService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ShoppingCartServiceTest {
    @Mock
    ShoppingCartRepository shoppingCartRepository;

    @InjectMocks
    ShoppingCartService shoppingCartService;

    @Test
    public void it_should_get_all_shoping_carts(){
        ShoppingCart shoppingCart = new ShoppingCart();
        List<ShoppingCart> shoppingCartArrayList = new ArrayList<>();
        shoppingCartArrayList.add(shoppingCart);
        when(shoppingCartRepository.findAll()).thenReturn(shoppingCartArrayList);
        List<ShoppingCart> createdShoppingCarts = shoppingCartService.getAll();
        assertThat(createdShoppingCarts.size()).isSameAs(shoppingCartArrayList.size());
    }
}
