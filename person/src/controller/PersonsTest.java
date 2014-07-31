package controller;

import view.PersonInfoView;
import model.PersonInfoModel;

public class PersonsTest implements Runnable {

	private PersonInfoModel persons;
	private Requester requester;
	private PersonInfoView view;

	public PersonsTest(PersonInfoModel persons, Requester requester,
			PersonInfoView view) {
		super();
		this.persons = persons;
		this.requester = requester;
		this.view = view;
	}

	@Override
	public void run() {
		String [] result;
		Request request;
			

		while((request = requester.getRequest()) != null) {
			result = request.runRequest(persons);
			view.show(result);
		}

	}

}
