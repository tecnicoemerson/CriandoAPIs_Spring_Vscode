package br.com.projeto.api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

//@Entity classe é uma entidade.
@Entity
//@Table Especifica a tabela primária da entidade anotada.
@Table(name = "pessoas")
public class Pessoa {

    //atributos
    //@Id Especifica a chave primária de uma entidade.
    @Id
    //@GeneratedValue Dispõe sobre a especificação de estratégias de geração de valores de chaves primárias.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;
    private String nome;
    private int idade;

    //get e set
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
    public int getIdade() {
        return idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }

    
}
