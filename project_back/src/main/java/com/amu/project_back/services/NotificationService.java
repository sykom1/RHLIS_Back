package com.amu.project_back.services;

import com.amu.project_back.models.Notification;
import com.amu.project_back.models.Utilisateur;
import com.amu.project_back.models.enume.UserRole;
import com.amu.project_back.repository.NotificationRepository;
import com.amu.project_back.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    @Autowired
    NotificationRepository notificationRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    EmailServiceImpl emailService;

    public void notifyAllSAF(String nouvelEntrant, String ref){
        for(Utilisateur saf : userRepository.findAllByRoleLike(UserRole.SERVICE_ADMINISTRATIF_FINANCIER)){
            Notification notification = new Notification();
            notification.setDestinataire(saf);
            notification.setObjet("Nouvel entrant");
            notification.setMessage("<p> Le nouvel entrant " + nouvelEntrant +  " vient d'être ajouté par "+ ref +" <p>" );
            notification.setVu(false);
            emailService.sendSimpleMessage(notification);
            notificationRepository.save(notification);
        }


    }
}
