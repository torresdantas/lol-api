package com.championslol.lolapi.service;

import com.championslol.lolapi.model.Champion;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service

public class ChampionService {

    private final RestTemplate restTemplate = new RestTemplate();

    public List<Map<String, String>> buscarHabilidades(String nome) {
        String url = "https://ddragon.leagueoflegends.com/cdn/13.6.1/data/en_US/champion/" + nome + ".json";

        Map<String, Object> resposta = restTemplate.getForObject(url, Map.class);

        if (resposta != null && resposta.containsKey("data")) {
            Map<String, Object> data = (Map<String, Object>) resposta.get("data");
            Map<String, Object> campeaoJson = (Map<String, Object>) data.get(nome);

            List<Map<String, String>> habilidades = new ArrayList<>();

            List<Map<String, Object>> spells = (List<Map<String, Object>>) campeaoJson.get("spells");
            for (Map<String, Object> spell : spells) {
                Map<String, String> habilidade = new HashMap<>();
                habilidade.put("nome", (String) spell.get("name"));
                habilidade.put("descricao", (String) spell.get("description"));
                habilidades.add(habilidade);
            }

            return habilidades;
        }

        return Collections.emptyList();
    }
}
