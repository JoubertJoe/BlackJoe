package baralho;

import java.util.ArrayList;
import java.util.Collections;

import javax.swing.Popup;;

public class Baralho {

	ArrayList<Carta> cartas = new ArrayList<Carta>();
	Carta ouro1, ouro2, ouro3, ouro4, ouro5, ouro6, ouro7, ouro8, ouro9, ouro10, ouro11, ouro12, ouro13, pau1, pau2,
			pau3, pau4, pau5, pau6, pau7, pau8, pau9, pau10, pau11, pau12, pau13, espada1, espada2, espada3, espada4,
			espada5, espada6, espada7, espada8, espada9, espada10, espada11, espada12, espada13, copa1, copa2, copa3,
			copa4, copa5, copa6, copa7, copa8, copa9, copa10, copa11, copa12, copa13;

	public void criaCartas() {

		// --- ouros
		ouro1 = new Carta(1, "img/baralho/OuroA.png", 'o');
		ouro2 = new Carta(2, "img/baralho/Ouro2.png", 'o');
		ouro3 = new Carta(3, "img/baralho/Ouro3.png", 'o');
		ouro4 = new Carta(4, "img/baralho/Ouro4.png", 'o');
		ouro5 = new Carta(5, "img/baralho/Ouro5.png", 'o');
		ouro6 = new Carta(6, "img/baralho/Ouro6.png", 'o');
		ouro7 = new Carta(7, "img/baralho/Ouro7.png", 'o');
		ouro8 = new Carta(8, "img/baralho/Ouro8.png", 'o');
		ouro9 = new Carta(9, "img/baralho/Ouro9.png", 'o');
		ouro10 = new Carta(10, "img/baralho/Ouro10.png", 'o');
		ouro11 = new Carta(10, "img/baralho/OuroJ.png", 'o');
		ouro12 = new Carta(10, "img/baralho/OuroQ.png", 'o');
		ouro13 = new Carta(10, "img/baralho/OuroK.png", 'o');
		// --- copas
		copa1 = new Carta(1, "img/baralho/CopaA.png", 'c');
		copa2 = new Carta(2, "img/baralho/Copa2.png", 'c');
		copa3 = new Carta(3, "img/baralho/Copa3.png", 'c');
		copa4 = new Carta(4, "img/baralho/Copa4.png", 'c');
		copa5 = new Carta(5, "img/baralho/Copa5.png", 'c');
		copa6 = new Carta(6, "img/baralho/Copa6.png", 'c');
		copa7 = new Carta(7, "img/baralho/Copa7.png", 'c');
		copa8 = new Carta(8, "img/baralho/Copa8.png", 'c');
		copa9 = new Carta(9, "img/baralho/Copa9.png", 'c');
		copa10 = new Carta(10, "img/baralho/Copa10.png", 'c');
		copa11 = new Carta(10, "img/baralho/CopaJ.png", 'c');
		copa12 = new Carta(10, "img/baralho/CopaQ.png", 'c');
		copa13 = new Carta(10, "img/baralho/CopaK.png", 'c');
		// --- paus
		pau1 = new Carta(1, "img/baralho/PausA.png", 'p');
		pau2 = new Carta(2, "img/baralho/Paus2.png", 'p');
		pau3 = new Carta(3, "img/baralho/Paus3.png", 'p');
		pau4 = new Carta(4, "img/baralho/Paus4.png", 'p');
		pau5 = new Carta(5, "img/baralho/Paus5.png", 'p');
		pau6 = new Carta(6, "img/baralho/Paus6.png", 'p');
		pau7 = new Carta(7, "img/baralho/Paus7.png", 'p');
		pau8 = new Carta(8, "img/baralho/Paus8.png", 'p');
		pau9 = new Carta(9, "img/baralho/Paus9.png", 'p');
		pau10 = new Carta(10, "img/baralho/Paus10.png", 'p');
		pau11 = new Carta(10, "img/baralho/PausJ.png", 'p');
		pau12 = new Carta(10, "img/baralho/PausQ.png", 'p');
		pau13 = new Carta(10, "img/baralho/PausK.png", 'p');
		// --- Espadas
		espada1 = new Carta(1, "img/baralho/EspadaA.png", 'e');
		espada2 = new Carta(2, "img/baralho/Espada2.png", 'e');
		espada3 = new Carta(3, "img/baralho/Espada3.png", 'e');
		espada4 = new Carta(4, "img/baralho/Espada4.png", 'e');
		espada5 = new Carta(5, "img/baralho/Espada5.png", 'e');
		espada6 = new Carta(6, "img/baralho/Espada6.png", 'e');
		espada7 = new Carta(7, "img/baralho/Espada7.png", 'e');
		espada8 = new Carta(8, "img/baralho/Espada8.png", 'e');
		espada9 = new Carta(9, "img/baralho/Espada9.png", 'e');
		espada10 = new Carta(10, "img/baralho/Espada10.png", 'e');
		espada11 = new Carta(10, "img/baralho/EspadaJ.png", 'e');
		espada12 = new Carta(10, "img/baralho/EspadaQ.png", 'e');
		espada13 = new Carta(10, "img/baralho/EspadaK.png", 'e');
	}

	public void preencheBaralho() {

		cartas.add(espada1);
		cartas.add(espada2);
		cartas.add(espada3);
		cartas.add(espada4);
		cartas.add(espada5);
		cartas.add(espada6);
		cartas.add(espada7);
		cartas.add(espada8);
		cartas.add(espada9);
		cartas.add(espada10);
		cartas.add(espada11);
		cartas.add(espada12);
		cartas.add(espada13);

		cartas.add(copa1);
		cartas.add(copa2);
		cartas.add(copa3);
		cartas.add(copa4);
		cartas.add(copa5);
		cartas.add(copa6);
		cartas.add(copa7);
		cartas.add(copa8);
		cartas.add(copa9);
		cartas.add(copa10);
		cartas.add(copa11);
		cartas.add(copa12);
		cartas.add(copa13);

		cartas.add(pau1);
		cartas.add(pau2);
		cartas.add(pau3);
		cartas.add(pau4);
		cartas.add(pau5);
		cartas.add(pau6);
		cartas.add(pau7);
		cartas.add(pau8);
		cartas.add(pau9);
		cartas.add(pau10);
		cartas.add(pau11);
		cartas.add(pau12);
		cartas.add(pau13);

		cartas.add(ouro1);
		cartas.add(ouro2);
		cartas.add(ouro3);
		cartas.add(ouro4);
		cartas.add(ouro5);
		cartas.add(ouro6);
		cartas.add(ouro7);
		cartas.add(ouro8);
		cartas.add(ouro9);
		cartas.add(ouro10);
		cartas.add(ouro11);
		cartas.add(ouro12);
		cartas.add(ouro13);
	}

	public void embaralha() {
		Collections.shuffle(cartas);
	}

	public void compra() {
		cartas.remove(0);
	}

	public void imprime() {
		for (int i = 0; i < cartas.size(); i++) {
			System.out.print(cartas.get(i).naipe + "-");
			System.out.print(cartas.get(i).valor + "\n");
			System.out.print(cartas.get(i).imagemDaCarta + "\n");
		}
	}
	
	public String getImagem(){
		return cartas.get(0).imagemDaCarta;
	}
	
	public int getValor(){
		return cartas.get(0).valor;
	}
	public int getValorCarta(int i){
		return cartas.get(i).valor;
	}
public int catasRestantes(){
		return cartas.size();
	}
}
