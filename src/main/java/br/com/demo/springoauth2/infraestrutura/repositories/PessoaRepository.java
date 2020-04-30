package br.com.demo.springoauth2.infraestrutura.repositories;

import br.com.demo.springoauth2.domain.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}
