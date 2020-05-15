package automatizacion;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class AdapterTwilio implements AdapterWhatsappSender {

	public static final String ACCOUNT_SID = "AC2fd36ad0dd9c54e41c04cd46aef6da08";
	public static final String AUTH_TOKEN = "48e12ce674cb66f32dc62ef8df19a570";

	public void enviarWhatsapp(WhatsApp whatsapp){
		Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
		Message message = Message.creator(
				new com.twilio.type.PhoneNumber("whatsapp:" + whatsapp.destinatario),
				new com.twilio.type.PhoneNumber("whatsapp:" + whatsapp.remitente),
				whatsapp.texto)
				.create();

		System.out.println(message.getSid());
	}
}