package carrentalcompany.demo.service;


import carrentalcompany.demo.model.ContactMessage;
import carrentalcompany.demo.repository.EmailSender;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class EmailSenderService implements EmailSender{

    private JavaMailSender javaMailSender;

    public EmailSenderService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @Override
    public void sendEmail(ContactMessage contactMessage) {

        MimeMessage mail = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(mail, true);
            helper.setTo("konradkuczynski1@gmail.com");
            helper.setReplyTo("konradkuczynski1@gmail.com");
            helper.setFrom("newsletter@codecouple.pl");
            helper.setSubject("Car Rental Form");
            helper.setText(contactMessage.getNameSurname() + "\n" + contactMessage.getEmail() + "\n" + contactMessage.getPhoneNumber() + "\n" + contactMessage.getMessage());
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        javaMailSender.send(mail);

    }
}
