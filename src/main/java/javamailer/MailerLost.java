package javamailer;

import application.Main;

import java.util.Properties;


import java.util.Random;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.*;

public class MailerLost {
    private String email;

    Random random = new Random();
    private int value = random.nextInt(10000,99999);

    public MailerLost(String email){
        this.email = email;
    }
    public void main() {


        // Configuration des propriétés du serveur de courrier sortant
        Properties properties = System.getProperties();
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.user", "egm.lprs@gmail.com");
        properties.put("mail.smtp.password", "3gM!LpR5");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");

        // Obtention d'une session de messagerie
        Session session = Session.getDefaultInstance(properties);

        try {
            // Création d'un nouveau message
            MimeMessage message = new MimeMessage(session);

            // Définition de l'expéditeur et du destinataire
            message.setFrom(new InternetAddress("egm.lprs@gmail.com"));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(this.email));
            System.out.println(this.email);

            // Définition du sujet et du corps du message
            message.setSubject("Code vérification");
            message.setText("Ceci est un mail automatique \n Vous avez demandé une réinitialisation de votre mot de passe \n \n Voici le code automatique : " + value);

            // Envoi du message
            Transport transport = session.getTransport("smtp");
            transport.connect("smtp.gmail.com", "egm.lprs@gmail.com", "wnbfizfitxonnpkm");
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
            System.out.println("Ceci est un mail automatique \n Vous avez demandé une réinitialisation de votre mot de passe \n \n Voici le code automatique : " + value);
        } catch (AddressException ae) {
            ae.printStackTrace();
        } catch (MessagingException me) {
            me.printStackTrace();
        }
    }

    public int getValue() {
        return value;
    }
}
