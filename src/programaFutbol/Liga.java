package programaFutbol;

public class Liga {
	private String nombre;
	private Equipo[] clasificacion = new Equipo[15];
	
	/**
	 * Pre: ---
	 * Post: Este método construye un objeto de tipo Liga sin necesidad de recibir nada por 
	 * parámetro. El nombre se da por defecto y los equipos y jugadores que la conforman 
	 * se generan de manera aleatoria.
	 */
	public Liga () {
		this.nombre = "La liga de Nerea";
		generarClasificacion();
	}
	
	// Métodos get y set de los atributos de Liga
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public Equipo[] getClasificacion() {
		return clasificacion;
	}
	
	public void setClasificacion(Equipo[] clasificacion) {
		this.clasificacion = clasificacion;
	}
	
	/**
	 * Pre: --- 
	 * Post: este método genera una tabla de quince objetos de tipo Equipo
	 * pasando como parámetro el nombre del equipo, el estadio y el año de
	 * fundación. El resto de datos del equipo se generan de forma aleatoria
	 * dentro de la clase Equipo.
	 */
	public void generarClasificacion() {
		String nombres [] = {"Alavés", "Athletic", "Atlético", "Barcelona", "Betis",
				"Cádiz", "Celta", "Elche", "Espanyol", "Getafe", "Granada", "Levante",
				"Mallorca", "Osasuna", "Real Madrid"};
		String estadios [] = {"Mendizorroza","San Mamés", "Wanda Metropolitano",
				"Camp Nou", "Benito Villamarín", "Nuevo Mirandilla", "Abanca-Balaídos",
				"Martínez Valero", "RCDE Stadium", "Coliseum Alfonso Pérez",
				"Nuevo Los Cármenes", "Ciutat de València", "Visit Mallorca Estadi",
				"El Sadar", "Santiago Bernabéu"};
		int anosFundacion[] = {1921, 1898, 1903, 1899, 1907, 1910, 1923, 1923, 1900, 
				1983, 1931, 1909, 1916, 1920, 1902};
		for (int i = 0; i < 15; i++) {
			clasificacion[i] = new Equipo (nombres[i], estadios[i], anosFundacion[i]);
		}	
	}
	
	/**
	 * Pre: ---
	 * Post: Este método muestra ordenados los equipos según su puntuación obtenida
	 * en la liga (de mayor a menor).
	 */
	public void mostrarClasificacion() {
		// Estos bucles anidados se encargan de ordenar los equipos según sus puntos
		for (int i = 0; i < clasificacion.length; i++) { 
			Equipo auxiliar;
			for (int j = 0; j < clasificacion.length - 1; j++) {
				if (clasificacion[j].getPuntos() < clasificacion[i].getPuntos()) {
					auxiliar = clasificacion[i];
					clasificacion[i] = clasificacion[j];
					clasificacion[j] = auxiliar;			
				}
			}
		}
		// Este bucle muestra por pantalla el nombre del equipo y su puntuación total
		for (int i = 0; i < clasificacion.length; i++) {
			System.out.println(clasificacion[i].getNombre() + " con " + 
					clasificacion[i].getPuntos() + " puntos.");
		}
		System.out.println();
	}
	
	/**
	 * Pre: ---
	 * Post: Este método muestra los cinco jugadores que más goles han marcado.
	 * Para ello se introducen todos los jugadores en un array de 165 huecos
	 * (15 equipos por 11 jugadores) y se van comparando sus numeros de goles.
	 */
	public void mostrarMaximosGoleadores() {
		Jugador todosJugadores[] = new Jugador[165];
		int contador = 0;
		/*
		 * Estos bucles se encargan de meter todos los jugadores en una sola tabla
		 * llamada todosJugadores[].
		 */
		for (int i = 0; i < clasificacion.length; i++) {
			for (int j = 0; j < clasificacion[i].getJugadores().length; j++) {
				todosJugadores[contador] = clasificacion[i].getJugadores()[j];
				contador++;
			}
		}
		/*
		 * Estos bucles anidados se encargan de ordenar los jugadores dentro de 
		 * esa tabla de mayor a menor según el número de goles marcados.
		 */
		for (int i = 0; i < todosJugadores.length; i++) { 
			Jugador auxiliar;
			for (int j = 0; j < todosJugadores.length - 1; j++) {
				if (todosJugadores[j].getGoles() < todosJugadores[i].getGoles()) {
					auxiliar = todosJugadores[i];
					todosJugadores[i] = todosJugadores[j];
					todosJugadores[j] = auxiliar;			
				}
			}
		}
		/*
		 * Este bucle imprime por pantalla los nombres de los cinco jugadores con
		 * más goles y su número de goles totales.
		 */
		for (int i = 0; i < 5; i++) {
			System.out.println(todosJugadores[i].getNombre() + " con un total de " 
					+ todosJugadores[i].getGoles() + " goles.");
		}
		System.out.println();
	}
	
