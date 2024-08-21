package GestaoDeTarefas;

import java.time.LocalDate;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
@RequestScoped
@ManagedBean(name = "tarefaBean")
public class TarefaBean {
	private String titulo;
	private String descricao;
	private String responsavel; // Classe Usuario
	private String prioridade; // Enum Prioridade
	private LocalDate deadline; 
	
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getResponsavel() {
		return responsavel;
	}
	public void setResponsavel(String usuario) {
		this.responsavel = usuario;
	}
	public String getPrioridade() {
		return prioridade;
	}
	public void setPrioridade(String prioridade) {
		this.prioridade = prioridade;
	}
	public LocalDate getDeadline() {
		return deadline;
	}
	public void setDeadline(LocalDate deadline) {
		this.deadline = deadline;
	}
}
