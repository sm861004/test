package com.safe.www.comm.resolver;

import java.util.HashMap;

/**
 * reserver command 
 * @author Bang Seok Min  
 * 생성날짜 : 2017. 6. 16.
 */
public class Command {
	
	public HashMap<String, Object> map = new HashMap<String, Object>();
	
	public Object get(String key) {
		return map.get(key);
	}
	
	public void put(String key, Object value) {
		map.put(key, value);
	}
	
	public Object remove(String key) {
		return map.remove(key);
	}
	
	public boolean containsKey(String key) {
		return map.containsKey(key);
	}
	
	public boolean containsValue(Object value) {
		return map.containsValue(value);
	}
	
	public void clear() {
		map.clear();
	}
	
	public boolean isEmpty() {
		return map.isEmpty();
	}
	
	public HashMap<String,Object> getMap() {
		return map;
	}

}
