/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.xpresstek.zroster.web.util;

import java.util.Date;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import net.xpresstek.zroster.ejb.Configuration;
import net.xpresstek.zroster.web.ConfigurationController;
import net.xpresstek.zroster.web.ControllerFactory;

/**
 *
 * @author alex
 */
public class MailUtil {

    protected static void sendEmail(String to,
            String from,
            String host,
            final String user,
            final String password,
            String subject,
            String body) throws MessagingException {

        Properties props = new Properties();
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.socketFactory.port", "587");
        props.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "587");

        props.put("mail.smtp.connectiontimeout", "10000");
        props.put("mail.smtp.timeout", "10000");

        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(user, password);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(to));
            message.setSubject(subject);
            message.setText(body);

            Transport.send(message);
        } catch (MessagingException ex) {
            throw ex;
        }
    }

    protected static String getConfigProperty(String id) {
        ConfigurationController cont =
                ControllerFactory.getConfigurationController();

        Configuration conf =
                (Configuration) cont.getConfiguration(id);
        return conf.getConfigValue();
    }

    public static boolean sendNewTimeOffRequestEmail(String name,
            Date start,
            Date end) {
        boolean retval = false;

        String body = "New pending time off request \n"
                + "From: " + name + "\n"
                + "From: " + start.toString() + "\n"
                + "To: " + end.toString();

        String subject = "New time off request";

        try {
            sendEmail(getConfigProperty("EmailTo"),
                    getConfigProperty("EmailFrom"),
                    getConfigProperty("EmailServer"),
                    getConfigProperty("EmailUser"),
                    getConfigProperty("EmailPassword"),
                    subject,
                    body);
            retval = true;
        } catch (Exception e) {
            retval = false;
        }

        return retval;


    }
}
