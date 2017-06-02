package iftm;

public class Regras {
	// -- Numero de Cartas e Placar
	int cartasJogador[] = new int[5];
public	int placarJogador[] = new int[5];

	public void confereRegras() {
		// jogoPerfeito {
		for (int i = 0; i < 4; i++) {
			if (placarJogador[i] == 21)
				System.out.println("Jogador " + i + " Fez um jogo perfeito! e é o Vencedor");
		}
		// }
		// Overflow {
		for (int i = 0; i < 4; i++) {
			if (placarJogador[i] > 21)
				System.out.println("\nOverflow, você perdeu!\n");

		}
		// }

	}

	public String mostrarPlacar(int i) {
		return ("Jogador " + i + " : " + placarJogador[i]);

	}
	
	public int numerocartas(int i ){
		return cartasJogador[i];
	}
	
	public void aumentaNumeroDeCartas(int i){
		cartasJogador[i]++;
	}
	
}
