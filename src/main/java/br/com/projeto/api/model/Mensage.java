package br.com.projeto.api.model;

import org.springframework.stereotype.Component;

//@Component Indica que a classe anotada é um componente. Essas classes são consideradas candidatas à detecção automática ao usar configuração baseada em anotações e varredura de caminho de classe. Um componente pode opcionalmente especificar um nome de componente lógico através do atributo value desta anotação.
@Component
public class Mensage {
    private String mensagem;

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}
