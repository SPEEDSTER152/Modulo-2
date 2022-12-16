package br.com.gabriel.Alunos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cadastro")
public class CadastroAlunosController {

    @Autowired
    private CadastroAlunosService cadastroAlunosService;

    @GetMapping
    public ResponseEntity<List<CadastroAlunos>> findall(){
        return new ResponseEntity<>(CadastroAlunosService.findall(),HttpStatus.OK);
    }
    @GetMapping("/{nome}")
    public ResponseEntity<List<CadastroAlunos>> listbynome(@PathVariable("nome") String nome) {
        return new ResponseEntity<>(CadastroAlunosService.listBynome(nome), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<CadastroAlunos>> findByid(@PathVariable("id") Integer id){
        return new ResponseEntity<>(CadastroAlunosService.findById(id), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Integer> post(@RequestBody CadastroAlunos cadastroAlunos){
        Integer id = cadastroAlunosService.post(cadastroAlunos);
        return new ResponseEntity<>(id,HttpStatus.CREATED);
    }

    @ExceptionHandler({AlunoInesistente.class})
    public ResponseEntity<String> handle(final AlunoInesistente e){
        return new ResponseEntity<>("Aluno Nao Existe", HttpStatus.NOT_FOUND);
    }
}
