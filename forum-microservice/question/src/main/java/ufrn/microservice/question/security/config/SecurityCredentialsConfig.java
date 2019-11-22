package ufrn.microservice.question.security.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;


import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import ufrn.microservice.core.property.JwtConfiguration;
import ufrn.microservice.security.config.SecurityTokenConfig;
import ufrn.microservice.security.filter.JwtTokenAuthorizationFilter;
import ufrn.microservice.security.token.converter.TokenConverter;


/**
 * @author William Suane
 */
@EnableWebSecurity
public class SecurityCredentialsConfig extends SecurityTokenConfig {
    private final TokenConverter tokenConverter;

    public SecurityCredentialsConfig(JwtConfiguration jwtConfiguration, TokenConverter tokenConverter) {
        super(jwtConfiguration);
        this.tokenConverter = tokenConverter;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.addFilterAfter(new JwtTokenAuthorizationFilter(jwtConfiguration, tokenConverter), UsernamePasswordAuthenticationFilter.class);
        super.configure(http);
    }
}