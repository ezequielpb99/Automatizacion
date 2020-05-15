package automatizacion.acciones;

import automatizacion.AdapterTwilio;
import automatizacion.AdapterWhatsappSender;
import automatizacion.WhatsApp;

import java.util.WeakHashMap;

public class EnviarWhatsapp extends Accion {

	private AdapterWhatsappSender adapter;
	private WhatsApp whatsapp;

	public EnviarWhatsapp(WhatsApp whatsApp){
		this.adapter = new AdapterTwilio();
		this.whatsapp = whatsApp;
	}

	public void ejecutar(){
		this.adapter.enviarWhatsapp(whatsapp);
	}
}