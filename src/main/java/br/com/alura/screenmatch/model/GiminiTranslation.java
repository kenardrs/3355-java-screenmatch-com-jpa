package br.com.alura.screenmatch.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record GiminiTranslation(@JsonAlias("candidates") String texto,
                                @JsonAlias("usageMetadata") String regra) {
}
