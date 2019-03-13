package carrentalcompany.demo.repository;

import carrentalcompany.demo.model.ContactMessage;

public interface EmailSender {
    void sendEmail(ContactMessage contactMessage);
}
