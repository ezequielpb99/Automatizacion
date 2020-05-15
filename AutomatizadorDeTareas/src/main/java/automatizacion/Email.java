package automatizacion;

public class Email {

	public String destinatario;
	public String remitente;
	public String texto;
	public String asunto;

	public Email(String destinatario, String remitente, String texto, String asunto){
		this.destinatario = destinatario;
		this.remitente = remitente;
		this.texto = texto;
		this.asunto = asunto;
	}

}