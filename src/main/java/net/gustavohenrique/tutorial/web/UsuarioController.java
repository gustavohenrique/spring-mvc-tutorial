package net.gustavohenrique.tutorial.web;

import java.util.List;

import net.gustavohenrique.tutorial.dao.UsuarioDao;
import net.gustavohenrique.tutorial.domain.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UsuarioController {

    @Autowired
    private UsuarioDao usuarioDao;

    public UsuarioDao getUsuarioDao() {
        return usuarioDao;
    }

    public void setUsuarioDao(UsuarioDao dao) {
        usuarioDao = dao;
    }
    
    @RequestMapping("/usuarios")
    public ModelAndView lista() {
        ModelAndView mav = new ModelAndView();
        List<Usuario> usuarios = getUsuarioDao().list(0, 10);
        mav.getModel().put("usuarios", usuarios);
        mav.setViewName("usuario/show");
        return mav;
    }

    @RequestMapping("/usuario/show/{id}")
    public ModelAndView usuario(@PathVariable("id") Long id) {
        ModelAndView mav = new ModelAndView();
        System.out.println("Vou expor o usuario");
        Usuario usuario = getUsuarioDao().get(id);
        
        System.out.println("Encontrei o usuario: " + usuario);
        mav.getModel().put("usuario", usuario);
        mav.setViewName("usuario/show");
        return mav;
    }
}
