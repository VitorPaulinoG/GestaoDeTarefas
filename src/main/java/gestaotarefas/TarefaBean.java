package gestaotarefas;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;

import dao.GenericDAO;
import entities.Tarefa;
import entities.Usuario;
import entities.Prioridade;
import entities.SituacaoTarefa;
@ViewScoped
@ManagedBean(name = "tarefaBean")
public class TarefaBean {
	private Tarefa tarefa = new Tarefa();
	
	
	private Usuario usuarioSelecionado = new Usuario();
	private Long item;

	private List<Usuario> usuarios = new ArrayList<Usuario>();
	
	private Prioridade prioridadeSelecionada; 
	
	private GenericDAO<Tarefa> dataAccess = new GenericDAO<Tarefa>();
	
	
	
	
	
	public String salvar ()
	{
		GenericDAO<Usuario> dao = new GenericDAO<Usuario>();
		Long id = item;
		Usuario user = new Usuario();
		user.setId(id);
		user = dao.buscar(user);
		tarefa.setResponsavel(user);
		tarefa.setSituacao(SituacaoTarefa.EMANDAMENTO);
		tarefa.setPrioridade(prioridadeSelecionada);
		dataAccess.salvar(tarefa);
		tarefa = new Tarefa();
		return "";
	}
	
	@PostConstruct
	public void atualizaListaDeUsuarios()
	{
		GenericDAO<Usuario> dao = new GenericDAO<Usuario>();
		this.setUsuarios(dao.listar(Usuario.class));
	}
	
	
	public List<SelectItem> getPrioridades() {
        List<SelectItem> items = new ArrayList<SelectItem>();
        for (Prioridade prioridade : Prioridade.values()) {
            items.add(new SelectItem(prioridade, prioridade.getLabel()));
        }
        return items;
    }


	
	
	
	public void setTarefa(Tarefa tarefa) {
		this.tarefa = tarefa;
	}
	public Tarefa getTarefa() {
		return tarefa;
	}
	public GenericDAO<Tarefa> getDataAccess() {
		return dataAccess;
	}
	public void setDataAccess(GenericDAO<Tarefa> dataAccess) {
		this.dataAccess = dataAccess;
	}


	public Usuario getUsuarioSelecionado() {
		return usuarioSelecionado;
	}


	public void setUsuarioSelecionado(Usuario usuarioSelecionado) {
		this.usuarioSelecionado = usuarioSelecionado;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Prioridade getPrioridadeSelecionada() {
		return prioridadeSelecionada;
	}

	public void setPrioridadeSelecionada(Prioridade prioridadeSelecionada) {
		this.prioridadeSelecionada = prioridadeSelecionada;
	}

	public Long getItem() {
		return item;
	}
	
	public void setItem(Long item) {
		this.item = item;
	}
}

