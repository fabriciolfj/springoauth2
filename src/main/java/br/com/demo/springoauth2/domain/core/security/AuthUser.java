package br.com.demo.springoauth2.domain.core.security;

import br.com.demo.springoauth2.domain.model.Usuario;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

@Getter
public class AuthUser extends User {

    private static final long serialVersionUID = -4043784805167384690L;

    private Long id;
    private String nomeCompleto;

    public AuthUser(Usuario usuario, Collection<? extends GrantedAuthority> authorities) {
        super(usuario.getEmail(), usuario.getSenha(), authorities);

        this.nomeCompleto = usuario.getNome();
        this.id = usuario.getId();
    }
}
