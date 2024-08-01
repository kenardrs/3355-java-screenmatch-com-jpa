package br.com.alura.screenmatch.service;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class ConsultarGoogleGiminiTest {

    @Test
    void obterTraducao() throws IOException, InterruptedException {
        var texto = "A father recounts to his children - through a series of flashbacks - the journey he and his four best friends took leading up to him meeting their mother.";
        assertTrue(ConsultarGoogleGimini.obterTraducao(texto) == 200);
    }
}