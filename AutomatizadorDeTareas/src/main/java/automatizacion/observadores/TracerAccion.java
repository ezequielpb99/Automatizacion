package automatizacion.observadores;


import automatizacion.acciones.Accion;

public class TracerAccion extends Tracer {

	@Override
	public void serNotificadoPor(IObservable observable) {
		Accion accion = (Accion) observable;
	}
}