package slots;
import entidade.principal;
import slots.Slot;
import java.util.Scanner;
import entidade.Jogador;

public class Roads extends Slot{
	private principal dono;/*dono da propriedade, antes da compra por jogador, o banco é dono*/
	private int custo_compra;
	
	public Roads(int id, String name, principal dono, int custo) {
		super(id, name);
		this.dono=dono;
		this.custo_compra=custo;
	}
	
	public String toString() {
		String out=super.toString();
		out+="Dono:" + this.dono.getNome()+"\n";
		out+="Custo de Compra:"+ this.custo_compra+"\n";
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
			if(resp.equals("Y")) {/*propriedade ira ser comprada*/
				alvo.setDinheiro_total(alvo.getDinheiro_total()-this.custo_compra);
				this.dono=alvo;
				alvo.setN_rodovias(alvo.getN_rodovias()+1);
				System.out.println("Compra efetuada!");
			}else { 
				System.out.println("Compra Não efetuada!");
			}
			
	}else {/*propriedade pertence a algum jogador, deve-se pagar aluguel    
	criar n_rodovias em jogador, 25* n rodovias é o valor a ser pago aqui*/
			int alvo_total=alvo.getDinheiro_total();
			int deve_pagar=((Jogador) this.dono).getN_rodovias()*25;
			if(alvo_total<deve_pagar) {/*não há dinheiro suficiente pra pagar*/
				/*inserir opção de hipotecar*/
				alvo.setDinheiro_total(-1);/*faliu*/
				this.dono.setDinheiro_total(this.dono.getDinheiro_total()+alvo_total);
			}
			else {
				this.dono.setDinheiro_total(this.dono.getDinheiro_total()+deve_pagar);
				/*a linha abaixo decrescenta o dinheiro do pagante*/
				alvo.setDinheiro_total(alvo_total-deve_pagar);
			}
		}
	}
}
		

