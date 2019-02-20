package slots;
import entidade.principal;
import slots.Slot;
import java.util.Scanner;
import entidade.Jogador;
import mecanica.Motor;

public class Servico extends Slot {
        private principal dono;/*dono da propriedade, antes da compra por jogador, o banco Ã© dono*/
	private int custo_compra;
        
        

    public Servico(int id, String name, principal dono, int custo) {
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
        public void executar(Jogador alvo, Motor dados) {
		Scanner scan=new Scanner(System.in);
		if (this.dono.getID()==0) { /*propriedade disponivel para compra*/
			System.out.println("Propriedade disponivel para compra, deseja comprar?(Y/N)");
			System.out.print("Resposta:");
			String resp=scan.nextLine();
			if(resp.equals("Y")) {
				alvo.setDinheiro_total(alvo.getDinheiro_total()-this.custo_compra);
				this.dono=alvo;
				alvo.setN_servicos(alvo.getN_servicos()+1);
				System.out.println("Compra efetuada!");
			}else { 
				System.out.println("Compra NÃ£o efetuada!");
			}
			
	}else {/*propriedade pertence a algum jogador, deve-se verificar num de serviços, se for 2 é num dado X 10, se for 1 é num dado X 4*/
			int alvo_total=alvo.getDinheiro_total();
			int mult=((Jogador) this.dono).getN_servicos();
                        int dados_num[] = dados.lanca_dados();
                        int num = dados_num[0]+dados_num[1];
                        if (mult == 2){
                            int deve_pagar= (10 * num);
                            if(alvo_total<deve_pagar) {/*nÃ£o hÃ¡ dinheiro suficiente pra pagar*/
				/*inserir opÃ§Ã£o de hipotecar*/
				alvo.setDinheiro_total(-1);/*faliu*/
				this.dono.setDinheiro_total(this.dono.getDinheiro_total()+alvo_total);
                            }else {
				this.dono.setDinheiro_total(this.dono.getDinheiro_total()+deve_pagar);
				/*a linha abaixo decrescenta o dinheiro do pagante*/
				alvo.setDinheiro_total(alvo_total-deve_pagar);
                            }
                        }else{
                            int deve_pagar= (4 * num);
                            if(alvo_total<deve_pagar) {/*nÃ£o hÃ¡ dinheiro suficiente pra pagar*/
				/*inserir opÃ§Ã£o de hipotecar*/
				alvo.setDinheiro_total(-1);/*faliu*/
				this.dono.setDinheiro_total(this.dono.getDinheiro_total()+alvo_total);
                            }else {
				this.dono.setDinheiro_total(this.dono.getDinheiro_total()+deve_pagar);
				/*a linha abaixo decrescenta o dinheiro do pagante*/
				alvo.setDinheiro_total(alvo_total-deve_pagar);
                            }
                        }
                }
        }
}		
