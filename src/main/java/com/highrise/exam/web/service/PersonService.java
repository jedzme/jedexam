package com.highrise.exam.web.service;

import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;
import org.springframework.stereotype.Service;

import com.highrise.exam.web.domain.People;
import com.highrise.exam.web.domain.Person;
import com.highrise.exam.web.domain.User;

@Service
public class PersonService extends BaseService {

	private static final String ME_URL = "me.xml";
	
	private static final String ALL_CONTACTS_URI = "people.xml";
	
	public PersonService(){
		
	}

	/*
	 * Gets the current user's information
	 * @return User
	 */
	public User getCurrentUser(){
		User user = new User();
		Client client = ClientBuilder.newClient();
		Response response = client.target(this.getHostname()).path(ME_URL).
				request(MediaType.APPLICATION_XML).header(this.getAUTHORIZATION_STRING(), this.getAuthentication()).get();

		Serializer serializer = new Persister();
		Reader reader = new StringReader(response.readEntity(String.class));
		
		try {
			user = serializer.read(User.class, reader, false);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return user;
	}
	
	/*
	 * Gets Persons using Tag ID
	 * @param tagId The ID of the Tag
	 * @return List of Person
	 */
	public List<Person> getPersons(Long tagId) {
		
		List<Person> contacts = new ArrayList<Person>();
		Client client = ClientBuilder.newClient();

		Response response = client.target(this.getHostname()).path(ALL_CONTACTS_URI).queryParam("tag_id", tagId)
				.request(MediaType.APPLICATION_XML).header(this.getAUTHORIZATION_STRING(), this.getAuthentication()).get();

		Serializer serializer = new Persister();
		Reader reader = new StringReader(response.readEntity(String.class));

		try {
			
			contacts = serializer.read(People.class, reader, false).getPersons();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return contacts;
	}
	
	

}
