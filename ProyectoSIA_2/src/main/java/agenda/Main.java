/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package agenda;

/**
 *
 * @author manu
 */
public class Main {
    public static void main(String[] args) {
        // Configura la cuenta de correo con tus datos
        String servidorSmtp = "smtp.gmail.com";
        String puertoSmtp = "587";
        String correoRemitente = "agendaprograavanz@gmail.com";
        String contraseña = "holn dvph wksv ohrt "; // Usa tu contraseña real o de aplicación menos segura

        EnviarMail mailSender;
        mailSender = new EnviarMail(servidorSmtp, puertoSmtp, correoRemitente, contraseña);

        String destinatario = "manuel.aguilera.e@mail.pucv.cl";
        String asunto = "Test";
        String mensajeCorreo = "# Funciona correctamente?\nojala sí";

        // Envia el correo
        mailSender.enviarMail(destinatario, asunto, mensajeCorreo);
    }
}
