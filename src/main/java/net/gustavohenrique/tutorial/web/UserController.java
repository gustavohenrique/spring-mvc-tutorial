package net.gustavohenrique.tutorial.web;

import java.util.List;

import net.gustavohenrique.tutorial.dao.UserDao;
import net.gustavohenrique.tutorial.domain.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

    @Autowired
    private UserDao userDao;

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao dao) {
        userDao = dao;
    }
    
    @RequestMapping("/users")
    public ModelAndView listAll() {
        ModelAndView mav = new ModelAndView();
        List<User> users = getUserDao().list(0, 10);
        mav.getModel().put("users", users);
        mav.setViewName("user/show");
        return mav;
    }

    @RequestMapping("/user/show/{id}")
    public ModelAndView usuario(@PathVariable("id") Long id) {
        ModelAndView mav = new ModelAndView();
        User user = getUserDao().get(id);
        mav.getModel().put("usuario", user);
        mav.setViewName("usuario/show");
        return mav;
    }
}
