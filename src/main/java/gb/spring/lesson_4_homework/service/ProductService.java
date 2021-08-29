package gb.spring.lesson_4_homework.service;

import gb.spring.lesson_4_homework.model.Product;
import gb.spring.lesson_4_homework.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;


@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product findByID(Long id) {
        return productRepository.findByID(id).orElseThrow(() -> new NoSuchElementException());

    }


    public void addProduct(Product product) {
        productRepository.addProduct(product);
    }

    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }
}
