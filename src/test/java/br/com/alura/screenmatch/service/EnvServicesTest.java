package br.com.alura.screenmatch.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EnvServicesTest {

    @Test
    void loadEnvs(){
        assertDoesNotThrow(() -> System.out.println(EnvServices.getValue("GIMINI_API_KEY")));
    }
}