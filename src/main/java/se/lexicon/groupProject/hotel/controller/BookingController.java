package se.lexicon.groupProject.hotel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import se.lexicon.groupProject.hotel.repository.BookingRepository;

@Controller
public class BookingController {
    private BookingRepository bookingRepository;

    @Autowired
    public BookingController(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @GetMapping({"","/index", "/home"})
    public String getIndexPage(){
        return "index";
    }


}
