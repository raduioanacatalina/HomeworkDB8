package com.raducatalianhomework8.raducatalianhomework8;

import com.raducatalianhomework8.raducatalianhomework8.controller.ProductController;
import com.raducatalianhomework8.raducatalianhomework8.service.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ProductController.class)
public class ProductControllerTest {
    @MockBean
    ProductService productService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void it_should_add_product() throws Exception {
        String request = new String("{\"name\" : \"Frigider\", \"stock\" : \"100\", \"type\" : \"ELB\",\"deleted\" : \"false\", \"price\" : \"900\"}");

        mockMvc.perform(post("/add")
                        .content(request)
                        .contentType(MediaType.APPLICATION_JSON))
                         .andExpect(status().isOk());
    }
}
