package com.brunodorea.testesmockito.MockitoTestes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class EnviarMensagemTeste {
    
    @Spy
    private EnviarMensagem enviarMensagem;

    @Test
    void verificarComportamentoDaClasse() {
        Mockito.verifyNoInteractions(enviarMensagem);

        Mensagem mensagem = new Mensagem("Olá mundo");
        enviarMensagem.adicionarMensagem(mensagem);

        Mockito.verify(enviarMensagem).adicionarMensagem(mensagem);

        Assertions.assertFalse(enviarMensagem.getMensagens().isEmpty());
    }
}
