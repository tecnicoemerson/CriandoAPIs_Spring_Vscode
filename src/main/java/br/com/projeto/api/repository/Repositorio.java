package br.com.projeto.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.projeto.api.model.Pessoa;

//@Repository Indica que uma classe anotada é um "Repositório", originalmente definido por Domain-Driven Design como "um mecanismo para encapsular comportamento de armazenamento, recuperação e pesquisa que emula uma coleção de objetos".
@Repository
public interface Repositorio extends CrudRepository<Pessoa, Integer> {
    //Listando dados com o comando findAll()
    List<Pessoa> findAll();

    //Filtrando dados com o findBy()
    Pessoa findByCodigo(int condigo);

    //Ordenar registros por nome
    //findByOrderByNomeAsc ordem padrão
    //findByOrderByNomeDesc ordem descrecente
    List<Pessoa> findByOrderByNomeAsc();

    //Ordenar registros 2 por idade
    List<Pessoa> findByNomeOrderByIdade(String nome);

    //Filtrar dados através do comando containing
    List<Pessoa> findByNomeContaining(String termo);

    //StartsWith e EndsWith
    List<Pessoa> findByNomeStartsWith(String termo);
    List<Pessoa> findByNomeEndsWith(String termo);

    //Utilizando a annotation @Query
    @Query(value = "SELECT SUM(idade) FROM pessoas", nativeQuery = true)
    int somaIdades();
    @Query(value = "SELECT * FROM pessoas WHERE idade >= :idade",nativeQuery = true)
    List<Pessoa> idadeMaiorIgual(int idade);

    int countByCodigo(int codigo);
}
