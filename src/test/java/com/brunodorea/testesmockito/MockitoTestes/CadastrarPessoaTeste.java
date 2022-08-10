package com.brunodorea.testesmockito.MockitoTestes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doThrow;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class CadastrarPessoaTeste {

    @Mock
    private ApiDosCorreios apiDosCorreios;

    @InjectMocks
    private CadastrarPessoa cadastrarPessoa;

    @Test
    void validarDadosDeCadastro() {
        DadosLocalizacao dadosLocalizacao = new DadosLocalizacao("BA", "Salvador", "Rua A", "Casa", "Ribeira");
        Mockito.when(apiDosCorreios.buscaDadosComBaseNoCep("01310-000")).thenReturn(dadosLocalizacao);
        Pessoa pessoa = cadastrarPessoa.cadastrarPessoa("Bruno", "123.456.789-00", LocalDate.now(), "01310-000");

        assertEquals("Bruno", pessoa.getNome());
        assertEquals("123.456.789-00", pessoa.getDocumento());
        assertEquals("BA", pessoa.getEndereco().getUf());
        assertEquals("Salvador", pessoa.getEndereco().getCidade());
        assertEquals("Rua A", pessoa.getEndereco().getLogradouro());
        assertEquals("Casa", pessoa.getEndereco().getComplemento());
        assertNull(pessoa.getEndereco());
    }

    @Test
    void lancarExceptionQuandoChamarApiDosCorreios() {

        // Mockito.when(apiDosCorreios.buscaDadosComBaseNoCep(anyString())).thenThrow(IllegalArgumentException.class);

        doThrow(IllegalArgumentException.class)
                            .when(apiDosCorreios)
                            .buscaDadosComBaseNoCep(anyString());

        assertThrows(IllegalArgumentException.class, () -> cadastrarPessoa.cadastrarPessoa("Bruno", "123.456.789-00", LocalDate.of(1990, 1, 10), "01310-000")); 
    }

}
