package net.odk.volunteerdesk_api.repositories;

import net.odk.volunteerdesk_api.models.Notification;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {
}
