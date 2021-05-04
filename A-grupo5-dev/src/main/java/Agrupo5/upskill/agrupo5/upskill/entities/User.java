package Agrupo5.upskill.agrupo5.upskill.entities;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;
import java.beans.Encoder;


@Entity
@Table(name = "users")
public class User {

    @Id
    @Column(name = "id_users")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name = "nome")
    private String nome;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "localidade")
    private String localidade;

    @Column(name = "morada")
    private String morada;

    @Column(name = "codigo_postal")
    private String codigoPostal;

    @Column(name = "nif")
    private String nif;

    @Column(name = "data_de_nascimento")
    private String dataNascimento;

    @Column(name = "contacto")
    private String contacto;

    @Column(name = "numero_documento")
    private String numeroDocumento;

    @Column(name = "enabled")
    private boolean enabled = true;

    @Column(name = "foto")
    private String photo;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id")
    private Role role;


    public User(){}

    public User(Long id, String nome, String email, String username, String password, String localidade, String codigoPostal, String morada, String nif, String dataNascimento, String contacto, String numeroDocumento, String photo) {
        this.nome = nome;
        this.email = email;
        this.username = username;
        this.password = password;
        this.morada=morada;
        this.codigoPostal=codigoPostal;
        this.localidade=localidade;
        this.id=id;
        this.nif=nif;
        this.dataNascimento=dataNascimento;
        this.contacto=contacto;
        this.numeroDocumento=numeroDocumento;
        this.photo = photo;
    }

    public User(String nome, String email, String username, String password) {
        this.nome = nome;
        this.email = email;
        this.username = username;
        this.password = password;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id_users) {
        this.id = id_users;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername (String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password= password;
    }

    public Role getRole(){
        return role;
    }

    public void setRole(Role role){
        this.role=role;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public String getMorada() {
        return morada;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Transient
    public String getPhotosImagePath() {
        if (this.photo == null) return null;

        return "/user-photos/" + this.id + "/" + this.photo;
    }
}
