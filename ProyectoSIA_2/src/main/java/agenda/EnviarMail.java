/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package agenda;

/**
 *
 * @author manu
 */
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EnviarMail {
    private String servidorSmtp;
    private String puertoSmtp;
    private String correoRemitente;
    private String contraseña;

    public EnviarMail(String servidorSmtp, String puertoSmtp, String correoRemitente, String contraseña) {
        this.servidorSmtp = servidorSmtp;
        this.puertoSmtp = puertoSmtp;
        this.correoRemitente = correoRemitente;
        this.contraseña = cifrarContraseña(contraseña);
    }

    public void enviarMail(String destinatario, String asunto, String mensajeCorreo) {
        Properties properties = new Properties();
        properties.put("mail.smtp.host", servidorSmtp);
        properties.put("mail.smtp.port", puertoSmtp);
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true"); // Habilita STARTTLS

        Session session = Session.getInstance(properties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(correoRemitente, contraseña);
            }
        });

        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(correoRemitente));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinatario));
            message.setSubject(asunto);
            message.setText(mensajeCorreo);

            Transport.send(message);

            System.out.println("Correo enviado con éxito.");
        } catch (MessagingException e) {
            e.printStackTrace();
            System.out.println("Error al enviar el correo: " + e.getMessage());
        }
    }

    private String cifrarContraseña(String contraseña) {
        return contraseña;
    }
}
