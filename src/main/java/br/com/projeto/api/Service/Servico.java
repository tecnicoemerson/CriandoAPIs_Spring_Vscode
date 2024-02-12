package br.com.projeto.api.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.projeto.api.model.Mensage;
import br.com.projeto.api.model.Pessoa;
import br.com.projeto.api.repository.Repositorio;

//Criando serviços
//@Service Indica que uma classe anotada é um “Serviço”, originalmente definido por “uma operação oferecida como uma interface que fica sozinha no modelo, sem estado encapsulado, Esta anotação é um estereótipo de uso geral e equipes individuais podem restringir sua semântica e usá-la conforme apropriado
@Service
public class Servico {

    //@Autowired Marca um construtor, campo, método setter ou método de configuração para ser conectado automaticamente pelos recursos de injeção de dependência do Spring.
    @Autowired
    private Mensage mensagem;

    //Implementando serviços
    @Autowired
    //metodo para cadastrar pessoas
    private Repositorio acao;
    public ResponseEntity<?> cadastrar(Pessoa obj){

        if (obj.getNome().equals("")) {
            mensagem.setMensagem("O nome precisa ser preenchido");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);    
        }else if (obj.getIdade() < 0){
            mensagem.setMensagem("Informe uma idade valida");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }else{
            return new ResponseEntity<>(acao.save(obj), HttpStatus.CREATED);
        }
        
    }

    //metodo para selecionar pesssoas
    public ResponseEntity<?> selecionar(){
        return new ResponseEntity<>(acao.findAll(), HttpStatus.OK);
    }

    //metodo para selecionar pessoas atraves do codigo
    public ResponseEntity<?> selecionarPeloCodigo(int codigo){
        if (acao.countByCodigo(codigo) == 0) {
            mensagem.setMensagem("Nao foi encontrada nenhuma pessoa");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }else{
            return new ResponseEntity<>(acao.findByCodigo(codigo),HttpStatus.OK);
        }
    }

    //metodo para editar dados
    public ResponseEntity<?> editar(Pessoa obj){
        if(acao.countByCodigo(obj.getCodigo()) == 0){
            mensagem.setMensagem("O codigo informado nao existe");
            return new ResponseEntity<>(mensagem, HttpStatus.NOT_FOUND);
        }else if(obj.getNome().equals("")){
            mensagem.setMensagem("É necessario informar um nome");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }else if(obj.getIdade() < 0){
            mensagem.setMensagem("Informe uma idade valida");
            return new ResponseEntity<>(mensagem,HttpStatus.BAD_REQUEST);
        }else {
            return new ResponseEntity<>(acao.save(obj),HttpStatus.OK);
        }
    }

    //metodo para remover registros
    public ResponseEntity<?> remover(int codigo){
        if(acao.countByCodigo(codigo) == 0){
            mensagem.setMensagem("O codigo informado nao existe");
            return new ResponseEntity<>(mensagem, HttpStatus.NOT_FOUND);
        }else{
            Pessoa obj = acao.findByCodigo(codigo);
            acao.delete(obj);

            mensagem.setMensagem("Pessoa removida com suceeso!");
            return new ResponseEntity<>(mensagem, HttpStatus.OK);
        }
    }
}
