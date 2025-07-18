package com.example.demo.myfirstapi.repository;


import com.example.demo.myfirstapi.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


public class ProductRepositoryTest {

    private ProductRepository productRepository;

    @BeforeEach
    void setUp() {
        productRepository = new ProductRepository();
    }

    @Test
    void testRepositoryInitialization() {
        List<Product> products = productRepository.findAll();
        assertNotNull(products);
        assertEquals(3, products.size());

        assertEquals("Laptop", products.get(0).getName());
        assertEquals(1L, products.get(0).getId());
        assertEquals("Mouse", products.get(1).getName());
        assertEquals(2L, products.get(1).getId());
    }

    @Test
    void testFindAll() {
        List<Product> products = productRepository.findAll();
        assertEquals(3, products.size());
        products.add(new Product("POWER SUPPLY", 10.0));
        assertEquals(3, productRepository.findAll().size());
    }

    @Test
    void testFindById_existingProduct() {
        Optional<Product> foundProduct = productRepository.findById(1L);

        assertTrue(foundProduct.isPresent());
        assertEquals(1L, foundProduct.get().getId());
        assertEquals("Laptop", foundProduct.get().getName());
    }

    @Test
    void testFindById_nonExistingProduct() {
        // product id 99L does not exist.
        Optional<Product> foundProduct = productRepository.findById(99L);

        assertFalse(foundProduct.isPresent());
    }

    @Test
    void testSave_newProduct() {
        Product newProduct = new Product("Gaming Smartphone", 340.00);
        assertNull(newProduct.getId()); //new product doesnt have an id

        Product savedProduct = productRepository.save(newProduct);

        assertNotNull(savedProduct);
        assertNotNull(savedProduct.getId());
        assertEquals(4L, savedProduct.getId());
        assertEquals("Gaming Smartphone", savedProduct.getName());
        assertEquals(340.00, savedProduct.getPrice(), 0.0001);

        // Verify that gaming smartphone is now in the list.
        assertEquals(4, productRepository.findAll().size());
        assertTrue(productRepository.findById(4L).isPresent());
    }

    @Test
    void testSave_updateExistingProduct() {
        Product existingProduct = productRepository.findById(1L).get();
        existingProduct.setName("Extreme gaming pc");
        existingProduct.setPrice(4500.00);

        Product updatedProduct = productRepository.save(existingProduct);

        assertNotNull(updatedProduct);
        assertEquals(1L, updatedProduct.getId());
        assertEquals("Extreme gaming pc", updatedProduct.getName());
        assertEquals(4500.00, updatedProduct.getPrice(), 0.001);

        // Verify the repository reflects the update
        Optional<Product> retrievedProduct = productRepository.findById(1L);
        assertTrue(retrievedProduct.isPresent());
        assertEquals("Extreme gaming pc", retrievedProduct.get().getName());
        assertEquals(4500.00, retrievedProduct.get().getPrice(), 0.001);
        assertEquals(3, productRepository.findAll().size());
    }

    @Test
    void testSave_updateNonExistingId() {
        Product nonExistingIdProduct = new Product(99L, "new test product", 500.00);

        Product result = productRepository.save(nonExistingIdProduct);

        assertNotNull(result);
        assertEquals(99L, result.getId());
        assertEquals("new test product", result.getName());
        assertEquals(3, productRepository.findAll().size());
        assertFalse(productRepository.findById(99L).isPresent());
    }
}

