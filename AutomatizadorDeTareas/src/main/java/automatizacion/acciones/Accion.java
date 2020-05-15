package automatizacion.acciones;

import automatizacion.observadores.IObserver;

import java.util.List;


public abstract class Accion {

	private List<IObserver> obversers;


	public void agregarObserver(IObserver observer){

	}

	public abstract void ejecutar();

	public void notificar(){

	}
}