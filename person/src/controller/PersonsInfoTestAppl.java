package controller;

import view.*;
import model.*;

public class PersonsInfoTestAppl {

	public static void main(String[] args) {
		//PersonInfoModel model = new PersonInfoList();
		//PersonInfoModel model = new PersonInfoMaps();
		PersonInfoModel model = new PersonInfoSQL("test", "root", "");
		
		//Requester requester = new FileRequester("Requests_10.txt");
		Requester requester = new ConsoleRequester();
		
		PersonInfoView view = new PersonInfoConsole();
		
		
		PersonsTest test = new PersonsTest(model, requester, view);
		
		test.run();
	}

}
