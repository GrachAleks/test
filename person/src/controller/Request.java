package controller;

import model.*;

public abstract class Request {
	
	protected String[] data;
	
	public abstract String[] runRequest(PersonInfoModel persons);

	
}
