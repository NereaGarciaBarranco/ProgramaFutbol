package programaFutbol;

public class Equipo {
	private String nombre;
	private String estadio;
	private int anoFundacion;
	private Jugador[] jugadores = new Jugador[11]; //Cada equipo tiene 11 jugadores
	private int puntos;
	private int partidosGanados;
	private int partidosPerdidos;
	private int partidosEmpatados;
	
	/**
	 * Pre: ---
	 * Post: Este m�todo constructor recibe como par�metro el nombre, el estadio
	 * y el a�o de fundaci�n. El resto de datos se generan aleatoriamente con
	 * otros m�todos de la clase Equipo. 
	 */
	public Equipo(String nombre, String estadio, int anoFundacion) {
		this.nombre = nombre;
		this.estadio = estadio;
		this.anoFundacion = anoFundacion;
		generarJugadores();
		generarPartidos();
		generarPuntos();
	}
	
	// M�todos get y set de los atributos de la clase Equipo
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getEstadio() {
		return estadio;
	}
	
	public void setEstadio(String estadio) {
		this.estadio = estadio;
	}
	
	public int getFundacion() {
		return anoFundacion;
	}
	
	public void setFundacion(int anoFundacion) {
		this.anoFundacion = anoFundacion;
	}
	
	public Jugador[] getJugadores() {
		return jugadores;
	}
	
	public void setJugadores(Jugador[] jugadores) {
		this.jugadores = jugadores;
	}
	
	public int getPuntos () {
		return puntos;
	}
	
	public void setPuntos (int puntos) {
		this.puntos = puntos;
	}
	
	public int getPartidosGanados () {
		return partidosGanados;
	}
	
	public void setPartidosGanados (int partidosGanados) {
		this.partidosGanados = partidosGanados;
	}
	
	public int getPartidosPerdidos () {
		return partidosPerdidos;
	}
	
	public void setPartidosPerdidos (int partidosPerdidos) {
		this.partidosPerdidos = partidosPerdidos;
	}
	
	public int getPartidosEmpatados () {
		return partidosEmpatados;
	}
	
	public void setPartidosEmpatados (int partidosEmpatados) {
		this.partidosEmpatados = partidosEmpatados;
	}
	
	/**
	 * Pre: ---
	 * Post: Este m�todo genera 11 jugadores para cada uno de los equipos y adem�s
	 * manda por par�metro el n�mero de dorsal (se obtiene sum�ndole uno al 
	 * iterador del bucle).
	 */
	public void generarJugadores() {
		for (int i = 0; i < 11; i++) {
			jugadores[i] = new Jugador (i + 1);
		}
	}
	
	/**
	 * Pre: ---
	 * Post: Este m�todo calcula los puntos de un equipo en base a sus partidos
	 * ganados (valen por 3) y a sus partidos empatados (valen por 1).
	 */
	public void generarPuntos() {
		this.puntos = getPartidosGanados() * 3 + getPartidosEmpatados(); 
	}
	
	/**
	 * Pre: ---
	 * Post: Este m�todo genera los resultados para cada uno de los 28 partidos 
	 * que ha tenido que jugar cada uno de los equipos.
	 */
	public void generarPartidos() {
		int partidosTotales = 28; // Al ser 15 de equipos la liga se compone de 28 partidos
		this.partidosEmpatados = (int) Math.round(Math.random() * 10);
		partidosTotales = partidosTotales - partidosEmpatados;
		this.partidosGanados = (int) Math.round(Math.random() * partidosTotales);
		this.partidosPerdidos = partidosTotales - partidosGanados;
	}
	
	/**
	 * Pre: ---
	 * Post: Este m�todo sirve para mostrar por pantalla los datos de cada uno de los 
	 * objetos de tipo Equipo.
	 */
	public void mostrarEquipo() {
		System.out.println("Nombre del equipo: " + nombre + "\n" +
						   "Estadio: " + estadio + "\n" + 
						   "A�o de fundaci�n: " + anoFundacion + "\n" + 
						   "Puntos: " + puntos + "\n" + 
						   "Partidos ganados: " + partidosGanados + "\n" +
						   "Partidos perdidos: " + partidosPerdidos + "\n" + 
						   "Partidos empatados: " + partidosEmpatados + "\n");
		System.out.println("Jugadores del " + nombre + ":\n");
		/*
		 * Este bucle sirve para mostrar por pantalla cada uno de los Jugadores que
		 * tiene un equipo (est�n almacenados en una tabla).
		 */
		for (int i = 0; i < jugadores.length; i++) {
			jugadores[i].mostrarJugador();
		}
		System.out.println();
	}
}
