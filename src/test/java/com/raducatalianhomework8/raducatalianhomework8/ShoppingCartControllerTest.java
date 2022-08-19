package com.raducatalianhomework8.raducatalianhomework8;

import com.raducatalianhomework8.raducatalianhomework8.controller.ShoppingCartController;
import com.raducatalianhomework8.raducatalianhomework8.service.ShoppingCartService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ShoppingCartController.class)
public class ShoppingCartControllerTest {
    @MockBean
    ShoppingCartService shoppingCartService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void it_should_get_all_shopping_carts() throws Exception{
        mockMvc.perform(get("/shoppingCart/all"))
                .andExpect(status().isOk());
    }
}
