package entities;

public enum SituacaoTarefa {
	EMANDAMENTO("Em Andamento"),
	CONCLUIDA("Concluída");
	
	private final String label;

    SituacaoTarefa(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
