package com.jeferro.hexagonal.application;

import com.jeferro.hexagonal.domain.models.Product;
import com.jeferro.hexagonal.domain.repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CreateProductUseCaseImplTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private CreateProductUseCaseImpl createProductUseCaseImpl;

    @Test
    public void when_data_is_correct_then_create_new_product() {
        var id = 1L;
        var name = "Apple";
        var description = "About apple";

        when(productRepository.save(any(Product.class)))
                .thenAnswer(i -> i.getArguments()[0]);

        var product = createProductUseCaseImpl.execute(id, name, description);

        var expectedProduct = new Product(id, name, description);
        assertEquals(expectedProduct, product);
    }

}