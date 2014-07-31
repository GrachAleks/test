package view;

public class PersonInfoConsole implements PersonInfoView {

	@Override
	public String show(String[] lines) {
		for(String str: lines)
			System.out.println(str);
		return null;
	}

}
