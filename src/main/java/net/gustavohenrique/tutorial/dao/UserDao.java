package net.gustavohenrique.tutorial.dao;

import java.util.List;

import net.gustavohenrique.tutorial.domain.User;


public interface UserDao {

    public User getUsuario(String login, String senha);

    public User getUsuario(String login);
    
    public User get(Long id);
    
    public void excluir(User usuario);
    
    public List<User> list(int offset, int max);
    
    public void persistir(User usuario);
}
