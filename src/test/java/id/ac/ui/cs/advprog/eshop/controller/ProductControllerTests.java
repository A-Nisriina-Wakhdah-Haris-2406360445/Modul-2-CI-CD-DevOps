package id.ac.ui.cs.advprog.eshop.controller;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.repository.ProductRepository;
import id.ac.ui.cs.advprog.eshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ProductController.class)
public class ProductControllerTests {

  @Autowired
  private MockMvc mockMVC;

  @MockBean
  private ProductService service;

  @MockBean
  private ProductRepository productRepository;

  @Test
  void testCreateProductPage() throws Exception {
    mockMVC.perform(get("/product/create"))
        .andExpect(status().isOk())
        .andExpect(view().name("CreateProduct"))
        .andExpect(model().attributeExists("product"));

  }

}
