package se.lexicon.groupProject.hotel.controller;
        import org.springframework.stereotype.Controller;
        import org.springframework.ui.Model;
        import org.springframework.web.bind.annotation.*;
        import se.lexicon.groupProject.hotel.entity.Customer;

        import javax.annotation.PostConstruct;
        import java.util.ArrayList;
        import java.util.List;

@Controller
@RequestMapping(path = "/customer")
public class CustomerController {

    private List<Customer> customers;

    @PostConstruct
    public void init(){
        if(customers == null){
            customers = new ArrayList<>();
        }

       // customers.add(new Customer("Negar", "Madadi", "negar.madadi@gmail.com"));
      //  customers.add(new Customer("Elmira", "Madadi","elmiramadadi@gmail.com"));
    }

    @GetMapping()
    public String getAll(Model model){
        model.addAttribute(customers);

        return "customer_view";
    }

    @GetMapping("/booking")
    public String bookingView(Model model){

        Customer customer = new Customer();

        model.addAttribute("customer", customer);

        return "booking_form";
    }

    @PostMapping("/add")
    public String addCustomer(@ModelAttribute Customer customer){

        customers.add(customer);

        return "redirect:/customer";

    }


    @GetMapping("/deleteById/{id}")
    public String deleteById(@PathVariable("id") String id){

        customers.removeIf(customer -> customer.getCustomerId() == id);

        return "redirect:/customer";
    }

}
