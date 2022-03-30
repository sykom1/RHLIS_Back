package com.amu.project_back.repository;


import com.amu.project_back.models.Notification;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
	
	List<Notification> findByDestinataireIdOrderByIdDesc(Long id);
	
	List<Notification> findByVuFalseAndDestinataireId(Long id);
}
