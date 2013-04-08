package com.inno.displacement.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class JsonArray {
	private List<String> jsonArray;
	
	public JsonArray() {
		this.jsonArray = new ArrayList<String>();
	}
	
	public void add(Object entity) throws Exception {
		jsonArray.add(Object2Map.obj2JsonObj(entity));
	}
	
	public void add(Map<String, Object> map) {
		jsonArray.add(Object2Map.map2JsonObj(map));
	}
	
	public static void main(String[] args) throws Exception {
		JsonArray json = new JsonArray();
		Person person = new Person();
		person.setName("hello");
		person.setAge(18);
		person.setSex("man");
		
		json.add(person);
		json.add(person);
		json.add(person);
		
		System.out.println(json.jsonArray);
	}
}
