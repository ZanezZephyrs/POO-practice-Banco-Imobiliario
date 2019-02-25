package mecanica;
import slots.*;
import entidade.Jogador;
import entidade.principal;
import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;



public class Motor {
	private int n_jogadores;
	private Slot[] tabuleiro;
	private ArrayList<Jogador> jogadores;
	
	@SuppressWarnings("resource")
	public Motor(int num_players) {
		Scanner scan=new Scanner(System.in);
		Jogador player;
		String nome;
		this.jogadores=new ArrayList<Jogador>();
		this.n_jogadores=num_players;
		for(int i=1;i<n_jogadores+1;i++) {
			System.out.printf("Insira o nome do jogador %d:", i);
			nome=scan.nextLine();
			player=new Jogador(nome, i, 0);
			this.jogadores.add(player);
			
			
		}
	}
	
	public ArrayList<Jogador> getJogadores(){
		return this.jogadores;
	}

	
	public void Realiza_jogo() {
		int id_atual=0;
		int num_jogada=0;
		int aux;
		String resp;
		Scanner scan=new Scanner(System.in);
		while(this.jogadores.size()>1) {
			if(id_atual>n_jogadores-1) {
				id_atual=0;
			}
			System.out.printf("----------------------------------------------------------\n");
			System.out.printf("Jogada de %s\n", this.jogadores.get(id_atual).getNome());
			System.out.println("Oque gostaria de fazer? [jogar] [status]");
			System.out.printf("escreva a opção:");
			resp=scan.nextLine();
			
			if(resp.equalsIgnoreCase("status")) {
				mostra_status(this.jogadores.get(id_atual));
				continue;
				
			}else if(resp.equalsIgnoreCase("Jogar")) {
				Jogada(this.jogadores.get(id_atual));
				
			}else if(resp.equalsIgnoreCase("tabuleiro")) {
				imprimi_tabuleiro();
			}else if(resp.equalsIgnoreCase("test")) {
				aux=Integer.parseInt(scan.nextLine());
				
				mover_jogador(this.jogadores.get(id_atual), aux);
			}else {
				System.out.println("Opção invalida!");
				continue;
			}
			
			id_atual++;
			num_jogada++;
		}
		System.out.printf("FIM DE JOGO\n %s é o vencedor, Parabens!!", this.jogadores.get(0).getNome());
	}
	
	public void mostra_status(Jogador player) {
		Propriedade aux;
		int mult;
		System.out.printf("A situação de %s é:\n", player.getNome());
		System.out.printf("Situado na posição %d – %s\n", player.getPos(), this.tabuleiro[player.getPos()].GetNome());
		System.out.printf("Possui $%d\n", player.getDinheiro_total());
		System.out.println("Títulos:");
		try {
			for(Slot iterator:player.getPosses()) {
				if(iterator instanceof Propriedade) {
					aux=(Propriedade) iterator;
					System.out.printf("[%s] –  Propriedade, aluguel %d\n",iterator.GetNome(),aux.GetAluguel()[aux.GetN_Casas()]);
				}else if(iterator instanceof Roads) {
					System.out.printf("[%s] - Ferrovia, corrida %d", iterator.GetNome(), player.getN_rodovias()*25);
				}else if(iterator instanceof Servico) {
					if(player.getN_servicos()==2) {
						mult=10;
					}else {
						mult=4;
					}
					System.out.printf("[%s] - Serviço, multiplicador ", iterator.GetNome(), mult);
				}
		}
		
		}catch(Exception e){
			return;	
		}
	}
	
	public void Jogada(Jogador player) {
		/*numeros iguais?
		 * preso?*/
		 
		int dados[]=lanca_dados();
		int mover=dados[0]+dados[1]+player.getPos();
		System.out.printf("O resultado dos dados foi %d, %d\n", dados[0],dados[1]);
		if(mover>39) {
			mover_jogador(player, mover-40);
		}else {
			mover_jogador(player,mover);
		}
	}
	
	public int[] lanca_dados() {
		Random rand=new Random();
		int dado1=rand.nextInt(6)+1;
		int dado2=rand.nextInt(6)+1;
		int dados[]= {dado1,dado2};
		return dados;
	}
	
	
	public void mover_jogador(Jogador player, int dest) {
		if(dest<player.getPos()) {/*passou pelo meio*/
			player.setDinheiro_total(player.getDinheiro_total()+200);
			System.out.printf("Jogador %s completou uma volta no tabuleiro e recebeu $200!!\n", player.getNome());
		}
		player.setPos(dest);
		System.out.printf("Jogador parou em %d-%s\n", this.tabuleiro[player.getPos()].GetID(), this.tabuleiro[player.getPos()].GetNome());
		this.tabuleiro[dest].executar(player, this);
	}
	
