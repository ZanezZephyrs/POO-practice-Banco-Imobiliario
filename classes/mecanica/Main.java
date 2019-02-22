package mecanica;
import mecanica.Motor;
import java.util.Scanner;
import entidade.Banco;
public class Main {


	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		System.out.println("Bem vindo ao Jogo de Banco Imobiliario!!");
		System.out.printf("insira o numero de jogadores:");
		int n_jogadores=scan.nextInt();
		
		Motor motor1 =new Motor(n_jogadores);
		Banco banco1=new Banco("Banco", 0, 32, 12);
		motor1.cria_tabuleiro1(banco1);
		motor1.Realiza_jogo();
		/*motor1.imprimi_tabuleiro();*/
		
		
	}

}
