package controller;

import java.io.*;

public class FileRequester implements Requester {
	
	private static final String DELEMETER = " ";
	
	protected BufferedReader in;
	
	public FileRequester() {
		super();
	}

	public FileRequester(String fileName) {
		super();
		try {
			in = new BufferedReader(new FileReader(fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Request getRequest() {
		Request req = null;
		String[] data;
		String line;
		if(in != null) {
			try {
				if((line = in.readLine()) != null && !line.equals("exit")){
						System.out.println(line);
						data = line.split(DELEMETER);
						req = createClass(data[0]);
						req.data = data;	
				}
			} catch (IOException e) {
				System.out.println("Error during reading file");
			}
		}
		return req;
	}

	private Request createClass(String className) {
		Request req =  null;
		try {
			Class<?> cl = Class.forName("controller." + className);
			Object obj = cl.newInstance();
			if(obj instanceof Request) {
				req = (Request) obj;
			}
		} catch (Exception e) {
			req = new WrongRequest();
		} 
		return req;
	}

}
