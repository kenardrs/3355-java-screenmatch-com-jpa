package br.com.alura.screenmatch.service;

import com.deepl.api.DeepLException;
import com.deepl.api.TextResult;
import com.deepl.api.Translator;
import org.springframework.stereotype.Service;

@Service
public class DeepLService {

    private static final String API_KEY = EnvServices.getValue("DEEPL_API_KEY");
    private static final Translator translator = new Translator(API_KEY);

    public static String translate(String text) {
        TextResult result = null;
        try {
            result = translator.translateText(
                    text,
                    null,
                    "pt-br"
            );
        } catch (DeepLException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return result.getText();
    }
}
