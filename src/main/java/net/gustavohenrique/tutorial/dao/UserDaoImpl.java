package net.gustavohenrique.tutorial.dao;

import net.gustavohenrique.tutorial.domain.User;

import org.apache.commons.codec.digest.DigestUtils;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.SUPPORTS)
@Repository("usuarioDao")
public class UserDaoImpl extends HibernateDao<User> implements UserDao {

    protected Class getClazz() {
        return User.class;
    }

    public User getUsuario(String login, String senha) {
        Query query = getSession().createQuery("from Usuario u where u.login = ? and u.hashSenha = ?");
        query.setString(0, login);
        query.setString(1, DigestUtils.sha256Hex(senha));
        return (User) query.uniqueResult();
    }

    public User getUsuario(String login) {
        Query query = getSession().createQuery("from Usuario u where u.login = ?");
        query.setString(0, login);
        return (User) query.uniqueResult();
    }
}
