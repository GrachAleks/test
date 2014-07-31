package controller;

import java.util.List;

import model.Person;
import model.PersonInfoModel;

public class GetPersonsByYear extends Request {

	public GetPersonsByYear() {
		super();
	}

	@Override
	public String[] runRequest(PersonInfoModel persons) {
		String[] res = new String[2];
		res[0] = "GetPersonsByYear:";
		if(super.data.length == 3) {
			try {
				int minYear = Integer.parseInt(data[1]);
				int maxYear = Integer.parseInt(data[2]);
				List<Person> list = persons.getPersonsYears(minYear, maxYear);
				if(list != null && list.size() != 0) {
					res = new String[list.size() + 1];
					res[0] = "GetPersonsByYear from " + minYear + " to " + maxYear;
					int i = 1;
					for(Person prs: list){
						res[i++] = prs.toString();
					}
				}
				else res[1] = "No persons with this birthYear";
			} catch (NumberFormatException e) {
				res[1] = "Wrong data";
			}
		}
		else res[1] = "Wrong data number";
		return res;
	}

}
