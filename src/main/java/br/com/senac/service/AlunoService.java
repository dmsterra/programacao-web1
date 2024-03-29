package br.com.senac.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senac.entity.Aluno;
import br.com.senac.repository.AlunoRepository;

@Service
public class AlunoService {
	
	@Autowired
	AlunoRepository repoAluno;
	
	public List<Aluno> buscarTodosAlunos(){
		return repoAluno.findAll();
	}
	
	public Aluno salvar(Aluno aluno){
		return repoAluno.save(aluno);
	}
	
	public Aluno buscaPorID(Integer id) throws ObjectNotFoundException{
		Optional<Aluno> aluno = repoAluno.findById(id);
		return aluno.orElseThrow(() -> new ObjectNotFoundException(aluno, "Aluno nao encontrado. Id: " + id));
	}
	
	public Aluno salvarAlteração(Aluno alunoAlterado) throws ObjectNotFoundException {
		Aluno aluno = buscaPorID(alunoAlterado.getId());
		aluno.setId(alunoAlterado.getId());
		aluno.setNome(alunoAlterado.getNome());
		return salvar(aluno);
	}
	
	public void excluir(Integer id) {
		repoAluno.deleteById(id);
	}

}
