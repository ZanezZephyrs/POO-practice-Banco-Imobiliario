package slots;
import entidade.principal;
import entidade.Jogador;
import java.util.Scanner;
import mecanica.Motor;

public class Propriedade extends Slot{
	
	private int[] aluguel;/*vetor com os alugueis o index do aluguel atual é o numero de casas,
							i.e sem casas, aluguel[0], hotel, aluguel[5]*/
	
	private int n_casas;/*n_casas na propriedade*/
	
	private principal dono;/*dono da propriedade, antes da compra por jogador, o banco é dono*/
	
	private int valor_compra;/*valor para comprar do banco*/
	
	private int valor_hipoteca;/*valor da hipoteca*/
	
	private String cor;
	
	private int total_conjunto;
	
	private int custo_casa;
	
	public Propriedade(int id, int[] valores, String name, int casas, principal dono, int compra, int hipoteca, String cor, int tot, int casa) {
		super(id, name);
		this.aluguel=valores;
		this.n_casas=casas;
		this.dono=dono;
		this.valor_compra=compra;
		this.valor_hipoteca=hipoteca;
		this.cor=cor;
		this.total_conjunto=tot;
		this.custo_casa=casa;
	}
	public void SetAlguel(int[] aluguel) {
		this.aluguel=aluguel;
	}
	public int[] GetAluguel() {
		return this.aluguel;
	}
	public int getTotal_conjunto() {
		return this.total_conjunto;
	}
	public String getCor() {
		return this.cor;
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
	
	public void executar(Jogador alvo, Motor motor) {
		Scanner scan=new Scanner(System.in);
		String resp;
		if (this.dono.getID()==0) { /*proprieda pertence ao Banco, disponivel para compra*/
				/*fala com o jogador*/
				System.out.printf("Propriedade disponivel para compra, valor:%d Deseja comprar?(Y/N)\n",this.valor_compra);
				if(alvo.getDinheiro_total()< this.valor_compra) {/*sem dinheiro pra comprar*/
					System.out.println("Infelizmente você não possui dinheiro suficiente para comprar a propriedade!");
					return;
				}
				System.out.print("Resposta:");
				/*le resposta*/
				resp=scan.nextLine();
				if(resp.equalsIgnoreCase("Y")) { 
					
					alvo.setDinheiro_total(alvo.getDinheiro_total()-this.valor_compra);
					this.dono=alvo;
					alvo.getPosses().add(this);
					System.out.println("Compra efetuada!");
				}else if(resp.equalsIgnoreCase("N")) {
					System.out.println("Compra não efetuada!");
				}
		}else if(alvo.getID()==this.dono.getID()) {/*caiu na propria propriedade*/
			System.out.println("Propriedade pertence ao proprio jogador");
			if(this.n_casas==5) {
				System.out.println("Propriedade ja possui Hotel. Não é possivel comprar mais casas!");
				return;
			}
			if(motor.pode_comprar_casa(alvo.getPosses(), this.cor, this.total_conjunto)) {
				System.out.printf("Jogador possui todas as propriedades da cor %s, pode comprar casa!\ncusto da casa: %d, deseja comprar?(Y/N)\n Resposta:",this.cor, this.custo_casa);
				resp=scan.nextLine();
				if(resp.equalsIgnoreCase("Y")) {/*jogador pretende comprar casa*/
					if(alvo.getDinheiro_total()<this.custo_casa) {
						System.out.printf("Dinheiro insuficiente\nDinheiro disponivel:%d\ncusto da casa: %d\nCompra cancelada!!", alvo.getDinheiro_total(), this.custo_casa);
					}else {/*possui dinheiro pra comprar*/
						alvo.setDinheiro_total(alvo.getDinheiro_total()-this.custo_casa);
						this.n_casas++;
						System.out.println("Compra da casa efetuada com Sucesso");
					}
					
				}else if(resp.equalsIgnoreCase("N")) {
					System.out.println("Casa Não comprada!!");
				}
			}else {
				System.out.printf("Jogador não possui todas as propriedades da cor %s, não pode comprar casa\n",this.cor);
			}
		}
		else {/*propriedade pertence a algum jogador, deve-se pagar aluguel*/
			int alvo_total=alvo.getDinheiro_total();
			System.out.printf("Esta propriedade pertence a %s, aluguel %d\n", this.dono.getNome(), this.aluguel[this.n_casas]);
			if(alvo_total< this.aluguel[this.n_casas]) {/*não há dinheiro suficiente pra pagar*/
				/*inserir opção de hipotecar*/
				System.out.printf("O Jogador %s não possui dinheiro para pagar\n", alvo.getNome());
				alvo.setDinheiro_total(-1);/*faliu*/
				motor.getJogadores().remove(alvo);
				System.out.printf("O Jogador %s Faliu e foi removido do jogo\n", alvo.getNome());
				this.dono.setDinheiro_total(this.dono.getDinheiro_total()+alvo_total);
			}
			else {
				this.dono.setDinheiro_total(this.dono.getDinheiro_total()+this.aluguel[this.n_casas]);
				/*a linha abaixo decrescenta o dinheiro do pagante*/
				alvo.setDinheiro_total(alvo_total-this.aluguel[this.n_casas]);
				System.out.printf("%s pagou %d para %s\n", alvo.getNome(), this.aluguel[this.n_casas],this.dono.getNome());
			}
		}
	}
}
