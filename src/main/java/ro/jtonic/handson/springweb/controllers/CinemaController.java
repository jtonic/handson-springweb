package ro.jtonic.handson.springweb.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ro.jtonic.handson.springweb.model.BookSearchCriteria;
import ro.jtonic.handson.springweb.services.BookSearchCriteriaService;
import ro.jtonic.handson.springweb.services.CustomerService;

/**
 * Created by jtonic on 8/25/13.
 */
@Controller
public class CinemaController {

    private BookSearchCriteriaService criteriaService;

    private CustomerService customerService;

    @Autowired
    public void config(
            @Qualifier("criteriaService") BookSearchCriteriaService criteriaService
            , CustomerService customerService
    ) {
        this.criteriaService = criteriaService;
        this.customerService = customerService;
    }

    @ModelAttribute("bookSearchCriteria")
    public BookSearchCriteria bookSearchCriteria() {
        return criteriaService.createBookSearchCriteria();
    }

    @RequestMapping(value = "/greeting", method = RequestMethod.GET)
    public ModelAndView greeting() {
        ModelAndView mav = new ModelAndView("HelloWorldPage");
        mav.addObject("msg", "Hello spring web mvc world!!!!");
        return mav;
    }

    @RequestMapping(value = "/binding", method = RequestMethod.GET)
    public ModelAndView binding(@ModelAttribute("bookSearchCriteria") BookSearchCriteria criteria) {
//        criteria.setTitle("Title 2"); // the value is taken from bookSearchCriteria modelAttribute
        ModelAndView mav = new ModelAndView("BindingExamplePage");
        return mav;
    }

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello() {
        return "hello";
    }

    @RequestMapping(value = "/customerid", method = RequestMethod.GET, produces = {MediaType.TEXT_PLAIN_VALUE})
    public @ResponseBody String getCustomerIdByName(@RequestParam(value = "name", required = true) String name) {
        final Long customerId = customerService.getCustomerId(name);
        if(customerId != -1L) {
            return customerId.toString();
        }
        return "No customer found for the provided name";
    }

}
