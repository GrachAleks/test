package model;

import java.util.*;

public class PersonInfoMaps implements PersonInfoModel {
	
	private HashMap<Integer, Person> personsID;
	private TreeMap<Integer, List<Person>> personsYear;
	private HashMap<String, List<Person>> personsName;
	
	public PersonInfoMaps() {
		super();
		this.personsID = new HashMap<Integer, Person>();
		this.personsYear = new TreeMap<Integer, List<Person>>();
		this.personsName = new HashMap<String, List<Person>>();
	}

	@Override
	public boolean addPerson(Person person) {
		boolean res = false;
		int id = person.getId();
		if(!personsID.containsKey(id)){
			personsID.put(id, person);
			addPersonYear(person);
			addPersonName(person);
			res = true;
		}
		return res;
	}

	private void addPersonName(Person person) {
		String name = person.getName();
		List<Person> persons = personsName.get(name);
		if(persons == null) {
			persons = new ArrayList<Person>();
			personsName.put(name, persons);
		}
		persons.add(person);
		
	}

	private void addPersonYear(Person person) {
		int year = person.getBirthYear();
		List<Person> persons = personsYear.get(year);
		if(persons == null) {
			persons = new ArrayList<Person>();
			personsYear.put(year, persons);
		}
		persons.add(person);
	}

	@Override
	public Person getPersonId(int id) {
		return personsID.get(id);
	}

	@Override
	public List<Person> getPersonsYears(int minYear, int maxYear) {
		NavigableMap<Integer, List<Person>> subMap = personsYear.subMap(minYear, true, maxYear, true);
		return mapTpList(subMap);
	}

	private List<Person> mapTpList(NavigableMap<Integer, List<Person>> subMap) {
		List<Person> res = null;
		if(subMap != null) {
			Collection<List<Person>> collect = subMap.values();
			if(collect != null) {
				res = new ArrayList<Person>();
				for(List<Person> list: collect)
					res.addAll(list);
			}
		}
		return res;
	}

	@Override
	public List<Person> getPersonsName(String name) {
		return personsName.get(name);
	}

	@Override
	public boolean removePerson(int id) {
		boolean res = false;
		Person prs = personsID.remove(id);
		if(prs != null) {
			removePersonYear(prs);
			removePersonName(prs);
			res = true;
		}
		return res;
	}

	private void removePersonName(Person prs) {
		personsName.get(prs.getName()).remove(prs);
	}

	private void removePersonYear(Person prs) {
		personsYear.get(prs.getBirthYear()).remove(prs);
	}

}
