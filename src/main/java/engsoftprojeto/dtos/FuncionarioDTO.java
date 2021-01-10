package engsoftprojeto.dtos;

import engsoftprojeto.models.Cargo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FuncionarioDTO {
    private String nome;
    private String email;
    private String password;
    private String cargo;


    public Cargo getCargoFromStr(String cargoSTR){
        switch (cargoSTR) {
            case "AN_JR":
                return Cargo.AN_JR;
            case "AN_SR":
                return Cargo.AN_SR;
            case "DEV_JR":
                return Cargo.DEV_JR;
            case "DEV_SR":
                return Cargo.DEV_SR;
            default:
                return Cargo.SEMCARGO;
        }
    }
}
