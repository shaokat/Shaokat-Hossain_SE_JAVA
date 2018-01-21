package com.shaokat.controller;
import com.shaokat.Service.ProductService;
import com.shaokat.model.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.nio.file.Path;

@Controller
public class ProductController {

    private Path path;
    @Autowired
    private ProductService productService;
    @GetMapping("/")
    public String home1() {
        return "home";
    }

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @GetMapping("/dashboard")

    public String admin(Model model) {

        model.addAttribute("allProducts",productService.getAllProducts());
        return "dashboard";
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/403")
    public String error403() {
        return "error/403";
    }

    @GetMapping("/product/list")
    public String AllProducts(Model model){

        model.addAttribute("allProducts",productService.getAllProducts());

        return"productList";
    }

    @GetMapping("/product/create")
    public String createNewProduct(Model model){

        model.addAttribute("product", new Product());
        return "createProduct";

    }

    @PostMapping("/product/create")
    public String createNewProduct(@ModelAttribute("proudct") Product product,
                                   RedirectAttributes redirctAttribs, HttpServletRequest request) {

        productService.create(product);
        redirctAttribs.addFlashAttribute("confirmationMessage", "product was created successfully");
        return "redirect:/product/list";

    }

    @GetMapping("/product/edit/{productId}")
    public String editProduct(@PathVariable long productId, Model model){
        Product selectedProduct = productService.select(productId);
        model.addAttribute("selectedProduct", selectedProduct);
        return "editProduct";

    }
    @PostMapping("/product/edit")
    public String editProduct(@ModelAttribute("selectedProduct") Product product,
                              RedirectAttributes redirctAttribs){
        productService.update(product);
        redirctAttribs.addFlashAttribute("confirmationMessage", "product was edited successfully");
        return "redirect:/product/list";
    }

    @GetMapping("/product/delete/{productId}")
    public String deleteProduct(@PathVariable long productId, Model model){
        Product selectedProduct = productService.select(productId);
        model.addAttribute("selectedProduct", selectedProduct);
        return "deleteProduct";

    }
    @PostMapping("/product/delete")
    public String deleteProduct(@ModelAttribute("selectedProduct") Product product,
                                RedirectAttributes redirctAttribs){
        System.err.println("id of the selected product:"+product.getId());
        productService.delete(product.getId());
        redirctAttribs.addFlashAttribute("confirmationMessage", "product was deleted successfully");
        return "redirect:/product/list";
    }
}