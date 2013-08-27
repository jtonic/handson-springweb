package ro.jtonic.handson.springweb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by jtonic on 8/25/13.
 */
@Controller
public class CinemaController {

    @RequestMapping(value = "/greeting", method = RequestMethod.GET)
    public ModelAndView greeting() {
        ModelAndView mav = new ModelAndView("HelloWorldPage");
        mav.addObject("msg", "Hello spring web mvc world!!!!");
        return mav;
    }

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello() {
        return "hello";
    }

}
