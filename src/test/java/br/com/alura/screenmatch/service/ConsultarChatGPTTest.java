package br.com.alura.screenmatch.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConsultarChatGPTTest {

    @Test
    void obterTraducao() {
        ConsultarChatGPT.obterTraducao("This is justa a simple test of text translation");
    }
}