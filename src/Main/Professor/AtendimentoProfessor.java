package Main.Professor;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
public class AtendimentoProfessor {
private LocalDate data;
private String descricao;

public AtendimentoProfessor(LocalDate dataAtendimento, String descricao2) {
}
public String getDescricao() {
return descricao;
}
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

        @Override
        public String toString(){
            DateTimeFormatter formatoBr = DateTimeFormatter.
            ofPattern("dd/MM/yyyy");
                String data = formatoBr.format(this.data);
                String retorno = "Data: "+data;
                retorno += "InInformações: "+descricao;
            return retorno;
        }
}
