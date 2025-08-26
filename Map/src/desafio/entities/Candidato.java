package desafio.entities;

import java.util.Objects;

public class Candidato {
    private String nome;
    private Integer voto;

    public Candidato(String nome, Integer voto) {
        this.nome = nome;
        this.voto = voto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getVoto() {
        return voto;
    }

    public void setVoto(Integer voto) {
        this.voto = voto;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Candidato candidato)) return false;
        return Objects.equals(nome, candidato.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(nome);
    }
}

