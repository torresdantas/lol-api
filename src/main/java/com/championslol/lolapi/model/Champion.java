package com.championslol.lolapi.model;
import java.util.List;


public class Champion {
    private String nome;
    private String id;
    private List<Ability> spells;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Ability> getSpells() {
        return spells;
    }

    public void setSpells(List<Ability> spells) {
        this.spells = spells;
    }
}
