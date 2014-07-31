package controller;

import model.Person;
import model.PersonInfoModel;

public class AddPerson extends Request {
	
	public AddPerson() {
		super();
	}

	@Override
	public String[] runRequest(PersonInfoModel persons) {
		String[] res = new String[2];
		res[0] = "AddPerson:";
		if(super.data.length == 4) {
			try {
				int id = Integer.parseInt(data[1]);
				String name = data[2];
				int year = Integer.parseInt(data[3]);
				Person prs = new Person(id, name, year);
				if(persons.addPerson(prs))
					res[1] = prs.toString();
				else
					res[1] = "This person already exists";
			} catch (NumberFormatException e) {
				res[1] = "Wrong data";
			}
		}
		else res[1] = "Wrong data number";
		return res;
	}
	
	

}
