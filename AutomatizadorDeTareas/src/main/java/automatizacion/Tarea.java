package automatizacion;

import automatizacion.acciones.Accion;
import automatizacion.ejecuciones.EstrategiaDeEjecucion;
import automatizacion.observadores.IObservable;
import automatizacion.observadores.IObserver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author julyh
 * @version 1.0
 * @created 07-may.-2020 15:42:21
 */
public class Tarea implements IObservable {

	private List<Accion> acciones;
	private String descripcion;
	private Estado estado;
	private EstrategiaDeEjecucion estrategiaDeEjecucion;
	private int intervaloDeEjecucion;
	private String nombre;
	private List<IObserver> observers;

	public Tarea(EstrategiaDeEjecucion estrategiaDeEjecucion){
		this.estrategiaDeEjecucion = estrategiaDeEjecucion;
		this.acciones = new ArrayList<Accion>();
		this.observers = new ArrayList<>();
		this.estado = Estado.INICIADA;
	}

	public List<Accion> getAcciones() {
		return acciones;
	}

	public void ejecutar(){
		cambiarEstadoYNotificar(Estado.EN_EJECUCION);
	    this.estrategiaDeEjecucion.ejecutar(this);
	    cambiarEstadoYNotificar(Estado.FINALIZADA);
	}

    public void cambiarEstadoYNotificar(Estado estado){
        this.estado = estado;
        notificar();
    }

	public void agregarAccion(Accion ... acciones){
		Collections.addAll(this.acciones, acciones);
	}

	public void cambiarEstrategiaDeEjecucion(EstrategiaDeEjecucion estrategia){

	}

	public void notificar(){
        this.observers.forEach(o -> o.serNotificadoPor(this));
	}

    @Override
    public void agregarObservable(IObserver... observers) {
        Collections.addAll(this.observers, observers);
    }

    @Override
    public void eleminarObservable(IObserver observer) {
        this.observers.remove(observer);
    }
}
