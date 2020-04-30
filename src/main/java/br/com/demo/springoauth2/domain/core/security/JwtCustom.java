package br.com.demo.springoauth2.domain.core.security;

import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

import java.util.HashMap;

public class JwtCustom implements TokenEnhancer {

    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
        if(authentication.getPrincipal() instanceof AuthUser) {
            var auth = (AuthUser) authentication.getPrincipal();

            var informacao = new HashMap<String, Object>();
            informacao.put("nome", auth.getNomeCompleto());
            informacao.put("idUsuario", auth.getId());

            var defaultToken = (DefaultOAuth2AccessToken) accessToken;
            defaultToken.setAdditionalInformation(informacao);
        }

        return accessToken;
    }
}
