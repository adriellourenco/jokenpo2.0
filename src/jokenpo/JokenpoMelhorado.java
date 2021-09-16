package jokenpo;

import java.util.Random;
import java.util.Scanner;

public class JokenpoMelhorado {

	public static void main(String[] args) {

		int escolhaUsuario = 0;
		int escolhaMaquina = 0;
		int pontuacaoMaquina = 0;
		int pontuacaoUsuario = 0;
		int numeroMaximoPartidas = 1;
		int contador = 0;
		int empates = 0;
		int numeroDaPartida = 1;
		String respostaUsuario = "sim";

		Scanner leitor = new Scanner(System.in);
		
		while (respostaUsuario.equalsIgnoreCase("sim")) {
			
			System.out.println("----------------------------");
			System.out.println("        J O K E N P O       ");
			System.out.println("----------------------------\n");

			while (numeroMaximoPartidas < 3 || numeroMaximoPartidas % 2 == 0) {

				
				System.out.println("Qual é o Número de Partidas que você deseja jogar?\n"
						+ "*LEMBRE-SE: número de partidas TEM QUE SER MAIOR QUE 3 E SER ÍMPAR!");
				numeroMaximoPartidas = leitor.nextInt();
				System.out.println();
			}

			while (numeroMaximoPartidas > contador
					&& !(pontuacaoMaquina > (numeroMaximoPartidas - empates) / 2 || pontuacaoUsuario > (numeroMaximoPartidas - empates) / 2)) {

				while (escolhaUsuario <= 0 || escolhaUsuario > 3) {
					
					System.out.println("PARTIDA " +numeroDaPartida);
					System.out.println();
					System.out.println("Pedra - 1");
					System.out.println("Papel - 2");
					System.out.println("Tesoura - 3");

					System.out.println("Escolha uma opção: ");
					escolhaUsuario = leitor.nextInt();

					System.out.println();
					
					if (escolhaUsuario <= 0 || escolhaUsuario > 3) {
						System.out.println("Você digitou uma opção inválida! Digite novamente!");
					}
				}

				if (escolhaUsuario == 1) {
					System.out.println("Você escolheu Pedra!");
				} else if (escolhaUsuario == 2) {
					System.out.println("Você escolheu Papel!");
				} else {
					System.out.println("Você escolheu Tesoura!");
				}

				Random sorteio = new Random();
				escolhaMaquina = sorteio.nextInt(3) + 1;

				if (escolhaMaquina == 1) {
					System.out.println("A máquina escolheu Pedra!");
				} else if (escolhaMaquina == 2) {
					System.out.println("A máquina escolheu Papel!");
				} else {
					System.out.println("A máquina escolheu Tesoura!");
				}

				if (escolhaUsuario == escolhaMaquina) {
					System.out.println("Empate!\n");
					empates++;
				} else if ((escolhaUsuario == 1 && escolhaMaquina == 3) || (escolhaUsuario == 2 && escolhaMaquina == 1)
						|| (escolhaUsuario == 3 && escolhaMaquina == 2)) {
					System.out.println("Você ganhou a partida!\n");
					pontuacaoUsuario++;
				} else {
					System.out.println("Máquina ganhou a partida!\n");
					pontuacaoMaquina++;
				}
				
			contador++;
			escolhaUsuario = 0;
			numeroDaPartida++;
			}
			
			if (pontuacaoMaquina==pontuacaoUsuario) {
				
				System.out.println("**********VAMOS DESEMPATAR**********");
				System.out.println();
				
				while (pontuacaoMaquina==pontuacaoUsuario) {

					while (escolhaUsuario <= 0 || escolhaUsuario > 3) {
						
						System.out.println("Pedra - 1");
						System.out.println("Papel - 2");
						System.out.println("Tesoura - 3");

						System.out.println("Escolha uma opção: ");
						escolhaUsuario = leitor.nextInt();

						System.out.println();
						
						if (escolhaUsuario <= 0 || escolhaUsuario > 3) {
							System.out.println("Você digitou uma opção inválida! Digite novamente!");
						}
					}

					if (escolhaUsuario == 1) {
						System.out.println("Você escolheu Pedra!");
					} else if (escolhaUsuario == 2) {
						System.out.println("Você escolheu Papel!");
					} else {
						System.out.println("Você escolheu Tesoura!");
					}

					Random sorteio = new Random();
					escolhaMaquina = sorteio.nextInt(3) + 1;

					if (escolhaMaquina == 1) {
						System.out.println("A máquina escolheu Pedra!");
					} else if (escolhaMaquina == 2) {
						System.out.println("A máquina escolheu Papel!");
					} else {
						System.out.println("A máquina escolheu Tesoura!");
					}

					if (escolhaUsuario == escolhaMaquina) {
						System.out.println("Empate!\n");
					} else if ((escolhaUsuario == 1 && escolhaMaquina == 3) || (escolhaUsuario == 2 && escolhaMaquina == 1)
							|| (escolhaUsuario == 3 && escolhaMaquina == 2)) {
						System.out.println("Você ganhou a partida!\n");
						pontuacaoUsuario++;
					} else {
						System.out.println("Máquina ganhou a partida!\n");
						pontuacaoMaquina++;
					}

				escolhaUsuario = 0;
				}
			} 
			
			
			System.out.println("----------------------------");
			System.out.println("        RESULTADOS          ");
			System.out.println("----------------------------");
			System.out.println("Sua Pontuação: " +pontuacaoUsuario);
			System.out.println("Pontuação da Máquina: " +pontuacaoMaquina);
			System.out.println();
			
			if (pontuacaoUsuario > pontuacaoMaquina) {
				System.out.println("VOCÊ GANHOU O JOGO!");
			} else {
				System.out.println("MÁQUINHA GANHOU O JOGO!");
			}
			
			System.out.println();
			
			pontuacaoMaquina = 0;
			pontuacaoUsuario = 0;
			numeroMaximoPartidas = 1;
			contador = 0;
			empates = 0;
			numeroDaPartida = 1;
			
			System.out.println("Deseja jogar mais uma vez? (Sim/Não)");
			respostaUsuario = leitor.next();
			System.out.println();
			
			while (!respostaUsuario.equalsIgnoreCase("sim") && !respostaUsuario.equalsIgnoreCase("não") ) {
				System.out.println("Por favor, digite 'Não' ou 'Sim'!");
				System.out.println("Deseja jogar mais uma vez? (Sim/Não)");
				respostaUsuario = leitor.next();
			}
		}
		
		leitor.close();
		System.out.println("OBRIGADO POR JOGAR!!!");
		System.out.println();

	}

}
