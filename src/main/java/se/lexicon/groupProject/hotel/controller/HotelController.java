package se.lexicon.groupProject.hotel.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class HotelController {

    @GetMapping({"","/index", "/home"})
    public String getIndexPage(){
        return "index";
    }
}
