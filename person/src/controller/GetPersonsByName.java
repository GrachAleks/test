package controller;

import java.util.List;

import model.Person;
import model.PersonInfoModel;

public class GetPersonsByName extends Request {
	
	public GetPersonsByName() {
		super();
	}

	@Override
	public String[] runRequest(PersonInfoModel persons) {
		String[] res = new String[2];
		res[0] = "GetPersonsByName:";
		if(super.data.length == 2) {
			try {
				List<Person> list = persons.getPersonsName(data[1]);
				if(list != null && list.size() != 0) {
					res = new String[list.size() + 1];
					res[0] = "GetPersonsByName " + data[1];
					int i = 1;
					for(Person prs: list){
						res[i++] = prs.toString();
					}
				}
				else res[1] = "No persons with this name";
			} catch (NumberFormatException e) {
				res[1] = "Wrong data";
			}
		}
		else res[1] = "Wrong data number";
		return res;
	}

}
