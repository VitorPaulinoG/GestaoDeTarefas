package gestaotarefas;

import entities.SituacaoTarefa;

public class FiltroTarefa {
	private Long numero;
	private String tituloDescricao;
	private SituacaoTarefa situacaoSelecionada;
	private Long responsavelSelecionadoId;
	
	
	
	
	public Long getNumero() {
		return numero;
	}
	public void setNumero(Long numero) {
		this.numero = numero;
	}
	public String getTituloDescricao() {
		return tituloDescricao;
	}
	public void setTituloDescricao(String tituloDescricao) {
		this.tituloDescricao = tituloDescricao;
	}
	public SituacaoTarefa getSituacaoSelecionada() {
		return situacaoSelecionada;
	}
	public void setSituacaoSelecionada(SituacaoTarefa situacaoSelecionada) {
		this.situacaoSelecionada = situacaoSelecionada;
	}
	public Long getResponsavelSelecionadoId() {
		return responsavelSelecionadoId;
	}
	public void setResponsavelSelecionadoId(Long responsavelSelecionadoId) {
		this.responsavelSelecionadoId = responsavelSelecionadoId;
	}
}
