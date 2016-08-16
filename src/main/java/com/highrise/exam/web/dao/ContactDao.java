package com.highrise.exam.web.dao;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.highrise.exam.web.entity.Contact;
import com.highrise.exam.web.repository.ContactRepository;

@Repository
public class ContactDao {
	
	@Autowired
	private ContactRepository contactRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Transactional
	public void create(com.highrise.exam.web.dto.Contact contactDto){
		contactRepository.save(convertToEntity(contactDto));
	}
	
	@Transactional
	public void create(List<com.highrise.exam.web.dto.Contact> contactDtoList){
		
		List<Contact> contactEntityListToSave = new ArrayList<>();
		
		for(com.highrise.exam.web.dto.Contact contactDto : contactDtoList){
			contactEntityListToSave.add(convertToEntity(contactDto));
			
		}
		
		contactRepository.save(contactEntityListToSave);

	}
	
	@Transactional
	public List<com.highrise.exam.web.dto.Contact> findAll(){
		
		List<com.highrise.exam.web.dto.Contact> contactDtos = new ArrayList<>();
		
		List<Contact> contactEntities = contactRepository.findAll();
		
		for(Contact contactEntity : contactEntities){
			contactDtos.add(convertToDto(contactEntity));
		}
		
		return contactDtos;
		
	}
	
	@Transactional
	public com.highrise.exam.web.dto.Contact findOne(Long contactId){
		return convertToDto(contactRepository.findOne(contactId));
		
	}
	
	private com.highrise.exam.web.dto.Contact convertToDto(Contact contactEntity){
		com.highrise.exam.web.dto.Contact contactDto = modelMapper.map(contactEntity, com.highrise.exam.web.dto.Contact.class);
		
		return contactDto;
	}
	
	private Contact convertToEntity(com.highrise.exam.web.dto.Contact contactDto){
		Contact contactEntity = modelMapper.map(contactDto, Contact.class);
		
		return contactEntity;
	}

}