	public void cria_tabuleiro1(principal Banco) {
		this.tabuleiro=new Slot[40];
		/*construtor propriedade(id, vetor de valores, nome, casas, dono, compra, hipoteca, cor, total_do_conjunto, custo casa)*/
		tabuleiro[0]=new Inicio(0, "Inicio");
		tabuleiro[1]=new Propriedade(1,cria_vetor(2,10,30,90,160,250),"Mediterranean Avenue",0,Banco,60,30,"Roxo",2,50);
		tabuleiro[2]=new Sorte(2, "Sorte");
		tabuleiro[3]=new Propriedade(3,cria_vetor(4,20,60,180,320,450),"Baltic Avenue", 0, Banco, 60, 30,"Roxo", 2,50);
		tabuleiro[4]=new Imposto(4,"Income Tax", 200);
		tabuleiro[5]=new Roads(5,"Reading Railroad", Banco,200);
		tabuleiro[6]=new Propriedade(6,cria_vetor(6,30,90,270,400,550),"Oriental Avenue", 0, Banco, 100, 50, "Azul Claro", 3,50);
		tabuleiro[7]=new Sorte(7, "Sorte");
		tabuleiro[8]=new Propriedade(8,cria_vetor(6,30,90,270,400,550),"Vermont Avenue", 0, Banco, 100,50, "Azul Claro", 3,50);
		tabuleiro[9]=new Propriedade(9,cria_vetor(8,40,100,300,450,600),"Connecticut Avenue", 0, Banco, 120,60, "Azul Claro", 3,50);
		tabuleiro[10]=new Slot(10, "Prisão");
		tabuleiro[11]=new Propriedade(11,cria_vetor(10,50,150,450,625,750),"St. Charles Place", 0, Banco, 140,70, "Rosa", 3,100);
		tabuleiro[12]=new Servico(12, "Electric Company", Banco, 150);
		tabuleiro[13]=new Propriedade(13,cria_vetor(10,50,150,450,625,750),"States Avenue", 0, Banco, 140,70, "Rosa", 3,100);
		tabuleiro[14]=new Propriedade(14,cria_vetor(12,60,180,500,700,900),"Virginia Avenue", 0, Banco, 160,80, "Rosa", 3,100);
		tabuleiro[15]=new Roads(15,"Pennsylvania Railroad", Banco,200);
		tabuleiro[16]=new Propriedade(16,cria_vetor(14,70,200,550,750,950),"St. James Place", 0, Banco, 180,90, "Laranja", 3,100);
		tabuleiro[17]=new Sorte(17, "Sorte");
		tabuleiro[18]=new Propriedade(18,cria_vetor(14,70,200,550,750,950),"Tennessee Avenue", 0, Banco, 180,90, "Laranja", 3,100);
		tabuleiro[19]=new Propriedade(19,cria_vetor(16,80,220,600,800,1000),"New York Avenue", 0, Banco, 200,100, "Laranja", 3,100);
		tabuleiro[20]=new Slot(20, "Free Parking");
		tabuleiro[21]=new Propriedade(21,cria_vetor(18,90,250,700,875,1050),"Kentucky Avenue", 0, Banco, 220,110, "Vermelho", 3,150);
		tabuleiro[22]=new Sorte(22, "Sorte");
		tabuleiro[23]=new Propriedade(23,cria_vetor(18,90,250,700,875,1050),"Indiana Avenue", 0, Banco, 220,110, "Vermelho", 3,150);
		tabuleiro[24]=new Propriedade(24,cria_vetor(20,100,300,750,925,1100),"Illinois Avenue", 0, Banco, 240,120, "Vermelho", 3,150);
		tabuleiro[25]=new Roads(25,"B & O Railroad", Banco,200);
		tabuleiro[26]=new Propriedade(26,cria_vetor(22,110,330,800,975,1150),"Atlantic Avenue", 0, Banco, 260,130,"Amarelo", 3,150);
		tabuleiro[27]=new Propriedade(27,cria_vetor(22,110,330,800,975,1150),"Ventnor Avenue", 0, Banco, 260,130,"Amarelo", 3,150);
		tabuleiro[28]=new Servico(28, "Water Works", Banco, 150);
		tabuleiro[29]=new Propriedade(29,cria_vetor(24,120,360,850,1025,1200),"Marvin Gardens", 0, Banco, 280,140,"Amarelo", 3,150);
		tabuleiro[30]=new Slot(30, "Prisão");
		tabuleiro[31]=new Propriedade(31,cria_vetor(26,130,390,900,1100,1275),"Pacific Avenue", 0, Banco, 300,150,"Verde", 3,200);
		tabuleiro[32]=new Propriedade(32,cria_vetor(26,130,390,900,1100,1275),"North Carolina Avenue", 0, Banco, 300,150,"Verde", 3,200);
		tabuleiro[33]=new Sorte(33, "Sorte");
		tabuleiro[34]=new Propriedade(34,cria_vetor(28,150,450,1000,1200,1400),"Pennsylvania Avenue", 0, Banco, 320,160,"Verde", 3,200);
		tabuleiro[35]=new Roads(35,"Short Line Railroad", Banco,200);
		tabuleiro[36]=new Sorte(36, "Sorte");
		tabuleiro[37]=new Propriedade(37,cria_vetor(35,175,500,1100,1300,1500),"Park Place", 0, Banco, 350,175, "Azul escuro", 2,200);
		tabuleiro[38]=new Imposto(38,"Luxury Tax",75);
		tabuleiro[39]=new Propriedade(39,cria_vetor(50,200,600,1400,1700,2000),"Boardwalk", 0, Banco, 400,200,"Azul escuro", 2,200);
		
	}
	
	public void imprimi_tabuleiro() {
		int i;
		for(i=0;i<tabuleiro.length;i++) {
			System.out.print(tabuleiro[i].toString());
			System.out.println("-----------------------------");
		}
	}
	
	public boolean pode_comprar_casa(ArrayList<Slot> posses, String cor, int total_conjunto) {
		int total_contado=0;
		for(Slot aux:posses) {
			if(aux instanceof Propriedade) {
				if(((Propriedade) aux).getCor().equals(cor)) {
					total_contado++;
				}
			}
		}
		if(total_contado==total_conjunto) {
			return true;
		}else {
			return false;
		}
		
	}
	
	public int[] cria_vetor(int um, int dos, int tres, int quat, int cin, int seis) {
		int vetor[]=new int[6];
		vetor[0]=um;
		vetor[1]=dos;
		vetor[2]=tres;
		vetor[3]=quat;
		vetor[4]=cin;
		vetor[5]=seis;
		return vetor;
	}
}
