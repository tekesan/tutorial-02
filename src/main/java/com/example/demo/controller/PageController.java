package com.example.demo.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PageController{
    @RequestMapping("/aloha")
    public String hello(){
        return "hello";
    }

//    @RequestMapping("/hello2")
//    public String hello2(@RequestParam(value = "name", required = false, defaultValue ="Thanos")  String name, Model model){
//        model.addAttribute("name", name);
//        return "hello2";
//    }
    
//    @RequestMapping(value={"/hello2/{name}"})
//    public String helloPath(@PathVariable String name, Model model){
//        
//        model.addAttribute("name", name);
//      
//        return "hello2";
//    }

    @RequestMapping(value={"/calc/{angka1}/{angka2}"})
    public String helloPath(@PathVariable int angka1, @PathVariable int angka2, Model model){
    	model.addAttribute("hasil", angka1+angka2);
    	model.addAttribute("a1", angka1);
    	model.addAttribute("a2", angka2);

        return "calc";
    }

    @RequestMapping(value={"/hello2", "/hello2/{name}"})
    public String helloPath(@PathVariable Optional<String> name, Model model){
        if(name.isPresent()){
            model.addAttribute("name", name.get());
        }else{
            model.addAttribute("name", "teke");
        }
        return "hello2";
    }
}
