package br.com.alura.screenmatch.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConsultarDeepLTranslatorTest {

    @Test
    void obterTraducao() throws Exception {
        var text ="how i met your mother... i like this show... by the way, its just a tranlation test.";
        assertTrue(!ConsultarDeepLTranslator.obterTraducao(text).isEmpty());
    }
}