package br.com.projeto.api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

//Validando através de JPA
@Entity
@Table(name = "clientes")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;

    //Annotations para validar dados
    //@NotEmpty O elemento anotado não deve ser nulo nem vazio.
    @NotEmpty(message = "Informe um nome")
    private String nome;

    //Annotations para validar dados
    //@Email A string deve ser um endereço de e-mail bem formado
    @Email(message = "informe um e-mail valido")
    private String email;

    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
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

}
