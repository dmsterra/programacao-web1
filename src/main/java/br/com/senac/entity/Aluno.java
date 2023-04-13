package br.com.senac.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity //vai fazer essa classe virar uma tabela
public class Aluno {
	
	@Id //vira chave primária
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	
	@ManyToOne
	@JoinColumn(name="id_turma")
	private Turma turma;

	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Turma getTurma() {
		return turma;
	}
	public void setTurma(Turma turma) {
		this.turma = turma;
	}

}
