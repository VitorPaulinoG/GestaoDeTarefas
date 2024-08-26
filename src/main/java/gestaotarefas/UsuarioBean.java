package gestaotarefas;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import dao.GenericDAO;
import entities.Tarefa;
import entities.Usuario;

@SessionScoped
@ManagedBean(name = "usuarioBean")
public class UsuarioBean {
	private Usuario usuario = new Usuario();
	private GenericDAO<Usuario> dataAccess = new GenericDAO<Usuario>();
	private List<Usuario> usuarios = new ArrayList<Usuario>();
	
	// Metodos
	public String salvar ()
	{
		if(!usuario.getEmail().isBlank() && !usuario.getEmail().isEmpty() && !usuario.getName().isBlank() && !usuario.getName().isEmpty())
		{
			dataAccess.salvar(usuario);
			atualizaListaDeUsuarios();
			limparCampos();
		}
		return "";
	}
	public void limparCampos ()
	{
		usuario = new Usuario();
		
	}
	public String remover ()
	{
		dataAccess.remover(usuario);
		return "";
	}
	
	@PostConstruct
	public void init ()
	{
		atualizaListaDeUsuarios();
	}
	
	public void atualizaListaDeUsuarios()
	{
		this.setUsuarios(dataAccess.listar(Usuario.class));
	}
	
	// Getters e Setters
	
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public GenericDAO<Usuario> getDataAccess() {
		return dataAccess;
	}

	public void setDataAccess(GenericDAO<Usuario> dataAccess) {
		this.dataAccess = dataAccess;
	}
	
	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
}
