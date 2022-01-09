package programaFutbol;

public class Jugador {
	private String nombre;
	private int dorsal;
	private int goles;
	private int tarjetasRojas;
	private int tarjetasAmarillas;
	
	/**
	 * Pre: --- 
	 * Post: este método constructor de objetos de tipo Jugador solo recibe por 
	 * parámetro el número de dorsal, el resto de datos se obtienen de manera
	 * aleatoria con métodos de su misma clase.
	 */
	public Jugador(int dorsal) {
		generarNombre();
		this.dorsal = dorsal;
		generarGoles();
		generarTarjetas();
	}
	
	// Métodos get y set de los atributos de Jugador
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public int getDorsal() {
		return dorsal;
	}
	
	public void setDorsal(int dorsal) {
		this.dorsal = dorsal;
	}
	
	public int getGoles () {
		return goles;
	}
	
	public void setGoles (int goles) {
		this.goles = goles;
	}
	
	public int getTarjetasRojas () {
		return tarjetasRojas;
	}
	
	public void setTarjetasRojas (int tarjetasRojas) {
		this.tarjetasRojas = tarjetasRojas;
	}
	
	public int getTarjetasAmarillas () {
		return tarjetasAmarillas;
	}
	
	public void setTarjetasAmarillas (int tarjetasAmarillas) {
		this.tarjetasAmarillas = tarjetasAmarillas;
	}
	
	/**
	 * Pre: ---
	 * Post: Este método asigna nombres aleatorios a cada uno de los jugadores que se creen.
	 * Lo hace seleccionando de manera aleatoria un nombre y un apellido de cada una de las
	 * tablas.
	 */
	public void generarNombre() {
		String nombres [] = {"Ana", "Julia", "María", "Luisa", "Nerea", "Carla", "Alejandra",
				"Marta", "Cristina", "Andrea", "Sandra", "Alicia", "Sonia", "Lucía", "Inés"};
		String apellidos [] = {"García", "López", "Rodríguez", "Pérez", "Sánchez", "Martínez",
				"Hernández", "Gomez", "Garrido", "Aragón", "Santos", "Galvez", "Barranco",
				"Cruz", "Serrano"};
		/*
		 * El programa obtiene dos números aleatorios entre 0 y 14 (la longitud de las tablas
		 * de nombres y apellidos y se les asigna un nombre y un apellido a cada jugador.
		 */
		 int numeroNombre = (int) Math.round(Math.random() * 14);
		 int numeroApellido = (int) Math.round(Math.random() * 14);
		 nombre = nombres[numeroNombre] + " " + apellidos[numeroApellido];
	}
	
	/**
	 * Pre: ---
	 * Post: Este método asigna a cada jugador un número aleatorio de goles, siendo el máximo
	 * posible 100.
	 */
	public void generarGoles() {
		this.goles = (int) Math.round(Math.random()*100);
	}
	
	/**
	 * Pre: ---
	 * Post: Este método asigna a cada jugador de manera aleatoria su número de tarjetas rojas 
	 * (5 como máximo) y amarillas (10 como máximo).
	 */
	public void generarTarjetas() {
		this.tarjetasRojas = (int) Math.round(Math.random()*5);
		this.tarjetasAmarillas = (int) Math.round(Math.random()*10);
	}
	
	/**
	 * Pre: ---
	 * Post: Este método sirve para mostrar por pantalla todos los datos de los atributos
	 * de un objeto de tipo Jugador. 
	 */
	public void mostrarJugador() {
		System.out.print("    Nombre: " + nombre + "\n    Dorsal: " + dorsal + "\n    Goles: " + goles
				+ "\n    Tarjetas rojas: " + tarjetasRojas + "\n    Tarjetas amarillas: " + 
				tarjetasAmarillas + "\n\n");
	}
 }
