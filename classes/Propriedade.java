
public class Propriedade extends Slot{
	private String nome;/*nome da propriedade*/
	private int[] aluguel;/*vetor com os alugueis
							o index do aluguel atual é o numero de casas,
							i.e sem casas, aluguel[0], hotel, aluguel[5]*/
	private int n_casas;/*n_casas na propriedade*/
	public Propriedade(int id, int[] valores, String name, int casas) {
		super(id);
		this.aluguel=valores;
		this.nome=name;
		this.n_casas=casas;
	}
	public void SetNome(String nome) {
		this.nome=nome;
	}
	public String GetNome() {
		return this.nome;
	}
	public void SetAlguel(int[] aluguel) {
		this.aluguel=aluguel;
	}
	public int[] GetAluguel() {
		return this.aluguel;
	}
	public void SetN_Casas(int casas) {
		this.n_casas=casas;
	}
	public int GetN_Casas() {
		return this.n_casas;
	}
	public String toString() {
		String out=super.toString();
		out+="nome:"+this.nome+"\n";
		out+="Numero de casas:"+this.n_casas+"\n";
		out+="aluguel atual"+ this.aluguel[this.n_casas]+"\n";
		return out;
	}
}
