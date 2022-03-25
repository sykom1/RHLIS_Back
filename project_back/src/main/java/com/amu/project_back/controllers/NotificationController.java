package com.amu.project_back.controllers;

import com.amu.project_back.models.AnnuaireEquipe;
import com.amu.project_back.models.Notification;
import com.amu.project_back.models.Utilisateur;
import com.amu.project_back.repository.AnnuaireEquipeRepository;
import com.amu.project_back.repository.NotificationRepository;
import com.amu.project_back.repository.UserRepository;
import com.amu.project_back.services.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@RestController
@RequestMapping("/api")
public class NotificationController {

    @Autowired
    AnnuaireEquipeRepository annuaireEquipeRepository;

    @Autowired
    NotificationService notificationService;

    @Autowired
    NotificationRepository notificationRepository;

    @Autowired
    UserRepository repo;

    @Scheduled(fixedRate = 86400000)
    public void scheduleTaskWithFixedRate() {

        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, 30);
        Date inMonth = new Date(cal.getTimeInMillis());

        List<AnnuaireEquipe> dates = annuaireEquipeRepository.findAllByDateSortie(inMonth);

        ArrayList<Utilisateur> users = new ArrayList<>();
        for(AnnuaireEquipe date : dates){
            users.add(date.getAnnuaire().getUser());
        }
        notificationService.notifyAllSAFList(users);
        notificationService.notifyAllRefList(users);

    }

    @GetMapping("/users/{id}/notifs")
    public List<Notification> getUserNotifs(@PathVariable Long id){
        return repo.getById(id).getNotifications();

    }

    @GetMapping("/notif/{id}")
    public ResponseEntity<?> setVu(@PathVariable Long id){
        Notification notification = notificationRepository.getById(id);
        notification.setVu(true);
        notification = notificationRepository.save(notification);
        return ResponseEntity.ok(notification);
    }

}
