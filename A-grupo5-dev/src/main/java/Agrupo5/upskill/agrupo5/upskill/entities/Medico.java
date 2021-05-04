package Agrupo5.upskill.agrupo5.upskill.entities;


import javax.persistence.*;
import java.util.Set;


@Entity
@Table (name = "medico")
public class Medico {


    @Id
    @Column(name = "id_medico")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id_medico;


    @Column(name = "numero_cedula")
    int numero_cedula;

    @OneToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    User user;


    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable (name = "medico_especialidade", joinColumns = @JoinColumn(name="medico_id"),
    inverseJoinColumns = @JoinColumn(name = "especialidade_id"))
    Set<Especialidade> especialidades;


    public Medico() {
    }

    public Medico(User user) {
        this.user = user;
    }


    public int getNumero_cedula() {
        return numero_cedula;
    }

    public void setNumero_cedula(int numero_cedula) {
        this.numero_cedula = numero_cedula;
    }

    public Long getId_medico() {
        return id_medico;
    }

    public void setId_medico(Long id_medico) {
        this.id_medico = id_medico;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Especialidade> getEspecialidades() {
        return especialidades;
    }

    public void setEspecialidades(Set<Especialidade> especialidades) {
        this.especialidades = especialidades;
    }


    @Override
    public String toString() {
        return "Medico " +
                "id_medico=" + id_medico +
                ", user=" + user +
                ", especialidades=" + especialidades;
    }
}
