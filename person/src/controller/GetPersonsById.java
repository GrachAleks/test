package controller;

import model.Person;
import model.PersonInfoModel;

public class GetPersonsById extends Request {
	
	public GetPersonsById() {
		super();
	}

	@Override
	public String[] runRequest(PersonInfoModel persons) {
		String[] res = new String[2];
		res[0] = "GetPersonsById:";
		if(super.data.length == 2) {
			try {
				int id = Integer.parseInt(data[1]);
				Person prs = persons.getPersonId(id);
				if(prs != null)
					res[1] = data[1] + " " + prs.toString();
				else
					res[1] = "No person with this id " + data[1];
			} catch (NumberFormatException e) {
				res[1] = "Wrong data";
			}
		}
		else res[1] = "Wrong data number";
		return res;
	}

}
