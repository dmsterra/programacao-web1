package br.com.senac.inicializacao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import br.com.senac.entity.Aluno;
import br.com.senac.entity.Curso;
import br.com.senac.entity.Professor;
import br.com.senac.entity.Turma;
import br.com.senac.service.AlunoService;
import br.com.senac.service.CursoService;
import br.com.senac.service.ProfessorService;
import br.com.senac.service.TurmaService;

@Component
public class Init implements ApplicationListener<ContextRefreshedEvent> {
	
	@Autowired
	AlunoService alunoService;
	@Autowired
	ProfessorService professorService;
	@Autowired
	CursoService cursoService;
	@Autowired
	TurmaService turmaService;
	
	public void onApplicationEvent(ContextRefreshedEvent event) {
		
		//aluno
		Aluno aluno1 = new Aluno();
		aluno1.setNome("Robson");
		alunoService.salvar(aluno1);
		
		List<Aluno> listaAlunos = alunoService.buscarTodosAlunos();
		
		for(Aluno aluno:listaAlunos) {
			System.out.println(aluno.getNome());
		}
		
		
		//professor
		Professor professor1 = new Professor();
		professor1.setNome("Marcelo Estruc");
		professorService.salvar(professor1);
		
		List<Professor> listaProfessores = professorService.buscarTodosProfessores();
		
		for (Professor professor : listaProfessores) {
			System.out.println(professor.getNome());
		}
		
		
		//curso
		Curso curso1 = new Curso();
		curso1.setNome("Programação Web I");
		cursoService.salvar(curso1);
		
		List<Curso> listaCursos = cursoService.buscarTodosCursos();
		
		for (Curso curso : listaCursos) {
			System.out.println(curso.getNome());
		}
		
		
		//turma
		Turma turma1 = new Turma();
		turma1.setNome("ADS 2021.2n");
		turmaService.salvar(turma1);
		
		List<Turma> listaTurmas = turmaService.buscarTodasTurmas();
		
		for (Turma turma : listaTurmas) {
			System.out.println(turma.getNome());
		}
	}

}
