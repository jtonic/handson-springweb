package ro.jtonic.handson.springweb.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ro.jtonic.handson.springweb.model.BookSearchCriteria;
import ro.jtonic.handson.springweb.services.BookSearchCriteriaService;

/**
 * Created by jtonic on 8/25/13.
 */
@Controller
public class CinemaController {

    private BookSearchCriteriaService criteriaService;

    @Autowired
    public void config(@Qualifier("criteriaService") BookSearchCriteriaService criteriaService) {
        this.criteriaService = criteriaService;
    }

    @ModelAttribute("bookSearchCriteria")
    public BookSearchCriteria bookSearchCriteria() {
        return criteriaService.createBookSearchCriteria();
    }
/*
    @ModelAttribute("bookSearchCriteria")
    public BookSearchCriteria bookSearchCriteria() {
        return new BookSearchCriteria("title 1");
    }
*/

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

}
