package br.com.gabriel.Alunos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CadastroAlunosService {

    @Autowired
    private static CadastroAlunosRepository cadastroAlunosRepository;

    private CadastroAlunos cadastroAlunos;

    public static List<CadastroAlunos> findall(){

        return cadastroAlunosRepository.findall();
    }

    public static List<CadastroAlunos> listBynome(String nome) {


        if (cadastroAlunosRepository.listBynome(nome).isEmpty()) {
            throw new AlunoInesistente("Aluno Inesistente" + nome);
        } else {
            return cadastroAlunosRepository.listBynome(nome);
        }
    }

    public  CadastroAlunos findById(Integer id){
    if(cadastroAlunosRepository.findById(id) == null){
        throw new AlunoInesistente("id Inesistente: " + id);
    }
    return cadastroAlunosRepository.findById(id);
    }

    public Integer post(CadastroAlunos cadastroAlunos){
        if(cadastroAlunos.getId() == null){
            cadastroAlunos.setId(cadastroAlunosRepository.count()+1);
        }
        cadastroAlunosRepository.post(cadastroAlunos);
        return cadastroAlunos.getId();
    }
}
