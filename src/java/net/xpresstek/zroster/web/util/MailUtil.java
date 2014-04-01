/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.xpresstek.zroster.web.util;

import java.util.Date;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import net.xpresstek.zroster.ejb.ConfigurationDataManager;

/**
 *
 * @author alex
 */
public class MailUtil {

    protected static String getConfigProperty(String id) {      
        return ConfigurationDataManager.getInstance().getConfigValue(id, true);
    }

    public static void  sendNewTimeOffRequestEmail(String name,
            Date start,
            Date end) {
        String body = "New pending time off request \n"
                + "From: " + name + "\n"
                + "From: " + start.toString() + "\n"
                + "To: " + end.toString();

        String subject = "New time off request";
        
        MailRunnable mr = new MailRunnable(
                getConfigProperty("EmailServer"),
                getConfigProperty("EmailPort"),
                getConfigProperty("EmailTo"),
                getConfigProperty("EmailFrom"),                
                getConfigProperty("EmailUser"),
                getConfigProperty("EmailPassword"),
                subject,
                body);
        
        (new Thread(mr)).start();


    }

    private static class MailRunnable implements Runnable {

        String host;
        String port;
        String to;
        String from;
        String user;
        String password;
        String subject;
        String body;

        final static String TIMEOUT = "10000";

        public MailRunnable(
                String host,
                String port,
                String to,
                String from,
                String user,
                String password,
                String subject,
                String body) {
            this.host = host;
            this.port = port;
            this.to = to;
            this.from = from;
            this.user = user;
            this.password = password;
            this.subject = subject;
            this.body = body;
        }

        @Override
        public void run() {
            sendMail();
        }

        protected void sendMail() {

            Properties props = new Properties();
            props.put("mail.smtp.host", host);
            props.put("mail.smtp.socketFactory.port", port);
            props.put("mail.smtp.socketFactory.class",
                    "javax.net.ssl.SSLSocketFactory");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.port", port);

            props.put("mail.smtp.connectiontimeout", TIMEOUT);
            props.put("mail.smtp.timeout", TIMEOUT);

            Session session = Session.getInstance(props,
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
                
                Logger.getLogger(MailUtil.class.getName()).
                        log(Level.INFO, null, "Email notificaiton sent");
            } catch (MessagingException ex) {
                Logger.getLogger(MailUtil.class.getName()).
                        log(Level.SEVERE, null, ex);

            }
        }

    }

}
