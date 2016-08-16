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

import com.highrise.exam.web.domain.Tag;
import com.highrise.exam.web.domain.Tags;

@Service
public class TagService extends BaseService {

	private static final String GET_TAGS_URI = "tags.xml";

	public TagService() {

	}

	public List<Tag> getAllTags() {
		List<Tag> tags = new ArrayList<Tag>();

		Client client = ClientBuilder.newClient();

		Response response = client.target(this.getHostname()).path(GET_TAGS_URI).
				request(MediaType.APPLICATION_XML).header(this.getAUTHORIZATION_STRING(), this.getAuthentication()).get();

		Serializer serializer = new Persister();
		Reader reader = new StringReader(response.readEntity(String.class));
		try {
			tags = serializer.read(Tags.class, reader, false).getTags();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return tags;
	}

}
