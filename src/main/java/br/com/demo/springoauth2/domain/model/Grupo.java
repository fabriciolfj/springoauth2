package br.com.demo.springoauth2.domain.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Grupo {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @ManyToMany
    @JoinTable(name = "grupo_permissao",joinColumns = @JoinColumn(name = "grupo_id"), inverseJoinColumns = @JoinColumn(name = "permissao_id"))
    private List<Permissao> permissoes = new ArrayList<>();

    public void adicionarPermissao(Permissao permissao){
        this.permissoes.add(permissao);
    }

    public void removerPermissao(Permissao permissao){
        this.permissoes.remove(permissao);
    }
}