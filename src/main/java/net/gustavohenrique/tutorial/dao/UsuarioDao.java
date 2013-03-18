package net.gustavohenrique.tutorial.dao;

import java.util.List;

import net.gustavohenrique.tutorial.domain.Usuario;


public interface UsuarioDao {

    public Usuario getUsuario(String login, String senha);

    public Usuario getUsuario(String login);
    
    public Usuario get(Long id);
    
    public void excluir(Usuario usuario);
    
    public List<Usuario> list(int offset, int max);
    
    public void persistir(Usuario usuario);
}
