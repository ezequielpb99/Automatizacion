package automatizacion.acciones;

import java.io.IOException;

public class AbrirAplicacion extends Accion {

	public String nombreApp;

	public AbrirAplicacion(String nombreApp){
		this.nombreApp = nombreApp;
	}


	public void ejecutar(){
		Runtime runtime = Runtime.getRuntime();
		try
		{
			runtime.exec(nombreApp);        //opens "sample.txt" in notepad
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}