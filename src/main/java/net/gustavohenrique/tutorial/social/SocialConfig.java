package net.gustavohenrique.tutorial.social;

import javax.inject.Inject;
import javax.sql.DataSource;

import net.gustavohenrique.tutorial.domain.User;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.core.env.Environment;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.connect.jdbc.JdbcUsersConnectionRepository;
import org.springframework.social.connect.support.ConnectionFactoryRegistry;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.connect.FacebookConnectionFactory;

@Configuration
public class SocialConfig {

    @Value("${facebook.clientId}")
    private String facebookClientId;
    
    @Value("${facebook.clientSecret}")
    private String facebookClientSecret;
    
    @Inject
    private Environment environment;
    
    @Inject
    private DataSource dataSource;
    
    
    @Bean
    public ConnectionFactoryLocator connectionFactoryLocator() {
        ConnectionFactoryRegistry registry = new ConnectionFactoryRegistry();
        registry.addConnectionFactory(new FacebookConnectionFactory(facebookClientId, facebookClientSecret));
        return registry;
    }

    @Bean
    public UsersConnectionRepository usersConnectionRepository() {
        JdbcUsersConnectionRepository repository = new JdbcUsersConnectionRepository(dataSource, connectionFactoryLocator(), Encryptors.noOpText());
        repository.setConnectionSignUp(new SimpleConnectionSignUp());
        return repository;
    }

    @Bean
    @Scope(value="request", proxyMode=ScopedProxyMode.INTERFACES)
    public ConnectionRepository connectionRepository() {
        User user = SecurityContext.getCurrentUser();
        return usersConnectionRepository().createConnectionRepository(user.getStringId());
    }

    @Bean
    @Scope(value="request", proxyMode=ScopedProxyMode.INTERFACES)   
    public Facebook facebook() {
        return connectionRepository().getPrimaryConnection(Facebook.class).getApi();
    }
    
}
