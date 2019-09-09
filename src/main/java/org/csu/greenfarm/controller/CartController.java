package org.csu.greenfarm.controller;

import org.csu.greenfarm.domain.*;
import org.csu.greenfarm.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.csu.greenfarm.service.ProductService;
import org.csu.greenfarm.service.FarmService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class CartController {
    @Autowired
    ProductService productService;
    @Autowired
    FarmService farmService;
    @Autowired
    CartService cartService;
    @Autowired
    HttpServletRequest request;

    @GetMapping("/toCart")
    public String viewCart(Model model) {
        List<Product> p = productService.getAllProducts();
        List<Farm> f = farmService.getAllFarm();
        List<Farm> farms = new ArrayList<>();
        List<Product> products = new ArrayList<>();
        for (int a = 0; a < 6; a++) {
            if (a < f.size()) {
                farms.add(f.get(a));
            }
            if (a < p.size()) {
                products.add(p.get(a));
            }
        }
        model.addAttribute("main_farm", farms);
        model.addAttribute("main_product", products);
        model.addAttribute("main_status", 3); //状态码

        HttpSession session = request.getSession();
        Account account = (Account) session.getAttribute("account");
        if (account != null) {
            Cart cart = (Cart) session.getAttribute("cart");
            List<CartItem> productList = cartService.productList(cart.getCartId());
            session.setAttribute("productList", productList);

            Iterator<CartItem> item = productList.iterator();
            List<Object> items = new ArrayList<>();
            while (item.hasNext()) {
                CartItem cartItem = item.next();
                if (farmService.getFarmByFarmId(cartItem.getProductId()) == null) {
                    items.add(productService.getProductByProductId(cartItem.getProductId()));
                } else {
                    items.add(farmService.getFarmByFarmId(cartItem.getProductId()));
                }
            }
            double allTotal = cartService.getAllTotal(cart.getCartId());
            session.setAttribute("allTotal", allTotal);
            session.setAttribute("items", items);

            return "product/cart";
        }
        else return "login/login";
    }

    @GetMapping("/addToCart")
    public String addToCart(@RequestParam("productId") String productId,Model model){

        List<Product> p = productService.getAllProducts();
        List<Farm> f = farmService.getAllFarm();
        List<Farm> farms = new ArrayList<>();
        List<Product> products = new ArrayList<>();
        for (int a = 0; a < 6; a++) {
            if (a < f.size()) {
                farms.add(f.get(a));
            }
            if (a < p.size()) {
                products.add(p.get(a));
            }
        }
        model.addAttribute("main_farm", farms);
        model.addAttribute("main_product", products);
        model.addAttribute("main_status", 3); //状态码

        HttpSession session = request.getSession();
        Account account = (Account) session.getAttribute("account");
        if(account!=null) {
            Cart cart = (Cart) session.getAttribute("cart");
            cartService.addProduct(cart.getCartId(), productId);
            List<CartItem> productList = cartService.productList(cart.getCartId());

            Iterator<CartItem> item = productList.iterator();

            List<Object> items = new ArrayList<>();
            while (item.hasNext()) {
                CartItem cartItem = item.next();
                if (farmService.getFarmByFarmId(cartItem.getProductId()) == null) {
                    items.add(productService.getProductByProductId(cartItem.getProductId()));

                } else {
                    items.add(farmService.getFarmByFarmId(cartItem.getProductId()));
                }
            }
            double allTotal = cartService.getAllTotal(cart.getCartId());
            session.setAttribute("allTotal", allTotal);
            session.setAttribute("items", items);
            session.setAttribute("productList", productList);
            return "product/cart";
        }
        else return  "login/login";
    }

    @PostMapping("/removeItem")
    public void removeItem(@RequestParam("productId") String productId){
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        cartService.removeProduct(cart.getCartId(),productId);
    }

    @PostMapping("/addItem")
    public  void addItem(@RequestParam("productId") String productId){
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        cartService.addNum(cart.getCartId(),productId);
        System.out.println(productId);
    }
    @PostMapping("/subItem")
    public  void subItem(@RequestParam("productId") String productId){
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        cartService.subNum(cart.getCartId(),productId);
    }
}
