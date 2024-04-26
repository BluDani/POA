package serializacao;

import java.io.Serializable;

public class Alunos implements Serializable{
	private String nome;
	private String matricula;
	private transient String dataNasc;
	
	public Alunos(String nome, String dataNasc, String matricula) {
		super();
		this.nome = nome;
		this.dataNasc = dataNasc;
		this.matricula = matricula;
	}
	
	public String toString() {
		return "Pessoa [Nome=" + nome + ", Data de nascimento=" + dataNasc + ", Matrícula=" + matricula + "]";
	}
	
		public String getNome() {
			return nome;
			}
		public void setNome(String nome) {
			this.nome = nome;
			}
		
		public String getdataNasc() {
			return dataNasc;
			}
		public void setdataNasc(String dataNasc) {
			this.dataNasc = dataNasc;
			}
		
		public String getMatricula() {
			return matricula;
			}
		public void setMatricula(String matricula) {
			this.matricula = matricula;
			}	
}