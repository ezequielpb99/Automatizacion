package automatizacion.ejecuciones;

import automatizacion.Tarea;
import automatizacion.acciones.Accion;

public class EjecucionParalela implements EstrategiaDeEjecucion {

	public void ejecutar(Tarea tarea){
		tarea.getAcciones().parallelStream().forEach(Accion::ejecutar);
	}
}