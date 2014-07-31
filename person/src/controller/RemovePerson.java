package controller;

import model.PersonInfoModel;

public class RemovePerson extends Request {
	
	public RemovePerson() {
		super();
	}

	@Override
	public String[] runRequest(PersonInfoModel persons) {
		String[] res = new String[2];
		res[0] = "RemovePerson:";
		if(super.data.length == 2) {
			try {
				int id = Integer.parseInt(data[1]);
				
				if(persons.removePerson(id))
					res[1] = "Person with id " + id + " was removed";
				else
					res[1] = "Person with id " + id + " was not removed";
			} catch (NumberFormatException e) {
				res[1] = "Wrong data";
			}
		}
		else res[1] = "Wrong data number";
		return res;
	}

}
