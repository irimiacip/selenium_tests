package net.metrosystems.seleniumtests;

import java.util.LinkedList;

import org.json.simple.JSONObject;

public class WindowsExecutable {

	
	
	public static JSONObject callExe() {
		JSONObject obj = new JSONObject();
		obj.put("executable","sauce-storage:test.exe");
		LinkedList<String> list = new LinkedList<String>();
		list.add("/S");
		list.add("-a");
		list.add("-q");
		obj.put("args",list);
		obj.put("background","true");
		obj.put("timeout", "240");
		System.out.print(obj); 
		return obj;
	}

}
