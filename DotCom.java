package game;

import java.util.ArrayList;

public class DotCom {
	private ArrayList<String> locationCells;
	private String name;
	
	public void setLocationCell(ArrayList<String> locs) {
		locationCells = locs;
	}
	
	public String checkYourself(String userInput) {
		String result = "miss";
		
		int index = locationCells.indexOf(userInput);
		if (index >= 0) {
			locationCells.remove(index);
			
			if (locationCells.isEmpty()) {
				result = "kill";
				System.out.println("Ouch! You sunk " + name + " :( ");
			} else {
				result = "hit";
			}		
		}
		
		//System.out.println("index :" + index);
		System.out.println(result);
		
		return result;
	}
	
	public void setName(String n) {
		name = n;
	}
}
