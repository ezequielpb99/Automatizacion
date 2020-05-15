package automatizacion.ejecuciones;

import automatizacion.Tarea;
import automatizacion.acciones.Accion;

public class EjecucionSecuencial implements EstrategiaDeEjecucion {

	public void ejecutar(Tarea tarea){
		tarea.getAcciones().forEach(Accion::ejecutar);
	}
}