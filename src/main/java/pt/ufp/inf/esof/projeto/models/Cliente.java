package pt.ufp.inf.esof.projeto.models;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Cliente {
    private Integer id;
    public String nome;
    private List<Projeto> projetos = new ArrayList<>();

     String consultarEstadoProjeto(Projeto p) {
        for (Projeto projeto : projetos) {
            if (p.getNome().equals(projeto.getNome())) {
                return (projeto.getNome() + " " + projeto.getPercentagemDeConclusao());
            }
        }
        return null;
    }

    String  consultarDuracaoProjeto(Projeto p) {
        for (Projeto projeto : projetos) {
            if (p.getNome().equals(projeto.getNome())) {
                return (projeto.getNome() + " " + projeto.getDuracao());
            }
        }
        return null;

    }

    String  ConsultarPrecoProjeto(Projeto p) {
        for (Projeto projeto : projetos) {
            if (p.getNome().equals(projeto.getNome())) {
                return (projeto.getNome() + " " + projeto.getPrecoFinal());
            }
        }
        return null;
    }

}