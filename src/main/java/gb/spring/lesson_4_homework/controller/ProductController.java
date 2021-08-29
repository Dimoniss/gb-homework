package gb.spring.lesson_4_homework.controller;

import gb.spring.lesson_4_homework.model.Product;
import gb.spring.lesson_4_homework.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

@Controller
@RequestMapping("/product")
@Log4j2
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public String findAll(Model model) {
        model.addAttribute("products", productService.findAll());
        return "product";
    }

    @GetMapping("/filter")
    public String findByTitleAndCost(@RequestParam String title, @RequestParam Integer cost) {
        log.info(title, cost);
        return "product";
    }

    @GetMapping("/search/{id}")
    public String findById(@PathVariable Long id, Model model) {
        model.addAttribute("products", productService.findByID(id));
        return "product";
    }

    @PostMapping
    public String addProduct(@ModelAttribute() @Valid Product product) {
        productService.addProduct(product);
        log.info(product.toString());
        return "redirect:/product";
    }

    @GetMapping("/delete/{id}")
    public String deleteById(@PathVariable Long id) {
        productService.deleteById(id);
        return "redirect:/product";
    }
}
