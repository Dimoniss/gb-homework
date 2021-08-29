package gb.spring.lesson_4_homework.controller.rest;

import gb.spring.lesson_4_homework.model.Product;
import gb.spring.lesson_4_homework.properties.MyProperty;
import gb.spring.lesson_4_homework.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest")
@RequiredArgsConstructor
public class ProductRestController {

    private final ProductService productService;

    private final MyProperty myProperty;

    @PostMapping("/add")
    public String addProduct(@RequestBody Product product) {
        productService.addProduct(product);
        return "add OK";
    }

    @GetMapping ("/delete/{id}")
    public String deleteById(@PathVariable Long id) {
        productService.deleteById(id);
        return "delete OK";
    }

    @GetMapping("/my-property")
    public String rest2() {
        return myProperty.toString();
    }


}
