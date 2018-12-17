package cartas;

public class Carta {
	private String descricao;
	private String nome;
	public Carta(String descricao, String nome) {
		this.descricao=descricao;
		this.nome=nome;
	}
	public String GetNome() {
		return this.nome;
	}
	public void SetNome(String nome) {
		this.nome=nome;
	}
	public String GetDescricao() {
		return this.descricao;
	}
	public void SetDescricao(String des) {
		this.descricao=des;
	}
	public String toString() {
		String out="Nome da Carta:"+this.nome+"\n";
		out+="Descrição:"+this.descricao+"\n";
		return out;
		}
	public void aplicar_efeito() {
	}
	
	}
