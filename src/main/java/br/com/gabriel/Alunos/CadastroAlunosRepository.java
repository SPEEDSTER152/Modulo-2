package br.com.gabriel.Alunos;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CadastroAlunosRepository {

    private List<CadastroAlunos> cadastros;

    public CadastroAlunosRepository() {
        this.cadastros = new ArrayList<>();

        CadastroAlunos aluno1 = new CadastroAlunos(1, "Gabriel", 23);
        CadastroAlunos aluno2 = new CadastroAlunos(2, "Ygor", 28);
        CadastroAlunos aluno3 = new CadastroAlunos(3, "Marcio", 53);
        CadastroAlunos aluno4 = new CadastroAlunos(4, "Ana", 51);
        CadastroAlunos aluno5 = new CadastroAlunos(5, "Miguel", 45);

        this.cadastros.add(aluno1);
        this.cadastros.add(aluno2);
        this.cadastros.add(aluno3);
        this.cadastros.add(aluno4);
        this.cadastros.add(aluno5);
    }

    public List<CadastroAlunos> findall() {
        return cadastros;
    }

    public List<CadastroAlunos> listBynome(String nome){
        this.cadastros.stream()
                .filter(cad -> cad.getNome().contains(nome))
                .collect(Collectors.toList());

        return cadastros;
    }

    public List<CadastroAlunos> listByIdade(Integer idade){
        this.cadastros.stream()
                .filter(cad -> cad.getNome().equals(idade))
                .collect(Collectors.toList());

        return cadastros;
    }

    public CadastroAlunos findById(Integer id){
        return cadastros.stream()
                .filter(cad -> cad.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public void post(CadastroAlunos cadastroAlunos){
    this.cadastros.add(cadastroAlunos);
    }
    public Integer count(){
        return cadastros.size();
    }
}
