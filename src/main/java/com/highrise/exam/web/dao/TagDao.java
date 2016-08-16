package com.highrise.exam.web.dao;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.highrise.exam.web.entity.Tag;
import com.highrise.exam.web.repository.TagRepository;

@Repository
public class TagDao {
	
	@Autowired
	TagRepository tagRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Transactional
	public void create(com.highrise.exam.web.dto.Tag tagDto){
		tagRepository.save(convertToEntity(tagDto));
	}
	
	@Transactional
	public void create(List<com.highrise.exam.web.dto.Tag> tagDtoList){
		List<Tag> tagEntityList = new ArrayList<>();
		
		for(com.highrise.exam.web.dto.Tag tagDto: tagDtoList){
			tagEntityList.add(convertToEntity(tagDto));
		}
		
		tagRepository.save(tagEntityList);
	}
	
	@Transactional
	public List<com.highrise.exam.web.dto.Tag> findAll(){
		
		List<com.highrise.exam.web.dto.Tag> tagDtoList = new ArrayList<>();
		
		List<Tag> tagEntityList = tagRepository.findAll();
		
		for(Tag tagEntity : tagEntityList){
			tagDtoList.add(convertToDto(tagEntity));
		}
		
		return tagDtoList;
		
		
	}
	
	@Transactional
	public Tag find(Long tagId){
		return tagRepository.findOne(tagId);
	}
	
	private com.highrise.exam.web.dto.Tag convertToDto(Tag tagEntity){
		com.highrise.exam.web.dto.Tag tagDto = modelMapper.map(tagEntity, com.highrise.exam.web.dto.Tag.class);
		
		return tagDto;
	}
	
	private Tag convertToEntity(com.highrise.exam.web.dto.Tag tagDto){
		Tag tagEntity = modelMapper.map(tagDto, Tag.class);
		
		return tagEntity;
	}
	
	

}
