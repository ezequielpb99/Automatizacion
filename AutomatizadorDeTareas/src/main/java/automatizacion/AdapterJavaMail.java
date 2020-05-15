package automatizacion;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class AdapterJavaMail implements AdapterEmailSender {


	public void enviarMail(Email email){
		//Declare recipient's & sender's e-mail id.
		String destmailid = email.destinatario;
		String sendrmailid = email.remitente;
		//Mention user name and password as per your configuration
		final String uname = "TestEmailI1248G@gmail.com";
		final String pwd = "Sie$i2g%248";
		//We are using relay.jangosmtp.net for sending emails
		String smtphost = "relay.jangosmtp.net";
		//Set properties and their values
		Properties propvls = new Properties();
		propvls.put("mail.smtp.auth", "true");
		propvls.put("mail.smtp.starttls.enable", "true");
		propvls.put("mail.smtp.host", smtphost);
		propvls.put("mail.smtp.port", "25");
		//Create a Session object & authenticate uid and pwd
		Session sessionobj = Session.getInstance(propvls,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(uname, pwd);
					}
				});

		try {
			//Create MimeMessage object & set values
			Message messageobj = new MimeMessage(sessionobj);
			messageobj.setFrom(new InternetAddress(sendrmailid));
			messageobj.setRecipients(Message.RecipientType.TO,InternetAddress.parse(destmailid));
			messageobj.setSubject(email.asunto);
			messageobj.setText(email.texto);
			//Now send the message
			Transport.send(messageobj);
			System.out.println("Your email sent successfully....");
		} catch (MessagingException exp) {
			throw new RuntimeException(exp);
		}
	}
}