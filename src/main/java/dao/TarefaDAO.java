package dao;

import java.util.List;

import javax.persistence.Query;

import entities.SituacaoTarefa;
import entities.Tarefa;
import gestaotarefas.FiltroTarefa;

public class TarefaDAO extends GenericDAO<Tarefa>{
	
	public List<Tarefa> filtrar (FiltroTarefa filtro)
	{
		boolean numero, responsavel, situacao, titulo;
		
		numero = filtro.getNumero() != null && filtro.getNumero() > 0;
		responsavel = filtro.getResponsavelSelecionadoId() != null && filtro.getResponsavelSelecionadoId() > 0;
		situacao = filtro.getSituacaoSelecionada() != null;
		titulo = filtro.getTituloDescricao() != null && filtro.getTituloDescricao() != "";
		
		
		
		String q = "from Tarefa where ";
		if(numero)
		{
			q += "id = :num ";
			if(responsavel)
			{
				q += "and responsavel.id = :responsavelId ";
			} 
			if (situacao)
			{
				q += "and situacao = :situacao ";
			} 
			if (titulo)
			{
				q += "and (titulo like :expr or descricao like :expr) ";
			}
		} else {
			if(responsavel)
			{
				q += "responsavel.id = :responsavelId ";
				if(situacao)
				{
					q += "and situacao = :situacao ";
				} 
				if(titulo)
				{
					q += "and (titulo like :expr or descricao like :expr) ";
				}
			} else if (situacao)
			{
				q += "situacao = :situacao ";
				if(titulo)
				{
					q += "and (titulo like :expr or descricao like :expr) ";
				}
			} else if (titulo)
			{
				q += "(titulo like :expr or descricao like :expr) ";
			}
		}
		
		
		
		
		
		Query query = super.entityManager.createQuery(q);
		if(numero)
			query.setParameter("num", filtro.getNumero());
		if(responsavel)
			query.setParameter("responsavelId", filtro.getResponsavelSelecionadoId());
		if(situacao)
			query.setParameter("situacao", filtro.getSituacaoSelecionada()); 
		if(titulo)
			query.setParameter("expr", "%" + filtro.getTituloDescricao() + "%");
		
		return query.getResultList();
	}

}
