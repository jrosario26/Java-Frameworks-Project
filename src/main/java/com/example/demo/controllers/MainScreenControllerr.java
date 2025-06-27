package com.example.demo.controllers;

import com.example.demo.domain.Part;
import com.example.demo.domain.Product;
import com.example.demo.repositories.PartRepository;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.service.PartService;
import com.example.demo.service.ProductService;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Arrays;
import java.util.List;

/**
 *
 *
 *
 *
 */

@Controller
@RequestMapping("/")
public class MainScreenControllerr {
   // private final PartRepository partRepository;
   // private final ProductRepository productRepository;'

    private PartService partService;
    private ProductService productService;

    private List<Part> theParts;
    private List<Product> theProducts;

 /*   public MainScreenControllerr(PartRepository partRepository, ProductRepository productRepository) {
        this.partRepository = partRepository;
        this.productRepository = productRepository;
    }*/

    public MainScreenControllerr(PartService partService,ProductService productService){
        this.partService=partService;
        this.productService=productService;
    }
    @GetMapping("/mainscreen")
    public String listPartsandProducts(Model theModel, @Param("partkeyword") String partkeyword, @Param("productkeyword") String productkeyword){
        //add to the sprig model
        theModel.addAttribute("pageName", "Ascended Computer Parts");
        theModel.addAttribute("companyName", "Ascended Computer Parts");
        theModel.addAttribute("partsHeading", "PC Components");
        theModel.addAttribute("productsHeading", "Computers and Kits");
        List<Part> partList=partService.listAll(partkeyword);
        theModel.addAttribute("parts",partList);
        theModel.addAttribute("partkeyword",partkeyword);
    //    theModel.addAttribute("products",productService.findAll());
        List<Product> productList=productService.listAll(productkeyword);
        theModel.addAttribute("products", productList);
        theModel.addAttribute("productkeyword",productkeyword);

        //Part part1 = new Part(1L, "Ryzen 9 CPU", 499.99, 20, 0, 50);
        //Part part2 = new Part(2L, "32BG (2x 16GB) DDR5 RAM", 119.99, 20, 0, 50);
        //Part part3 = new Part(3L, "ATX Computer Tower", 59.99, 20, 0, 50);
        //Part part4 = new Part(4L, "Radeon RX7900 XT GPU", 799.99, 20, 0, 50);
        //Part part5 = new Part(5L, "X870E Socket AM5 Motherboard", 499.99, 20, 0, 50);

        /*Product product1 = new Product(1L, "Gaming Computer", 2099.99, 3);
        Product product2 = new Product(2L, "Content Creation Computer", 2799.99, 3);
        Product product3 = new Product(3L, "Gaming Motherboard and CPU Kit", 899.99, 3);
        Product product4 = new Product(4L, "Gaming RAM and GPU Kit", 779.99, 3);
        Product product5 = new Product(5L, "Gaming CPU and RAM Kit", 579.99, 3);*/

        //List<Part> thePartList = Arrays.asList(part1, part2, part3, part4);
        //theModel.addAttribute("parts", thePartList);

        //List<Product> theProductList = Arrays.asList(product1, product2, product3, product4, product5);
        //theModel.addAttribute("products", theProductList);

        return "mainscreen";
    }

    @GetMapping("/buy")
    @ResponseBody
    public String buyProduct(@RequestParam("productId") int productId) {
        try {
            Product product = productService.findById(productId);
            productService.buy(product);
            return "Purchase successful for product: " + product.getName();
        }
        catch (RuntimeException e) {
            return "Purchase failed: " + e.getMessage();
        }
    }

    @GetMapping("/About")
    public String about() {
        return "About";
    }
}
