package br.com.gabriel.Alunos;

public class AlunoInesistente extends RuntimeException{

    public AlunoInesistente(String message){
        super(message);
    }
}
