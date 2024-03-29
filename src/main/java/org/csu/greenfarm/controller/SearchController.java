package org.csu.greenfarm.controller;

import org.csu.greenfarm.domain.Farm;
import org.csu.greenfarm.domain.Product;
import org.csu.greenfarm.service.FarmService;
import org.csu.greenfarm.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class SearchController {
    @Autowired
    private FarmService farmService;

    @Autowired
    private ProductService productService;

    @Autowired
    private HttpServletRequest request;

    @GetMapping("/search/search")
    public String search(@RequestParam("item") String item, @RequestParam("index") int index, Model model){
        request.getSession().setAttribute("status", 5);

        List<Farm> search_farm = farmService.getFarmByFarmName(item);
        List<Product> search_product = productService.getProductByProductName(item);
        int num = (int) Math.ceil((double)(search_product.size()+search_farm.size())/3);
        List<Object> indexList = new ArrayList<>();
        //每一页展示6个新闻
        for(int a = index*3; a < (index+1)*3; a++){
            if(a < search_product.size()){
                indexList.add(search_product.get(a));
            }
            else if(a > search_product.size()-1 && (a-search_product.size()) < search_farm.size()){
                indexList.add(search_farm.get(a-search_product.size()));
            }
            else break;
        }
        model.addAttribute("index", index);
        model.addAttribute("pageNum",num-1); //num从0开始
        model.addAttribute("list", indexList);
        model.addAttribute("item", item);
        return "search/search";
    }
}
