package app.utility;

import app.domain.ActionAdventure;
import app.domain.AdventureReservation;
import app.dto.ReservationCheckDTO;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Properties;

public class Utility {



    public static void sendMail(String email, String messageSubject, String messageBody){
        /*String to = "pswtestmail@gmail.com";
        String from = "pswtestmail@gmail.com";
        String pass = "pswtestmail567";
        String host = "smtp.gmail.com";

        Properties properties = System.getProperties();

        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.user", from);
        properties.put("mail.smtp.password", pass);
        properties.put("mail.smtp.port", "567");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        properties.put("mail.debug", "true");

        Session session = Session.getDefaultInstance(properties,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(from,pass);
                    }
                });
        try
        {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject(messageSubject);
            message.setContent("<h1>" + messageBody + "</h1>", "text/html");
            Transport transport = session.getTransport("smtp");
            transport.connect(host, from, pass);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
            System.out.println("Sent message successfully....");
        }
        catch (MessagingException mex){ mex.printStackTrace(); }*/
    }

    public static boolean reservationTermValid(ReservationCheckDTO dto){
        for(AdventureReservation reservation: dto.getAdventureReservationList()){
            if((dto.getStartTime().isAfter(reservation.getStartTime()) && dto.getStartTime().isBefore(reservation.getEndTime()))
                    || (dto.getEndTime().isAfter(reservation.getStartTime()) && dto.getEndTime().isBefore(reservation.getEndTime())))
                return false;
        }

        for(ActionAdventure action: dto.getActionAdventureList()){
            if((dto.getStartTime().isAfter(action.getStartTime()) && dto.getStartTime().isBefore(action.getEndTime()))
                    || (dto.getEndTime().isAfter(action.getStartTime()) && dto.getEndTime().isBefore(action.getEndTime())))
                return false;
        }

        return true;
    }
}