	/**
	 * Pre: ---
	 * Post: Este método muestra por pantalla los tres jugadores con más expulsiones
	 * junto a su número de tarjetas rojas, tarjetas amarillas y el número de 
	 * expulsiones totales.
	 */
	public void mostrarMaximosExpulsados() {
		Jugador todosJugadores[] = new Jugador[165];
		int contador = 0;
		/*
		 * Estos bucles se encargan de meter todos los jugadores en una sola tabla
		 * llamada todosJugadores[].
		 */
		for (int i = 0; i < clasificacion.length; i++) {
			for (int j = 0; j < clasificacion[i].getJugadores().length; j++) {
				todosJugadores[contador] = clasificacion[i].getJugadores()[j];
				contador++;
			}
		}
		/*
		 * Estos bucles ordenan los jugadores de mayor a menor número de expulsiones.
		 * Las tarjetas rojas cuentan como una expulsión y cada dos tarjetas amarillas
		 * también se cuenta como una expulsión.
		 */
		for (int i = 0; i < todosJugadores.length; i++) { 
			Jugador auxiliar;
			for (int j = 0; j < todosJugadores.length - 1; j++) {
				if ((todosJugadores[j].getTarjetasRojas() + 
						todosJugadores[j].getTarjetasAmarillas() / 2) 
							< (todosJugadores[i].getTarjetasRojas() + 
								todosJugadores[i].getTarjetasAmarillas() / 2)) {
					auxiliar = todosJugadores[i];
					todosJugadores[i] = todosJugadores[j];
					todosJugadores[j] = auxiliar;			
				}
			}
		}
		/*
		 * Este bucle muestra por pantalla los tres jugadores con más expulsiones mostrando
		 * el número de tarjetas rojas y amarillas y el número de expulsiones totales.
		 */
		for (int i = 0; i < 3; i++) {
			System.out.println(todosJugadores[i].getNombre() + " con " + 
					todosJugadores[i].getTarjetasRojas() + " tarjetas rojas y " + 
					todosJugadores[i].getTarjetasAmarillas() + " tarjetas amarillas"
					+ " que hacen un total de " + (todosJugadores[i].getTarjetasRojas() + 
					(todosJugadores[i].getTarjetasAmarillas() / 2)) + " expulsiones.");
		}
		System.out.println();
	}
	
	/**
	 * Pre: ---
	 * Post: Este método calcula cuáles han sido los tres equipos de la liga que más
	 * goles han marcado. Para ello se crea una tabla de 15 posiciones donde se van
	 * almacenando los goles totales de cada equipo.
	 */
	public void mostrarEquiposGoleadores() {
		int golesEquipo [] = new int [15];
		/*
		 * Estos bucles anidados se encargan de sumar los goles totales de cada Equipo.
		 */
		for (int i = 0; i < clasificacion.length; i++) {
			int golesTotales = 0;
			for (int j = 0; j < clasificacion[i].getJugadores().length; j++) {
				golesTotales += clasificacion[i].getJugadores()[j].getGoles();
			}
			golesEquipo[i] = golesTotales;
		}
		/*
		 * Estos bucles anidados ordenan de mayor a menor el número de goles de cada equipo
		 * y a la vez el nombre de dicho equipo.
		 */
		for (int i = 0; i < golesEquipo.length; i++) {
			int auxiliar = 0;
			Equipo auxiliarEquipo;
			for (int j = 0; j < golesEquipo.length - 1; j++) {
				if (golesEquipo[j] < golesEquipo[i]) {
					auxiliar = golesEquipo[i];
					golesEquipo[i] = golesEquipo[j];
					golesEquipo[j] = auxiliar;
					// Aquí se ordenan los equipos a la vez
					auxiliarEquipo = clasificacion[i];
					clasificacion[i] = clasificacion[j];
					clasificacion[j] = auxiliarEquipo;			
				}
			}
		}
		/*
		 * Este bucle muestra por pantalla el nombre de los tres equipos más goleadores junto
		 * al número total de goles. 
		 */
		for (int i = 0; i < 3; i++) {
			System.out.println(clasificacion[i].getNombre() + " con un total de " + golesEquipo[i]
					+ " goles.");
		}
		System.out.println();
	}
	
	/**
	 * Pre: ---
	 * Post: Este método sirve para mostrar por pantalla todos los datos de un objeto de 
	 * tipo Liga. 
	 */
	public void mostrarLiga() {
		System.out.println("Nombre de la liga: " + nombre + "\n");
		/*
		 * Este bucle recorre la tabla donde están generados los equipos y los muestra
		 * por pantalla.
		 */
		for (int i = 0; i < clasificacion.length; i++) {
			clasificacion[i].mostrarEquipo();
		}
		System.out.println();
	}
}
