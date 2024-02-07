package exament3;

import java.util.Random;

/***
 * Clase donde se creara las funciones para el juego parchis
 */
public class Parchis {
	/***
	 * Constante donde guarda el tamaño del tablero
	 */
	public static final int TAM_TABLERO = 10;

	/***
	 * Variable entera que guarda un numero
	 */
	//public
	public static int dado1;

	/***
	 * Variable entera que guarda un numero
	 */
	public static int dado2;

	/***
	 * Variable entera que guarda la posicion del jugador1
	 */
	public int fichaJ1;

	/***
	 * Variable entera que guarda la posicion del jugador2
	 */
	public int fichaJ2;

	/***
	 * Cadena que guarda el nombre del jugador 1
	 */
	public String nomJ1 = "";

	/***
	 * Cadena que guarda el nombre del jugador 2
	 */
	public String nomJ2 = "";

	/***
	 * Constructor sin parametros
	 */
	public Parchis() {
		super();
	}

	/***
	 * Constructor con parametros
	 * 
	 * @param nomJ1 Cadena que guarda el nombre del jugador 1
	 * @param nomJ2 Cadena que guarda el nombre del jugador 2
	 */
	public Parchis(String nomJ1, String nomJ2) {
		super();
		this.nomJ1 = nomJ1;
		this.nomJ2 = nomJ2;
	}

	/***
	 * Funcion estatica que le da valores aleatorios del 1 al 6 a las variable
	 * enteras dado1 y dado2
	 */
	public static void tiraDados() {
		Random rand = new Random();
		dado1 = rand.nextInt(1, 7);
		dado2 = rand.nextInt(1, 7);
	}

	/***
	 * Funcion que pinta el tablero y los jugadores segun su tamaño con la constante
	 * TAM_TABLERO
	 */
	public void pintaTablero() {
		System.out.print("\tI");
		for (int i = 1; i < TAM_TABLERO; i++) {
			System.out.print("\t" + i);
		}
		System.out.println("\tF");

		System.out.print(nomJ1 + "\tI");

		for (int i = 1; i < TAM_TABLERO; i++) {
			if (i == fichaJ1) {
				System.out.print("\tO");
			} else {
				System.out.print("\t");
			}
		}

		System.out.println("\tF");

		System.out.print(nomJ2 + "\tI");

		for (int i = 1; i < TAM_TABLERO; i++) {
			if (i == fichaJ2) {
				System.out.print("\tO");
			} else {
				System.out.print("\t");
			}
		}
		System.out.println("\tF\n");

	}

	/***
	 * Funcion que mueve al jugador en el tablero creado segun los dados que le ha
	 * tocado
	 * 
	 * @param jugador Numero entero que indica el jugador 1 o 2
	 */
	public void avanzaPosiciones(int jugador) {
		int tirada = dado1 + dado2;

		if (jugador == 1) {
			fichaJ1 += tirada;

			if (fichaJ1 > TAM_TABLERO) {
				fichaJ1 = TAM_TABLERO - (fichaJ1 - TAM_TABLERO);
			}
		} else if (jugador == 2) {
			fichaJ2 += tirada;

			if (fichaJ2 > TAM_TABLERO) {
				fichaJ2 = 2 * TAM_TABLERO - fichaJ2;
			}
		}
	}

	/***
	 * Funcion que imprime si jugador1 o jugador2 va ganando o si van empatados
	 */
	public void estadoCarrera() {
		if (fichaJ1 > fichaJ2) {
			System.out.println("Va ganando " + nomJ1);
		} else if (fichaJ1 < fichaJ2) {
			System.out.println("Va ganando " + nomJ2);
		} else {
			System.out.println("Van empatados");
		}
		System.out.println();
	}

	/***
	 * Funcion que imprime el nombre del jugador que ha ganado
	 * 
	 * @return Nombre del jugador o cadena vacia
	 */
	public String esGanador() {

		if (fichaJ1 == TAM_TABLERO) {
			return nomJ1;
		} else if (fichaJ2 == TAM_TABLERO) {
			return nomJ2;
		} else {
			return "";
		}

	}

}
