package EngSoftProjeto.dtos;

import EngSoftProjeto.Models.Funcionario;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FuncionarioCreateDTO {
    Logger logger= LoggerFactory.getLogger(this.getClass());

    private String nome;
    private String email;
    private String cargo;
    private List<TarefaCreateDTO> tarefas=new ArrayList<>();


    public Funcionario converter(){
        logger.info("Convertido para Modelo");
        Funcionario funcionario=new Funcionario();
        funcionario.setNome(this.getNome());
        funcionario.setEmail(email);
        return funcionario;
    }
}
