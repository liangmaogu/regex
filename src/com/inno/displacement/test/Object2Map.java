package com.inno.displacement.test;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Object2Map {
	public static Map<String, Object> obj2Map(Object entity) throws Exception { 
		Map<String, Object> map = new HashMap<String, Object>();
		
		Class<?> clazz = entity.getClass();
		Method[] methods = clazz.getMethods();
		for (Method method : methods) {
			String mName = method.getName();
			String fName = "";
			if (mName.startsWith("get")) {
				fName = mName.substring(3).toLowerCase();
				map.put(fName, method.invoke(entity));
			} else if (mName.startsWith("is")) {
				fName = mName.substring(2).toLowerCase();
				map.put(fName, method.invoke(entity));
			}
		}
		
		return map;
	}
	
	public static <T> T map2Obj(Map<String, Object> map, Class<T> clazz) throws Exception {
		T obj = clazz.newInstance();
		Method[] methods = clazz.getMethods();
		for (Method method : methods) { 
			String mName = method.getName();
			if (mName.startsWith("set")) {
				String fName = mName.substring(3).toLowerCase();
				method.invoke(obj, new Object[] {map.get(fName)});
			} 
		}
		
		return obj;
	}
	
	public static String map2JsonObj(Map<String, Object> map) {
		StringBuffer sb = new StringBuffer();
		sb.append("{");
		Set<String> keys = map.keySet();
		int i = 0;
		for (String key : keys) {
			if (i > 0) {
				sb.append(", ");
			}
			sb.append(key + ": " + map.get(key));
			i++;
		}
		sb.append("}");
		
		return sb.toString();
	}
	
	public static String obj2JsonObj(Object entity) throws Exception {
		return map2JsonObj(obj2Map(entity));
	}
	
	public static void main(String[] args) throws Exception {
		Person person = new Person();
		person.setName("good");
		person.setAge(18);
		person.setSex("man");
		
		Map<String, Object> obj = obj2Map(person);
		System.out.println(obj);
		
		Person person2 = map2Obj(obj, Person.class);
		System.out.println(person2.getName());
		
		System.out.println(map2JsonObj(obj));
		System.out.println(obj2JsonObj(person));
	}
}
