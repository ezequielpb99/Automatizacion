package automatizacion.observadores;

import automatizacion.Tarea;

public class TracerTarea extends Tracer {

	@Override
	public void serNotificadoPor(IObservable observable) {
		Tarea tarea = (Tarea) observable;
	}
}