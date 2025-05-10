package com.championslol.lolapi.controller;

import com.championslol.lolapi.model.Champion;
import com.championslol.lolapi.service.ChampionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/champions")


public class ChampionController {
    @Autowired
    private ChampionService championService;


    @GetMapping("/{name}/skills")
    public List<Map<String , String>> getChampionsSkills(@PathVariable("name") String name){
        return championService.buscarHabilidades(name);
    }
}
