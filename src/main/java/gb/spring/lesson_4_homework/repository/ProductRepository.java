package gb.spring.lesson_4_homework.repository;

import gb.spring.lesson_4_homework.model.Product;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Repository
public class ProductRepository {
    private final Map<Long, Product> productDb;
    private AtomicLong counter = new AtomicLong();

    public ProductRepository() {
        this.productDb = new ConcurrentHashMap<>();
        productDb.put(counter.incrementAndGet(), Product.builder()
                .id(counter.get())
                .title("wood")
                .cost(50)
                .company("Sony")
                .build());
        productDb.put(counter.incrementAndGet(), Product.builder()
                .id(counter.get())
                .title("iron")
                .cost(60)
                .company("Jonson")
                .build());
        productDb.put(counter.incrementAndGet(), Product.builder()
                .id(counter.get())
                .title("glass")
                .cost(70)
                .company("Jonson")
                .build());
        productDb.put(counter.incrementAndGet(), Product.builder()
                .id(counter.get())
                .title("rock")
                .cost(35)
                .company("Sputnik")
                .build());
        productDb.put(counter.incrementAndGet(), Product.builder()
                .id(counter.get())
                .title("plastic")
                .cost(90)
                .company("Mask")
                .build());

    }

    public List<Product> findAll() {
        return productDb.values().stream()
                .collect(Collectors.toUnmodifiableList());
    }

    public Optional<Product> findByID(Long id) {
        return productDb.values().stream()
                .filter(it -> Objects.equals(it.getId(), id))
                .findFirst();

    }

    public void addProduct(Product product) {
        if (product.getId() == null) {
            product.setId(counter.incrementAndGet());
        }
        productDb.put(product.getId(), product);
    }

    public void deleteById(Long id) {
        productDb.remove(id);
    }
}
