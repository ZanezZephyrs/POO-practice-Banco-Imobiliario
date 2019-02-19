package slots;
import entidade.principal;

public class Propriedade extends Slot{
	
	private int[] aluguel;/*vetor com os alugueis o index do aluguel atual é o numero de casas,
							i.e sem casas, aluguel[0], hotel, aluguel[5]*/
	
	private int n_casas;/*n_casas na propriedade*/
	
	private principal dono;/*dono da propriedade, antes da compra por jogador, o banco é dono*/
	
	private int valor_compra;/*valor para comprar do banco*/
	
	private int valor_hipoteca;/*valor da hipoteca*/
	
	public Propriedade(int id, int[] valores, String name, int casas, principal dono, int compra, int hipoteca) {
		super(id, name);
		this.aluguel=valores;
		this.n_casas=casas;
		this.dono=dono;
		this.valor_compra=compra;
		this.valor_hipoteca=hipoteca;
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
	
	private String string_vetor(int nums[]) {
		String out="";
		int i;
		for(i=0;i<nums.length;i++) {
			out+= nums[i];
			out+=" ";
		}
		return out;
	}
	
	public String toString() {/*adicionar resto das informações*/
		String out=super.toString();
		out+="Numero de casas:"+this.n_casas+"\n";
		out+="aluguel atual:"+ this.aluguel[this.n_casas]+"\n";
		out+="conjunto de aluguel:"+ string_vetor(this.aluguel)+"\n";
		out+="Dono:" +this.dono.getNome()+"\n";
		out+="Valor de compra:"+this.valor_compra+"\n";
		out+="Valor de hipoteca:"+this.valor_hipoteca+"\n";
		
		return out;
	}
}
