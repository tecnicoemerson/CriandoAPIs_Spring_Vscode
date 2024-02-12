package br.com.projeto.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.pulsar.PulsarProperties.Client;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.projeto.api.Service.Servico;
import br.com.projeto.api.model.Pessoa;
import br.com.projeto.api.repository.Repositorio;
import jakarta.validation.Valid;


//indica para o framework que se trata de um controlador Rest(rotas)
@RestController
public class Controller {

    //@Autowired Marca um construtor, campo, método setter ou método de configuração para ser conectado automaticamente pelos recursos de injeção de dependência do Spring.
    @Autowired
    private Repositorio acao;

    //Implementando serviços
    //@Autowired Marca um construtor, campo, método setter ou método de configuração para ser conectado automaticamente pelos recursos de injeção de dependência do Spring.
    @Autowired
    private Servico servico;

    //Implementando serviços
    //Efetuando cadastros
    @PostMapping("/api")
    public ResponseEntity<?> cadastrar(@RequestBody Pessoa obj){
        return servico.cadastrar(obj);
    }

    //Implementando serviços
    //Listando dados
    @GetMapping("/api")
    public ResponseEntity<?> selecionar(){
        return servico.selecionar();
    }

    //Implementando serviços
    //Filtrando dados
    @GetMapping("/api/{codigo}")
    public ResponseEntity<?> selecionarPeloCodigo(@PathVariable int codigo){
        return servico.selecionarPeloCodigo(codigo);
    }

    //Implementando serviços
    //Alterando dados
    //@PutMappin Anotação para mapear solicitações HTTP PUT em métodos manipuladores específicos.
    @PutMapping("/api")
    public ResponseEntity<?> editar(@RequestBody Pessoa obj){
        return servico.editar(obj);
    }
    
    //Implementando serviços
    //Removendo dados com delete()
    //@DeleteMapping Anotação para mapear solicitações HTTP DELETE em métodos manipuladores específicos.
    @DeleteMapping("/api/{codigo}")
    public ResponseEntity<?> remover(@PathVariable int codigo){
        return servico.remover(codigo);
    }

    //Contar registros com o comando count()
    @GetMapping("/api/contador")
    public long contador(){
        return acao.count();
    }

    //Ordenar registros em ordem afalbetica
    @GetMapping("/api/ordernarNomes")
    public List<Pessoa> ordernarNomes(){
         return acao.findByOrderByNomeAsc();
    }

    //Ordenar registros em ordem de idade
    @GetMapping("/api/ordenarNomes2")
    public List<Pessoa> ordenarNomes2(){
        return acao.findByNomeOrderByIdade("Emerson");
    }

    //Filtrar dados através do comando containing
    @GetMapping("/api/nomeContem")
    public List<Pessoa> nomeContem(){
        return acao.findByNomeContaining("m");
    }

    //StartsWith e EndsWith
    @GetMapping("/api/iniciaCom")
    public List<Pessoa> iniciaCom(){
        return acao.findByNomeStartsWith("a");
    }

    //StartsWith e EndsWith
    @GetMapping("/api/terminaCom")
    public List<Pessoa> terminaCom(){
        return acao.findByNomeEndsWith("a");
    }

     //Utilizando a annotation @Query
    @GetMapping("/api/somaIdades")
    public int somaIdades(){
        return acao.somaIdades();
    }
    
     //Utilizando a annotation @Query
     @GetMapping("/api/idadeMaiorIgual")
     public List<Pessoa> idadeMaiorIgual(){
        return acao.idadeMaiorIgual(20);
     }

     //Annotations para validar dados
     //@Valid Marca uma propriedade, parâmetro de método ou tipo de retorno de método para validação em cascata. As restrições definidas no objeto e suas propriedades são validadas quando a propriedade, parâmetro do método ou tipo de retorno do método é validado.
     @PostMapping("/cliente")
     public void cliente(@Valid @RequestBody Client obj){

     }

    //  //ResponseEntity
    //  //Configurando status
    //  @GetMapping("/status")
    //  public ResponseEntity<?> status(){
    //     return new ResponseEntity<>(HttpStatus.CREATED);
    //  }

    // //@GetMapping mapear(caminhos)define uma rota que responde a requisições HTTP GET.
    // @GetMapping("") 
    // public String mensagem(){
    //     return "hello world";
    // }

    // @GetMapping("/boasVindas/")
    // public String boasVindas(){
    //     return "seja bem vindo";
    // }

    // //@PathVariable indica que o valor da variável virá de uma informação da rota(url)
    // @GetMapping("/boasVindas/{nome}")
    // public String boasVindas(@PathVariable String nome){
    //     return "seja bem vindo" + nome;
    // }

    // //@PostMappingmapear(caminhos Determina que o método aceitará requisições HTTP do tipo POST
    // //@RequestBody indica que o valor do objeto virá do corpo da requisição
    // @PostMapping("/pessoa")
    // public Pessoa pessoa(@RequestBody Pessoa p){
    //     return p;
    // }
}
