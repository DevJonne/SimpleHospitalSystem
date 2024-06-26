package Main.Professor;


import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;


public class PacienteProfessor {
private String nome;
private String sobrenome;
private LocalDate dataNascimento;
private ArrayList<AtendimentoProfessor> atendimentos;

public PacienteProfessor(){
atendimentos = new ArrayList<AtendimentoProfessor>();
}

public PacienteProfessor(String nome2, LocalDate dataNascimento2) {
}

public String getNome() {
return nome;
}

public void setNome(String nome) {
this.nome = nome;
}

public LocalDate getDataNascimento() {
return dataNascimento;
}



public void setDataNascimento(LocalDate dataNascimento)
    {
    this.dataNascimento = dataNascimento;
    }

        public ArrayList<AtendimentoProfessor> getAtendimentos()  {
        return atendimentos;
    }

public void adicionarConsulta(AtendimentoProfessor atendimento) {
atendimentos .add(atendimento);
}

public int getIdade(){
LocalDate dataAtual = LocalDate.now();
// Calcula a diferença entre as datas

Period periodo = Period.between(dataNascimento,
dataAtual);
// Obtém a idade da pessoa
return periodo.getYears();
}

@Override
    public String toString(){
    String retorno = "Nome: "+nome+" "+sobrenome;
    DateTimeFormatter formatoBr = DateTimeFormatter.
    ofPattern("dd/MM/yyyy");
    String data = formatoBr.format(this.dataNascimento);
    retorno += "Data de nascimento: "+data;
    retorno += "Idade: "+getIdade();
    return retorno;
    }
}