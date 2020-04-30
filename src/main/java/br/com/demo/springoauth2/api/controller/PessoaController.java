package br.com.demo.springoauth2.api.controller;

import br.com.demo.springoauth2.api.dto.PessoaDTO;
import br.com.demo.springoauth2.domain.model.Pessoa;
import br.com.demo.springoauth2.domain.service.PessoaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pessoas")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class PessoaController {

    private final PessoaService pessoaService;

    @GetMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<PessoaDTO> getAll() {
        return pessoaService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Pessoa getId(@PathVariable("id") final Long id) {
        return pessoaService.findById(id);
    }

    @PreAuthorize("hasAuthority('SCOPE_WRITE') and hasAuthority('EDITAR')")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody final PessoaDTO pessoaDTO) {
        pessoaService.create(pessoaDTO);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void update(@RequestBody final PessoaDTO pessoaDTO, @PathVariable("id") final Long id) {
        pessoaService.update(pessoaDTO, id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void delete(@PathVariable("id") final Long id) {
        pessoaService.delete(id);
    }

}
