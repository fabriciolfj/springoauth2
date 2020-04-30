package br.com.demo.springoauth2.api.mapper;

import br.com.demo.springoauth2.api.dto.PessoaDTO;
import br.com.demo.springoauth2.domain.model.Pessoa;
import br.com.demo.springoauth2.domain.model.Usuario;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PessoaMapper {

    private final ModelMapper modelMapper;

    public PessoaDTO toDto(final Pessoa pessoa) {
        return modelMapper.map(pessoa, PessoaDTO.class);
    }

    public Pessoa toModel(final PessoaDTO dto) {
        return modelMapper.map(dto, Pessoa.class);
    }

    public void merge(final Pessoa entity, final PessoaDTO dto) {
        modelMapper.map(dto, entity);
    }
}
