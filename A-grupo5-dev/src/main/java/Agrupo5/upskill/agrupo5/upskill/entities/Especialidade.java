package Agrupo5.upskill.agrupo5.upskill.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Especialidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id_especialidade;

    @Column(name = "Nome_Especialidade")
    String nome;

    @ManyToMany(mappedBy = "especialidades", fetch = FetchType.LAZY)
    Set<Medico> medicos;

    public Especialidade() {
    }

    public Especialidade(String nome) {
        this.nome = nome;
    }


    public Long getId_especialidade() {
        return id_especialidade;
    }

    public void setId_especialidade(Long id_especialidade) {
        this.id_especialidade = id_especialidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<Medico> getMedicos() {
        return medicos;
    }

    public void setMedicos(Set<Medico> medicos) {
        this.medicos = medicos;
    }

    @Override
    public String toString() {
        return "Especialidade{" + nome +'}';
    }


}
