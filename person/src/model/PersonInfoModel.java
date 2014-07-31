package model;

import java.util.*;

public interface PersonInfoModel {
	
	public boolean addPerson(Person person);
	public Person getPersonId(int id);
	public List<Person> getPersonsYears(int minYear, int maxYear);
	public List<Person> getPersonsName(String name);
	public boolean removePerson(int id);
}
