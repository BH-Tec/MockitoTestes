package com.brunodorea.testesmockito.MockitoTestes;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ServicoEnvioEmailTeste {

    @Mock
    private PlataformaDeEnvio plataforma;

    @InjectMocks
    private ServicoEnvioEmail servico;

    @Captor
    private ArgumentCaptor<Email> captor;

    @Test
    void validarDadosEnviadosParaAPlataforma() {
        String enderecoDeEmail = "user@gmail.com.br";
        String mensagem = "Olá mundo, teste de mensagem!";        

        boolean ehFormatoHtml = false;

        servico.enviaEmail(enderecoDeEmail, mensagem, ehFormatoHtml);

        Mockito.verify(plataforma).enviaEmail(captor.capture());

        Email emailCapturado = captor.getValue();

        // Erro na utização do assertEquals
        assertEquals(enderecoDeEmail, emailCapturado.getEnderecoEmail());
        assertEquals(mensagem, emailCapturado.getMensagem());
        assertEquals(Formato.TEXTO, emailCapturado.getFormato());
    }
    
}
