package model;

import java.sql.*;
import java.util.*;

import tel_ran.database.DatabaseConnection;

public class PersonInfoSQL implements PersonInfoModel {

	Statement statement;
	
	public PersonInfoSQL(String dbName,String username, String password) {
		super();
		try {
			this.statement = DatabaseConnection.getDatabaseConnection(dbName, username, password);
			String sql = "CREATE TABLE IF NOT EXISTS persons (id INTEGER, name VARCHAR(254),"
					+ " birthYear INTEGER, PRIMARY KEY(id), INDEX(name), INDEX(birthYear))";
			statement.executeUpdate(sql);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean addPerson(Person person) {
		boolean res = false;
		int id = person.getId();
		String name = person.getName();
		int year = person.getBirthYear();
		if(getPersonId(id) == null) {
			String sql = "INSERT INTO persons(id, name, birthYear)"
					+ " VALUES (" + id + ", '" + name + "', " + year + ")";
			try {
				statement.executeUpdate(sql);
				res = true;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return res;
	}

	@Override
	public Person getPersonId(int id) {
		Person person = null;
		String sql = "SELECT * FROM persons WHERE id = " + id;
		try {
			ResultSet rs = statement.executeQuery(sql);
			if(rs.next()){
				person = new Person(rs.getInt("id"), rs.getString("name"), rs.getInt("birthYear"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return person;
	}

	@Override
	public List<Person> getPersonsYears(int minYear, int maxYear) {
		List<Person> result = new ArrayList<Person>();
		String sql = "SELECT * FROM persons WHERE birthYear BETWEEN " + minYear + " AND " + maxYear;
		getResult(result, sql);
		return result;
	}
	
	@Override
	public List<Person> getPersonsName(String name) {
		List<Person> result = new ArrayList<Person>();
		String sql = "SELECT * FROM persons WHERE name = '" + name + "'";
		getResult(result, sql);
		return result;
	}

	private void getResult(List<Person> result, String sql) {
		try {
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				result.add(new Person(rs.getInt("id"), rs.getString("name"), rs.getInt("birthYear")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean removePerson(int id) {
		boolean res = false;
		if(getPersonId(id) != null) {
			String sql = "DELETE FROM persons WHERE id = " + id;
			try {
				statement.executeUpdate(sql);
				res = true;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return res;
	}

}
