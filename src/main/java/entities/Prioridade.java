package entities;

public enum Prioridade {
	ALTA("Alta"),
	MEDIA("Media"),
	BAIXA("Baixa");
	
	private final String label;

    Prioridade(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
