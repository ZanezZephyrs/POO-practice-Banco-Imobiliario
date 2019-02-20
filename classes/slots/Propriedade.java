package slots;
import entidade.principal;
import entidade.Jogador;
import java.util.Scanner;

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
	
	public void executar(Jogador alvo) {
		Scanner scan=new Scanner(System.in);
		if (this.dono.getID()==0) { /*proprieda pertence ao Banco, disponivel para compra*/
				/*fala com o jogador*/
				System.out.println("Propriedade disponivel para compra, Deseja comprar?(Y/N)");
				System.out.print("Resposta:");
				/*le resposta*/
				String resp=scan.nextLine();
				if(resp.equals("Y")) { /*jogador ira comprar, nesse momento não é verificado se possui dinheiro(implementação futura*/
					alvo.setDinheiro_total(alvo.getDinheiro_total()-this.valor_compra);
					this.dono=alvo;
					System.out.println("Compra efetuada!");
				}else if(resp.equals("N")) {
					System.out.println("Compra não efetuada!");
				}
		}
		else {/*propriedade pertence a algum jogador, deve-se pagar aluguel*/
			int alvo_total=alvo.getDinheiro_total();
			if(alvo_total< this.aluguel[this.n_casas]) {/*não há dinheiro suficiente pra pagar*/
				/*inserir opção de hipotecar*/
				alvo.setDinheiro_total(-1);/*faliu*/
				this.dono.setDinheiro_total(this.dono.getDinheiro_total()+alvo_total);
			}
			else {
				this.dono.setDinheiro_total(this.dono.getDinheiro_total()+this.aluguel[this.n_casas]);
				/*a linha abaixo decrescenta o dinheiro do pagante*/
				alvo.setDinheiro_total(alvo_total-this.aluguel[this.n_casas]);
			}
		}
	}
}
