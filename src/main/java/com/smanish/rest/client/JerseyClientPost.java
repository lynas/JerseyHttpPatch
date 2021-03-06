package com.smanish.rest.client;

import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class JerseyClientPost {

	public static void main(String[] args) {

		try {
			Client client = Client.create();
			WebResource webResource = client
					.resource("http://localhost:8086/RESTfulExample/rest/json/tracks/post");
			String input = "{\"singer\":\"Metallica\",\"title\":\"Fade To Black\"}";
			ClientResponse response = webResource.type(MediaType.APPLICATION_JSON)
					.post(ClientResponse.class, input);
			if (response.getStatus() != 201) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ response.getStatus());
			}
			System.out.println("Response from Jersey .... \n");
			System.out.println(response.getEntity(String.class));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
