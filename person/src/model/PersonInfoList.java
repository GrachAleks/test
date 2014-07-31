package model;

import java.util.*;

public class PersonInfoList implements PersonInfoModel {
	
	private List<Person> persons;
	
	public PersonInfoList() {
		super();
		this.persons = new ArrayList<Person>();
	}

	@Override
	public boolean addPerson(Person person) {
		boolean res = false;
		if(person != null && !persons.contains(person)) {
			persons.add(person);
			res = true;
		}
		return res;
	}

	@Override
	public Person getPersonId(int id) {
		Person res = null;
		for(Person prs: persons) {
			if(prs.getId() == id) {
				res = prs;
				break;
			}
		}
		return res;
	}

	@Override
	public List<Person> getPersonsYears(int minYear, int maxYear) {
		List<Person> temp = new ArrayList<Person>();
		for(Person prs: persons) {
			int year = prs.getBirthYear();
			if(minYear <= year && year <= maxYear)
				temp.add(prs);
		}
		return temp;
	}

	@Override
	public List<Person> getPersonsName(String name) {
		List<Person> temp = new ArrayList<Person>();
		for(Person prs: persons) {
			if(prs.getName().equals(name))
				temp.add(prs);
		}
		return temp;
	}

	@Override
	public boolean removePerson(int id) {
		return persons.remove(new Person(id, null, 0));
	}

}
