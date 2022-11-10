package DatabaseWindows;

import java.util.Properties; 
import javax.mail.*;
import javax.mail.internet.InternetAddress; 
import javax.mail.internet.MimeMessage; 

public class SendEmail {
	
	private static String username = "WorkMailGorodkov@gmail.com";
    private static String password = "zenit513146";
    private static Properties props;
    static String emailstr;
    static String[] emails;
 
  
 
    public static void send(String subject, String text, String fromEmail){
    
           props = new Properties();
           props.put("mail.smtp.auth", "true");
           props.put("mail.smtp.starttls.enable", "true");
           props.put("mail.smtp.host", "smtp.gmail.com");
           props.put("mail.smtp.port", "587");
           
        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
        
        emailstr = DatabaseSQL.readEmailDB();
        int emailCount = emailstr.split(" ").length;
        emails = emailstr.split(" ");
        
        
        for(int i = 0; i < emailCount; i++) {
        	try {
            	Message message = new MimeMessage(session);
            	message.setFrom(new InternetAddress(username));
            	message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emails[i]));
            	message.setSubject(subject);
            	message.setText(text);
            	
            	Transport.send(message);
        	} catch (MessagingException e) {
        		throw new RuntimeException(e);
        	}
        }
    }
    
}
