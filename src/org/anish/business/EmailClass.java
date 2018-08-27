package org.anish.business;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.Properties;
import javax.mail.Session;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.Base64Data;
import com.sun.xml.internal.messaging.saaj.packaging.mime.MessagingException;
import com.sun.xml.internal.ws.api.message.Message;

public class EmailClass {
	 /**
     * Create a MimeMessage using the parameters provided.
     *
     * @param to email address of the receiver
     * @param from email address of the sender, the mailbox account
     * @param subject subject of the email
     * @param bodyText body text of the email
     * @return the MimeMessage to be used to send email
     * @throws MessagingException
	 * @throws javax.mail.MessagingException 
	 * @throws AddressException 
     */
    public static MimeMessage createEmail(String to,
                                          String from,
                                          String subject,
                                          String bodyText)
            throws MessagingException, AddressException, javax.mail.MessagingException {
        Properties props = new Properties();
        Session session = Session.getDefaultInstance(props, null);

        MimeMessage email = new MimeMessage(session);

        email.setFrom(new InternetAddress(from));
        email.addRecipient(javax.mail.Message.RecipientType.TO,
                new InternetAddress(to));
        email.setSubject(subject);
        email.setText(bodyText);
        return email;
    }

}
