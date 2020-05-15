package automatizacion.acciones;

import automatizacion.AdapterEmailSender;
import automatizacion.Email;

public class EnviarEmail extends Accion {

	private AdapterEmailSender adapter;
	private Email email;


	public void ejecutar(){
		this.adapter.enviarMail(this.email);
	}
}