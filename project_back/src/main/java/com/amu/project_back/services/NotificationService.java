package com.amu.project_back.services;

import com.amu.project_back.models.Annuaire;
import com.amu.project_back.models.Notification;
import com.amu.project_back.models.Utilisateur;
import com.amu.project_back.models.enume.UserRole;
import com.amu.project_back.repository.NotificationRepository;
import com.amu.project_back.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
    public void notifyAllSAFList(List<Utilisateur> nouveauPartant) {

        StringBuilder message = new StringBuilder("<p> Les utilistaurs ");
        for(Utilisateur utilisateur : nouveauPartant){
            message.append("</br>").append(utilisateur.getFirstname()).append(" ").append(utilisateur.getLastname());
        }
        message.append("</br> nous quittent dans 1 mois </p>");

        for (Utilisateur saf : userRepository.findAllByRoleLike(UserRole.SERVICE_ADMINISTRATIF_FINANCIER)) {
            Notification notification = new Notification();
            notification.setDestinataire(saf);
            notification.setObjet("Notification de Départ");
            notification.setMessage(message.toString());
            notification.setVu(false);
            emailService.sendSimpleMessage(notification);
            notificationRepository.save(notification);
        }

    }
    public void notifyAllRefList(List<Utilisateur> nouveauPartant) {
        for(Utilisateur partant : nouveauPartant){
            Utilisateur ref = partant.getDirectory().getReferent().getUser();
            Notification notification = new Notification();
            notification.setDestinataire(ref);
            notification.setObjet("Notification de depart");
            notification.setMessage("<p> L'utilisteur' " + partant.getFirstname() +" "+ partant.getLastname() +  " nous quitte dans 1 mois <p>" );
            notification.setVu(false);
            emailService.sendSimpleMessage(notification);
            notificationRepository.save(notification);
        }
    }
}
