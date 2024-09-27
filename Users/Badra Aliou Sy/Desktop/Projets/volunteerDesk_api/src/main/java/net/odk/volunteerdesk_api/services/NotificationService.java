package net.odk.volunteerdesk_api.services;

import net.odk.volunteerdesk_api.models.Message;
import net.odk.volunteerdesk_api.models.Notification;
import net.odk.volunteerdesk_api.repositories.MessageRepository;
import net.odk.volunteerdesk_api.repositories.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    public List<Notification> findAll(){return notificationRepository.findAll();}

    public Optional<Notification> findById(Long id) {
        return notificationRepository.findById(id);
    }

    public Notification save(Notification notification) {
        return notificationRepository.save(notification);
    }

    public void deleteById(Long id) {
        notificationRepository.deleteById(id);
    }
}
