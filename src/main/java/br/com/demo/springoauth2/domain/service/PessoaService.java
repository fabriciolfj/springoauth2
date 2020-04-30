package br.com.demo.springoauth2.domain.service;

import br.com.demo.springoauth2.api.dto.PessoaDTO;
import br.com.demo.springoauth2.api.mapper.PessoaMapper;
import br.com.demo.springoauth2.domain.model.Pessoa;
import br.com.demo.springoauth2.infraestrutura.repositories.PessoaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PessoaService {

    private final PessoaMapper mapper;
    private final PessoaRepository pessoaRepository;
    private final static String MSG_PESSOA_NAO_LOCALIZADA = "Pessoa não localizada para o id: ";

    public List<PessoaDTO> findAll() {
        return pessoaRepository.findAll()
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    public void create(final PessoaDTO pessoadto) {
        var pessoa = mapper.toModel(pessoadto);
        pessoaRepository.save(pessoa);
    }

    public void update(final PessoaDTO pessoaDTO, final Long id) {
        pessoaRepository.findById(id)
        .map(result -> {
            mapper.merge(result, pessoaDTO);
            return pessoaRepository.save(result);
        }).orElseThrow(() -> new RuntimeException(MSG_PESSOA_NAO_LOCALIZADA + id));

    }

    public Pessoa findById(final Long id) {
        return pessoaRepository.findById(id).orElseThrow(() -> new RuntimeException(MSG_PESSOA_NAO_LOCALIZADA + id));
    }

    public void delete(final Long id) {
        try {
            pessoaRepository.deleteById(id);
        } catch (Exception e) {}

    }
}
