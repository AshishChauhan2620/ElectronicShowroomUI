package com.example.electronicshowroomUI;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.client.ClientConfig;

import com.example.pojo.Category;
import com.example.pojo.SubCategory;

public class RestClient {

	ClientConfig config;
	Client client;
	WebTarget webtarget;

	public RestClient() {
		config = new ClientConfig();
		client = ClientBuilder.newClient(config);
		webtarget = client.target("http://localhost:8081/ElectronicShowroom/");
	}

	public List<Category> getCategory() {
		return webtarget.path("/categoryapi/viewcategory").request().accept(MediaType.APPLICATION_JSON)
				.get(new GenericType<List<Category>>() {
				});
	}

	public String addcategory(Category category) {
		System.out.println(category);
		String answer = webtarget.path("/categoryapi/addcategory").request().post(Entity.json(category), String.class);
		return answer;

	}

	public String addSubCategory(SubCategory subCategory) {
		System.out.println(subCategory);
		String answer = webtarget.path("/subcategoryapi/addsubcategory").request().post(Entity.json(subCategory),
				String.class);
		return answer;

	}

}
