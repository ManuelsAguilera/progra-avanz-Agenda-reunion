/**
 * Clase para enviar correos electrónicos utilizando el protocolo SMTP.
 * Esta clase permite configurar un servidor SMTP, puerto, correo remitente
 * y contraseña para enviar correos electrónicos a destinatarios especificados.
 * Utiliza la librería JavaMail API.
 *
 * @author manu
 */
package agenda.correo;

import agenda.logic.*;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EnviarMail {
    // Atributos de la clase

    /**
     * Servidor SMTP para enviar correos electrónicos.
     */
    private String servidorSmtp;

    /**
     * Puerto del servidor SMTP.
     */
    private String puertoSmtp;

    /**
     * Correo remitente que se utilizará para enviar los correos.
     */
    private String correoRemitente;

    /**
     * Contraseña del correo remitente (cifrada, si se utiliza el método cifrarContraseña).
     */
    private String contraseña;

    /**
     * Constructor por defecto que inicializa con valores predeterminados.
     */
    public EnviarMail()
    {
        this.servidorSmtp = "smtp.gmail.com"; // Inicializado automáticamente.
        this.puertoSmtp = "587";
        this.correoRemitente = "agendaprograavanz@gmail.com";
        this.contraseña = "holn dvph wksv ohrt ";
    }

    /**
     * Constructor que permite personalizar la configuración del servidor SMTP y correo remitente.
     * La contraseña se cifra automáticamente (si se utiliza el método cifrarContraseña).
     *
     * @param servidorSmtp Servidor SMTP para enviar correos.
     * @param puertoSmtp Puerto del servidor SMTP.
     * @param correoRemitente Correo remitente.
     * @param contraseña Contraseña del correo remitente (se recomienda cifrar).
     */
    public EnviarMail(String servidorSmtp, String puertoSmtp, String correoRemitente, String contraseña) {
        this.servidorSmtp = servidorSmtp;
        this.puertoSmtp = puertoSmtp;
        this.correoRemitente = correoRemitente;
        this.contraseña = cifrarContraseña(contraseña);
    }

    /**
     * Envía un correo electrónico al destinatario especificado con el asunto y mensaje dados.
     *
     * @param destinatario Dirección de correo del destinatario.
     * @param asunto Asunto del correo.
     * @param mensajeCorreo Cuerpo del correo.
     */
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
    public void enviarMail(String destinatario, String asunto, String mensajeCorreo,boolean html) {
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
            if (html)
                message.setContent(mensajeCorreo,"text/html; charset=utf-8");
            
            Transport.send(message);

            System.out.println("Correo enviado con éxito.");
        } catch (MessagingException e) {
            e.printStackTrace();
            System.out.println("Error al enviar el correo: " + e.getMessage());
        }
    }


    /**
     * Método para cifrar la contraseña del correo remitente (puede personalizarse).
     *
     * @param contraseña Contraseña a cifrar.
     * @return Contraseña cifrada (implementación personalizada).
     */
    private String cifrarContraseña(String contraseña) {
        return contraseña;
    }
    
    public boolean enviarMeeting(String destinatario,Meeting data, String fecha) {
    if (data != null) {
        String asunto = "Reunión: " + data.getNombre(); // Asunto formateado
        String hora = formatearHora(data.getHora()); // Hora formateada
        
        String descripcionHtml = data.getDescripcion().replace("\n", "<br>"); //descripcion formateada
        // Utiliza HTML para formatear el contenido del correo
        String contenido = "<html><body>";
        contenido += "<h2>Usted tiene una reunión agendada:</h2>";
        contenido += "<p><strong>Fecha:</strong> " + fecha + "</p>";
        contenido += "<p><strong>Hora:</strong> " + hora + "</p>";
        contenido += "<p><strong>Título:</strong> " + data.getNombre() + "</p>";
        contenido += "<p><strong>Descripción:</strong> " + descripcionHtml+ "</p>";
        contenido += "<p>Adiós.</p>";
        contenido += "</body></html>";

        enviarMail(destinatario, asunto, contenido,true); // Reemplaza con la dirección del destinatario

        return true;
    }
    return false;
}

    private String formatearHora(int hora) {
        // Convierte la hora en un formato xx:yy
        String horaStr = String.valueOf(hora);
        if (horaStr.length() == 3) {
            horaStr = "0" + horaStr; // Añade un 0 al principio si la hora es de un solo dígito
        }
        return horaStr.substring(0, 2) + ":" + horaStr.substring(2, 4);
    }

}
