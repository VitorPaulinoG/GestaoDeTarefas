package gestaotarefas;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIInput;
import javax.faces.model.SelectItem;

import dao.GenericDAO;
import dao.TarefaDAO;
import entities.Tarefa;
import entities.Usuario;
import entities.Prioridade;
import entities.SituacaoTarefa;
@SessionScoped
@ManagedBean(name = "tarefaBean")
public class TarefaBean {
	private Tarefa tarefa = new Tarefa();


	
	
//	private Usuario usuarioSelecionado = new Usuario();
	private Long usuarioSelecionadoId;

	private List<Usuario> usuarios = new ArrayList<Usuario>();
	
	private Prioridade prioridadeSelecionada; 
	
	private GenericDAO<Tarefa> dataAccess = new GenericDAO<Tarefa>();
	
	private FiltroTarefa filtro = new FiltroTarefa();
	

	
	private List<Tarefa> tarefas = new ArrayList<Tarefa>();
	
	
	public String salvar ()
	{
		GenericDAO<Usuario> dao = new GenericDAO<Usuario>();
		Long id = usuarioSelecionadoId;
		Usuario user = new Usuario();
		user.setId(id);
		user = dao.buscar(user);
		tarefa.setResponsavel(user);
		tarefa.setSituacao(SituacaoTarefa.EMANDAMENTO);
		tarefa.setPrioridade(prioridadeSelecionada);
		dataAccess.salvar(tarefa);
		limparCampos();
		//carregarTarefas();
		return "";
	}
	public String editar ()
	{
		prioridadeSelecionada = tarefa.getPrioridade();
		usuarioSelecionadoId = tarefa.getResponsavel().getId();
		return "editartarefa";
	}

	public String atualizar ()
	{
		
		tarefa = dataAccess.mesclar(tarefa);
		carregarTarefas();
		return "";
	}
	
	public String concluir ()
	{
		tarefa.setSituacao(SituacaoTarefa.CONCLUIDA);
		
		return atualizar();
	}
	
	public void filtrar ()
	{
		TarefaDAO dao = new TarefaDAO();
		tarefas = dao.filtrar(filtro);
	}
	public String remover ()
	{
		
		dataAccess.remover(tarefa);
		carregarTarefas();
		return "";
	}
	
	public void limparCampos ()
	{
		tarefa = new Tarefa();
		setUsuarioSelecionadoId(0L);
		setPrioridadeSelecionada(null);
	}
	
	
	@PostConstruct
	public void init ()
	{
		atualizaListaDeUsuarios();
		carregarTarefas();
	}
	
	
	public void atualizaListaDeUsuarios()
	{
		GenericDAO<Usuario> dao = new GenericDAO<Usuario>();
		this.setUsuarios(dao.listar(Usuario.class));
	}
	
	public String irParaCadastro ()
	{
		limparCampos();
		return "cadastrotarefa?faces-redirect=true";
	}
	
	public void carregarTarefas ()
	{
		tarefas = dataAccess.listarOrdenado(Tarefa.class);
	}
	
	public List<SelectItem> getPrioridades() {
        List<SelectItem> items = new ArrayList<SelectItem>();
        for (Prioridade prioridade : Prioridade.values()) {
            items.add(new SelectItem(prioridade, prioridade.getLabel()));
        }
        return items;
    }
	
	public List<SelectItem> getSituacoes() {
        List<SelectItem> items = new ArrayList<SelectItem>();
        for (SituacaoTarefa situacao : SituacaoTarefa.values()) {
            items.add(new SelectItem(situacao, situacao.getLabel()));
        }
        return items;
    }
	
	
	
	
	public List<Tarefa> getTarefas ()
	{
		return tarefas;
	}
	
	public Tarefa getTarefa() {
		return tarefa;
	}
	public void setTarefa(Tarefa tarefa) {
		this.tarefa = tarefa;
	}
	public GenericDAO<Tarefa> getDataAccess() {
		return dataAccess;
	}
	public void setDataAccess(GenericDAO<Tarefa> dataAccess) {
		this.dataAccess = dataAccess;
	}


	public FiltroTarefa getFiltro() {
		return filtro;
	}
	public void setFiltro(FiltroTarefa filtro) {
		this.filtro = filtro;
	}

	public void setTarefas(List<Tarefa> tarefas) {
		this.tarefas = tarefas;
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

	public Long getUsuarioSelecionadoId() {
		return usuarioSelecionadoId;
	}
	
	public void setUsuarioSelecionadoId(Long item) {
		this.usuarioSelecionadoId = item;
	}


}

