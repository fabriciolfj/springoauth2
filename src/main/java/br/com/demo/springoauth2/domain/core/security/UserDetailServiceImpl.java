package br.com.demo.springoauth2.domain.core.security;

import br.com.demo.springoauth2.domain.model.Usuario;
import br.com.demo.springoauth2.infraestrutura.repositories.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserDetailServiceImpl implements UserDetailsService {

    private final UsuarioRepository usuarioRepository;

    @Transactional(readOnly = true)
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByEmail(s)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario não encontrado."));

        return new AuthUser(usuario, getAuthorities(usuario));
    }

    public Collection<GrantedAuthority> getAuthorities(Usuario usuario) {
        return usuario.getGrupos().stream()
                .flatMap(grupo -> grupo.getPermissoes().stream()
                        .map(permissao -> new SimpleGrantedAuthority(permissao.getNome().toUpperCase())))
                .collect(Collectors.toSet());
    }
}
