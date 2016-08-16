package com.highrise.exam.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.highrise.exam.web.dao.ContactDao;
import com.highrise.exam.web.dao.TagDao;
import com.highrise.exam.web.domain.Person;
import com.highrise.exam.web.domain.Tag;
import com.highrise.exam.web.dto.Contact;
import com.highrise.exam.web.model.TagSearchResponse;
import com.highrise.exam.web.service.PersonService;
import com.highrise.exam.web.service.TagService;

@Controller
public class GenericController {
	
	@Autowired
	private PersonService personService;

	@Autowired
	private TagService tagService;
	
	@Autowired
	private TagDao tagDao;
	
	@Autowired
	private ContactDao contactDao;

	@RequestMapping("/")
	public String executeHome(Model model) {
		String name = "N/A; Please check property file";
		try {
			name = personService.getCurrentUser().getName();
		} catch (Exception ex) {
			// do nothing;
		}
		model.addAttribute("name", name);
		// returns the view name

		// contactService.getAllContacts(new Long(4848046));

		return "home";
	}

	@RequestMapping(value="/search/{tagname}", method= RequestMethod.GET)
	public @ResponseBody TagSearchResponse search(@PathVariable String tagname, Model model) {
		
		TagSearchResponse response = new TagSearchResponse();
		
		response.setResponse("No entry found");

		List<Tag> tagList = tagService.getAllTags();
		List<com.highrise.exam.web.dto.Tag> tagDtoList = new ArrayList<>();
		
		if(!tagList.isEmpty()){
			
			for(Tag tag: tagList){
				
				if(tag.getName().equalsIgnoreCase(tagname)){
					
					response.setResponse("Tag/s found and are saved to the database");
					
					com.highrise.exam.web.dto.Tag tagDto = new com.highrise.exam.web.dto.Tag();
					tagDto.setId(tag.getId());
					tagDto.setName(tag.getName());					
					
					List<Contact> contactDtoList = getContactsUsingTagId(tagDto);					
					
					contactDao.create(contactDtoList);
					
					tagDto.setContacts(contactDtoList);
					
					tagDao.create(tagDto);
					
					tagDtoList.add(tagDto);
					
				}
			}
		}
		
		response.setTags(tagDtoList);
		
		return response;	
		
	}
	
	private List<com.highrise.exam.web.dto.Contact> getContactsUsingTagId(com.highrise.exam.web.dto.Tag tagDto){
		List<com.highrise.exam.web.dto.Contact> contactDtoList = new ArrayList<>();
		
		List<Person> people = personService.getPersons(tagDto.getId());		
		
		if(!people.isEmpty()){
			com.highrise.exam.web.dto.Contact contactDto;
			
			for (Person person : people) {
				
				contactDto = new com.highrise.exam.web.dto.Contact();
				
				contactDto.setId(person.getId());
				contactDto.setFullName(person.getFirstName() + " " + person.getLastName());
				//Get only first item from the List of PhoneNumbers
				try{
					contactDto.setPhoneNumber(person.getContactData().getPhoneNumbers().get(0).getNumber());
				}
				catch(Exception e){
					//do nothing
				}
				
				contactDtoList.add(contactDto);
				
			}
		}

		return contactDtoList;
		
	}
	
	@RequestMapping(value="/display", method= RequestMethod.GET)
	public ModelAndView displayTags(){
		ModelAndView modelAndView = new ModelAndView("display");
		
		List<com.highrise.exam.web.dto.Tag> tagDtoList = tagDao.findAll();
		
		modelAndView.addObject("tagItems", tagDtoList);
		
		return modelAndView;
		
		
	}
	

}
