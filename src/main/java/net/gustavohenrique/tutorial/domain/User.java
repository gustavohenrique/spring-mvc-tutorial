package net.gustavohenrique.tutorial.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="user")
public class User implements Serializable {
    
    private static final long serialVersionUID = 332290382768124409L;

    @Id
    @Generated(GenerationTime.INSERT)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", unique=true)
    protected long id;

    @NotNull
    @NotEmpty
    @Column(name="name", nullable=false, length=128)
    private String name;

    @Email(message="Invalid e-mail")
    @NotNull
    @NotEmpty
    @Column(name="email", nullable=false, length=128, unique=true)
    private String email;

    @NotNull
    @Column(name="registerDate", nullable=false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date registerDate= new Date();

    @NotNull
    @NotEmpty
    @Size(min=8, max=32, message="Login is too short ou too long")
    @Column(name="login", nullable=false, unique=true, length=64)
    private String login;

    private transient String password;
    
    @Column(name="lastLogin", nullable=true)
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastLogin;

    @Column(name="hashPassword", nullable=false, length=128)
    private String hashPassword;
    
    public User() {}
    
    public User(String id) {
        try {
            setId(Long.valueOf(id));
        }
        catch(Exception e) {}
    }
    
    public void setSenha(String senha) {
        setHashPassword(org.apache.commons.codec.digest.DigestUtils.sha256Hex(senha));
        this.password = senha;
    }
    
    public String getStringId() {
        try {
            return String.valueOf(this.id);
        }
        catch(Exception e) {
            return "";
        }
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public String getHashPassword() {
        return hashPassword;
    }

    public void setHashPassword(String hashPassword) {
        this.hashPassword = hashPassword;
    }    
}
