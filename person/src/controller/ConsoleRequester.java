package controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ConsoleRequester extends FileRequester {

	public ConsoleRequester() {
		super();
		super.in = new BufferedReader(new InputStreamReader(System.in));
	}

	
}
