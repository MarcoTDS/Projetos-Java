package cadastro;

import java.util.ArrayList;


public class BancoDeDados {
	static ArrayList<Aluno> listaAluno = new ArrayList<Aluno>();
	static ArrayList<Turma> listaTurma = new ArrayList<Turma>();
	static ArrayList<Curso> listaCurso = new ArrayList<Curso>();
	static ArrayList<Disciplina> listaDis = new ArrayList<Disciplina>();
	static ArrayList<Professor> listaProf = new ArrayList<Professor>();
	
	
	public static void inserirAluno(Aluno a) {
		listaAluno.add(a);
	}
	public static ArrayList<Aluno> listarAluno(){
		return listaAluno;
	}
	
	public static void inserirTurma(Turma t) {
		listaTurma.add(t);
	}
	public static ArrayList<Turma> listarTurma(){
		return listaTurma;
	}
	
	public static void inserirCurso(Curso c) {
		listaCurso.add(c);
	}
	public static ArrayList<Curso> listarCurso(){
		return listaCurso;
	}
	
	public static void inserirDisciplina(Disciplina d) {
		listaDis.add(d);
	}
	public static ArrayList<Disciplina> listarDisciplina(){
		return listaDis;
	}
	
	public static void inserirProfessor(Professor p) {
		listaProf.add(p);
	}
	public static ArrayList<Professor> listarProfessor(){
		return listaProf;
	}
}
