package net.gustavohenrique.tutorial.dao;

import net.gustavohenrique.tutorial.domain.Usuario;

import org.apache.commons.codec.digest.DigestUtils;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.SUPPORTS)
@Repository("usuarioDao")
public class UsuarioDaoImpl extends HibernateDao<Usuario> implements UsuarioDao {

    protected Class getClazz() {
        return Usuario.class;
    }

    public Usuario getUsuario(String login, String senha) {
        Query query = getSession().createQuery("from Usuario u where u.login = ? and u.hashSenha = ?");
        query.setString(0, login);
        query.setString(1, DigestUtils.sha256Hex(senha));
        return (Usuario) query.uniqueResult();
    }

    public Usuario getUsuario(String login) {
        Query query = getSession().createQuery("from Usuario u where u.login = ?");
        query.setString(0, login);
        return (Usuario) query.uniqueResult();
    }
}
