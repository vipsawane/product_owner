package net.odk.volunteerdesk_api.services;

import net.odk.volunteerdesk_api.models.StatutMessage;
import net.odk.volunteerdesk_api.repositories.StatutMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class StatutMessageService {

    @Autowired
    private StatutMessageRepository statutMessageRepository;

    public List<StatutMessage> findAll(){return statutMessageRepository.findAll();}

   

    public StatutMessage save(StatutMessage statutMessage) {
        return statutMessageRepository.save(statutMessage);
    }

    public void deleteById(Long id) {
        statutMessageRepository.deleteById(id);
    }
}
