package video_steganography;



import java.io.File;
import java.io.IOException;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
public class SendMail
{



 public  void send(String body,String subject,String to,File f) throws IOException        
 {
//Get the session object
  Properties props = new Properties();
  props.put("mail.smtp.host", "smtp.gmail.com");
  props.put("mail.smtp.socketFactory.port", "465");
  props.put("mail.smtp.socketFactory.class",
        	"javax.net.ssl.SSLSocketFactory");
  props.put("mail.smtp.auth", "true");
  props.put("mail.smtp.port", "465");

   Session session = Session.getDefaultInstance(props,
   new javax.mail.Authenticator()
   	{
   protected PasswordAuthentication getPasswordAuthentication()
   {
   return new PasswordAuthentication("vishalkhaveer.innovatus@gmail.com","kqhc oicx ider haum");//change accordingly
   }
  });
//compose message abhishekchaudar0001@gmail.com
  try
  {
   MimeMessage message = new MimeMessage(session);
   message.setFrom(new InternetAddress("vishalkhaveer.innovatus@gmail.com"));//change accordingly   // mail from
   message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
   message.setSubject(subject);
  // message.setText(body);
   
   MimeBodyPart part1=new MimeBodyPart();
    part1.setText(body);
    
     MimeBodyPart part2=new MimeBodyPart();
     part2.attachFile(f);
     
     MimeMultipart mulpart=new MimeMultipart();
     mulpart.addBodyPart(part1);
     mulpart.addBodyPart(part2);
     
     message.setContent(mulpart);

   //send message
   Transport.send(message);

   System.out.println("message sent successfully");
  }
  catch (MessagingException e)
  {
      throw new RuntimeException(e);
  }

 }
}