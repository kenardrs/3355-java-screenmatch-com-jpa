package br.com.alura.screenmatch.service;

import io.github.cdimascio.dotenv.Dotenv;

public class EnvServices {
    protected static String getValue(String key) {
        Dotenv dotenv = null;
        dotenv = Dotenv.configure().load();
        return dotenv.get(key);
    }
}
