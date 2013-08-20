package net.gustavohenrique.tutorial.web;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private Facebook facebook;
	
	public void setFacebook(Facebook facebook) {
	    this.facebook = facebook;
	}
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Model model) {
        logger.info("Welcome home!");
        List<Reference> friends = facebook.friendOperations().getFriends();
        model.addAttribute("friends", friends);
        return "home";
    }
	
}