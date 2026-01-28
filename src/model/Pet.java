package model;

import model.Enum.SexoPet;
import model.Enum.TipoPet;

public class Pet {
    private String nomeCompleto;
    private TipoPet tipoPet;
    private SexoPet sexoPet;
    private String enderecoComBairro;
    private float idade;
    private float peso;
    private String raca;

    public Pet(String nomeCompleto, TipoPet tipoPet, SexoPet sexoPet, String enderecoComBairro, float idade, float peso, String raca) {
        this.nomeCompleto = nomeCompleto;
        this.tipoPet = tipoPet;
        this.sexoPet = sexoPet;
        this.enderecoComBairro = enderecoComBairro;
        this.idade = idade;
        this.peso = peso;
        this.raca = raca;
    }
}
