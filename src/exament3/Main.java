package exament3;

import java.util.Scanner;

/***
 * Clase main donde se va a ejecutar el programa
 */
public class Main {

	/***
	 * Metodo main donde permite ejecutar el programa
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner leer = new Scanner(System.in);
		Parchis parchis;
		String nomJ1, nomJ2;
		String ganador = "";
		int turno = 1;

		System.out.println("BIENVENIDO AL PARCH͍S DEL IES NERVI�N =D");

		System.out.println("Introduzca el nombre del jugador 1");
		nomJ1 = leer.nextLine();

		do {
			System.out.println("Introduzca el nombre del jugador 2. Tiene que ser distinto al del jugador 1.");
			nomJ2 = leer.nextLine();
		} while (nomJ2.equals(nomJ1));

		parchis = new Parchis(nomJ1, nomJ2);

		ganador = parchis.esGanador();
		while (ganador.equals("")) {
			System.out.println("Pulse una tecla para avanzar");
			leer.nextLine();

			turno(parchis, turno);
			if (Parchis.dado1 != Parchis.dado2) {
				turno = turno == 1 ? 2 : 1;
			}

			ganador = parchis.esGanador();
		}

		System.out.println("�ENHORABUENA " + parchis.nomJ1 + ", HAS GANADO!");

		leer.close();

	}

	/***
	 * Creamos funcion turno en el cula nos muestra que jugador le toca y los
	 * numeros que le han salido en los dados
	 * 
	 * @param parchis El objeto parchis de la clase parchis que permite sacar los
	 *                dados
	 * @param jugador Un numero entero que muestra la posicion del jugador
	 */
	public static void turno(Parchis parchis, int jugador) {

		System.out.println("Turno de " + (jugador == 1 ? parchis.nomJ1 : parchis.nomJ2));
		Parchis.tiraDados();
		System.out.println("La tirada ha sido " + Parchis.dado1 + " y " + Parchis.dado2);
		parchis.avanzaPosiciones(jugador);
		parchis.pintaTablero();
		parchis.estadoCarrera();

	}

}
