package programaFutbol;

import java.util.Scanner;

public class Main {
	/**
	 * Pre: --- 
	 * Post: Este método main ejecuta un programa que genera una liga de
	 * fútbol con sus correspodientes datos de equipos y jugadores para después
	 * poder obtener ciertas estadísticas.
	 */
	public static void main(String[] args) throws InterruptedException {
		Liga liga = new Liga();
		System.out.println("¡Bienvenido al programa del Club de Socios!");
		int menu;
		while (true) {
			mostrarMenu();
			try {
				Scanner entrada = new Scanner(System.in);
				menu = entrada.nextInt();
				if (menu == 1) {
					liga.mostrarClasificacion();
				} else if (menu == 2) {
					liga.mostrarMaximosGoleadores();
				} else if (menu == 3) {
					liga.mostrarMaximosExpulsados();
				} else if (menu == 4) {
					liga.mostrarEquiposGoleadores();
				} else if (menu == 5) {
					liga.mostrarLiga();
				} else if (menu == 6) {
					System.out.println("Apagando el programa...");
					break;
				} else {
					System.out.println("Por favor, introduce un número correcto.\n");
					/*
					 * En caso de no introducir un dato válido, el programa muestra un mensaje de
					 * advertencia y espera unos segundos para volver a lanzar el menú de nuevo,
					 * para que el usuario tenga tiempo de leer la advertencia.
					 */
				}
			} catch (Exception e) {
				System.out.println("Introduce un dato valido, ¡por favor!");
				/*
				 * El catch se encarga de mostrar un mensaje de avertencia si el dato introducido 
				 * no es valido, por ejemplo es de tipo String.
				 */
			}
			Thread.sleep(3000);
		}
	}

	/**
	 * Pre: --- 
	 * Post: Este método muestra por pantalla el menú del programa e indica
	 * los números que deben pulsarse según la acción que se quiera realizar.
	 */
	public static void mostrarMenu() {
		System.out.println("\n" +"¿Qué operación desea realizar?\n" +
				           "1. Visualizar la clasificación ordenada por puntos (pulse 1)\n" +
				           "2. Visualizar los 5 máximos goleadores (pulse 2)\n" + 
				           "3. Visualizar los 5 jugadores con más expulsiones (pulse 3)\n" +
				           "4. Obtener los 3 equipos más goleadores (pulse 4)\n" +
				           "5. Obtener los datos de la liga (pulse 5)\n" + 
				           "6. Apagar el programa. (pulse 6)\n" 
		);
	}
}
