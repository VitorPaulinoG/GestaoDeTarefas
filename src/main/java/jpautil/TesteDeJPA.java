package jpautil;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import dao.GenericDAO;
import entities.Prioridade;
import entities.Tarefa;
import entities.Usuario;

public class TesteDeJPA {

	public static void main(String[] args) {
		salvarUsuario();
	}
	public static void salvarUsuario ()
	{
		GenericDAO<Usuario> dataAccessUsuario = new GenericDAO<Usuario>();
		
		Usuario usuario = new Usuario();
		usuario.setName("Fulano");
		usuario.setEmail("fulano@gmail.com");
		usuario.setPassword("1234");
		dataAccessUsuario.salvar(usuario);
		
	}
	public static void salvarTarefa ()
	{
		GenericDAO<Usuario> dataAccessUsuario = new GenericDAO<Usuario>();
		
		Usuario usuario = new Usuario();
		usuario.setName("Fulano");
		usuario.setEmail("fulano@gmail.com");
		usuario.setPassword("1234");
		dataAccessUsuario.salvar(usuario);
		
		
		GenericDAO<Tarefa> dataAccess = new GenericDAO<Tarefa>();
		Tarefa tarefa =	new Tarefa();
		
		tarefa.setTitulo("Almoçar");
		tarefa.setDescricao("almocinho");
		tarefa.setPrioridade(Prioridade.MEDIA);
//		tarefa.setDeadline(Date.parse(""));
		tarefa.setResponsavel(usuario);
		
		
		dataAccess.salvar(tarefa);
	}
	
	public static void buscarUsuario () {
		GenericDAO<Usuario> dao = new GenericDAO<Usuario>();
		Usuario user = new Usuario();
		user.setId(1L);
		user = dao.buscar(user);
		
		System.out.println(user.getName());
		
	}
	
	public static void listarUsuarios ()
	{
		GenericDAO<Usuario> dao = new GenericDAO<Usuario>();
		List<Usuario> lista = dao.listar(Usuario.class);
		for (Usuario user : lista)
		{
			System.out.println(user.getName());
		}
	}

}
