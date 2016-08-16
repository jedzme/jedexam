package com.highrise.exam.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.highrise.exam.web.entity.Contact;


public interface ContactRepository extends JpaRepository<Contact, Long>{

}
