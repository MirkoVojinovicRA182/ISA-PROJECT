package app.utility;

import app.domain.ActionAdventure;
import app.domain.AdventureReservation;
import app.dto.ReservationCheckDTO;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

public class Utility {



    public static void sendMail(String email, String messageSubject, String messageBody) throws MessagingException, UnsupportedEncodingException {

        email = "pswtestmail@gmail.com";

        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", 587);
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.user", email);


        Session session = Session.getDefaultInstance(properties);
        Message msg = new MimeMessage(session);

        msg.setFrom(new InternetAddress(email));
        InternetAddress[] toAddresses = { new InternetAddress(email) };
        msg.setRecipients(Message.RecipientType.TO, toAddresses);
        msg.setSubject(messageSubject);
        // set plain text message
        msg.setText(messageBody);

        Transport t = session.getTransport("smtp");
        t.connect(email, "pswtestmail567");
        t.sendMessage(msg, msg.getAllRecipients());
        t.close();

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
