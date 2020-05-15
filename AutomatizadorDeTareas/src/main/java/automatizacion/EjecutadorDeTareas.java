
package automatizacion;

import java.util.*;

public class EjecutadorDeTareas extends TimerTask {

	private int intervaloDeEjecucion;
	private List<Tarea> tareas;

	public EjecutadorDeTareas(){
		this.tareas = new ArrayList<>();
	}

	public void agregarTarea(Tarea ... tareas){
		Collections.addAll(this.tareas, tareas);
	}

	public void run(){
		this.tareas.forEach(Tarea::ejecutar);
	}
}