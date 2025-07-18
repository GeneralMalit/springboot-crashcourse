package com.example.demo.myfirstapi.model;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class ProductTest {

    @Test
    void testNoIdConstructorAndGetters() {
        Product product = new Product("test product", 10.99);
        assertNull(product.getId());
        assertEquals("test product", product.getName());
        assertEquals(10.99, product.getPrice(), 0.001);
    }

    @Test
    void testAllArgsConstructorAndGetters() {
        Product product = new Product(1L, "another product", 25.00);
        assertEquals(1L, product.getId());
        assertEquals("another product", product.getName());
        assertEquals(25.00, product.getPrice(), 0.001);
    }

    @Test
    void testSetters() {
        Product product = new Product("product name 1", 5.00);
        product.setId(99L);
        product.setName("product new name");
        product.setPrice(15.75);

        assertEquals(99L, product.getId());
        assertEquals("product new name", product.getName());
        assertEquals(15.75, product.getPrice(), 0.001);
    }

    @Test
    void testEqualsAndHashCode() {
        Product product1 = new Product(1L, "Item A", 100.0);
        Product product2 = new Product(1L, "Item A", 100.0); // Identical to product1
        Product product3 = new Product(2L, "Item B", 200.0);
        Product product4 = new Product(1L, "Item X", 100.0);
        Product product5 = new Product(1L, "Item A", 150.0);

        assertEquals(product1, product2);
        assertNotEquals(product1, product3);
        assertNotEquals(product1, product4);
        assertNotEquals(product1, product5);

        //hash codes test
        assertEquals(product1.hashCode(), product2.hashCode());
        assertNotEquals(product1.hashCode(), product3.hashCode());
    }

    @Test
    void testToString() {
        Product product = new Product(5L, "Test Item", 50.50);
        String expectedToString = "Product{id=5, name='Test Item', price=50.5}";
        assertEquals(expectedToString, product.toString());
    }
}