package app.utility;

import app.domain.ActionAdventure;
import app.domain.AdventureReservation;
import app.dto.ReservationCheckDTO;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.*;
import java.util.Properties;

public class Utility {

    private static String email = "";
    private static String resouurcesAbsolutePath = "C:\\Users\\Mirko\\Documents\\GitHub\\ISA-PROJECT\\demo\\src\\main\\resources\\systemSallary.json";

    public static void sendMail(String emaill, String messageSubject, String messageBody) throws MessagingException, UnsupportedEncodingException {

        email = emaill;

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                email = "pswtestmail@gmail.com";

                Properties properties = new Properties();
                properties.put("mail.smtp.host", "smtp.gmail.com");
                properties.put("mail.smtp.port", 587);
                properties.put("mail.smtp.auth", "true");
                properties.put("mail.smtp.starttls.enable", "true");
                properties.put("mail.smtp.user", email);


                Session session = Session.getDefaultInstance(properties);
                Message msg = new MimeMessage(session);

                try {
                    msg.setFrom(new InternetAddress(email));
                } catch (MessagingException e) {
                    e.printStackTrace();
                }
                InternetAddress[] toAddresses = new InternetAddress[0];
                try {
                    toAddresses = new InternetAddress[]{ new InternetAddress(email) };
                } catch (AddressException e) {
                    e.printStackTrace();
                }
                try {
                    msg.setRecipients(Message.RecipientType.TO, toAddresses);
                } catch (MessagingException e) {
                    e.printStackTrace();
                }
                try {
                    msg.setSubject(messageSubject);
                } catch (MessagingException e) {
                    e.printStackTrace();
                }
                // set plain text message
                try {
                    msg.setText(messageBody);
                } catch (MessagingException e) {
                    e.printStackTrace();
                }

                Transport t = null;
                try {
                    t = session.getTransport("smtp");
                } catch (NoSuchProviderException e) {
                    e.printStackTrace();
                }
                try {
                    t.connect(email, "pswtestmail567");
                } catch (MessagingException e) {
                    e.printStackTrace();
                }
                try {
                    t.sendMessage(msg, msg.getAllRecipients());
                } catch (MessagingException e) {
                    e.printStackTrace();
                }
                try {
                    t.close();
                } catch (MessagingException e) {
                    e.printStackTrace();
                }
            }
        });

        thread.start();



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

    public static void saveSystemSallary(double sallaryPercentage){
        JSONObject obj = new JSONObject();
        obj.put("sallaryPercentage", sallaryPercentage / 100);

        try (FileWriter file = new FileWriter(resouurcesAbsolutePath)) {
            file.write(obj.toJSONString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static double getSystemSallary() {
        JSONParser parser = new JSONParser();

        try (Reader reader = new FileReader(resouurcesAbsolutePath)) {

            JSONObject jsonObject = (JSONObject) parser.parse(reader);

            Double systemSallary = (Double) jsonObject.get("sallaryPercentage");

            return systemSallary;

        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return 0;
    }
}
