package id.ac.ui.cs.advprog.eshop.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class ProductTest {
    Product product;

    @BeforeEach
    void setUp(){
        this.product = new Product();
        this.product.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        this.product.setProductName("Sampo Cap Bambang");
        this.product.setProductQuantity(100);
    }

    @Test
    void testGetProductId(){
        // positive case
        assertEquals("eb558e9f-1c39-460e-8860-71af6af63bd6", this.product.getProductId());

        // negative case
        Product emptyProduct = new Product();
        assertNull(emptyProduct.getProductId());
        assertNotEquals("123", this.product.getProductId());
    }

    @Test
    void testGetProductName(){

        // positive case
        assertEquals("Sampo Cap Bambang", this.product.getProductName());

        // negative case
        product.setProductName(null);
        assertNull(product.getProductName());
        assertNotEquals("Sampo Cap bambang", this.product.getProductName());
    }

    @Test
    void testGetProductQuantity(){

        // positive case
        assertEquals(100, this.product.getProductQuantity());

        // negative case
        product.setProductQuantity(0);
        assertEquals(0, product.getProductQuantity());
        assertNotEquals(10, this.product.getProductQuantity());
    }
}
