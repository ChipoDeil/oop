package testing;

import java.util.ArrayList;

public class Crypto {
	public final int start = 1040;
	public final int end = 1103;
	public String cryptCaesar(String text, int shift){
		String result = "";
		int difference = end - start;
		ArrayList<Integer> ids = new ArrayList<>();
		while(shift  - difference > 0){
			shift = shift - difference;
		}
		readChars(text, ids);
		for (int i = 0; i < ids.size(); i++) {
			if(ids.get(i) >= start && ids.get(i) <= end){
				if(ids.get(i) + shift > end){
					int difference1 = ids.get(i) + shift - end - 1;
					result = result + Character.toString((char)(start + difference1));
				}else if(ids.get(i) + shift < start){
					int difference1 = start - ids.get(i) - shift - 1;
					result = result + Character.toString((char)(end - difference1));
				}else{
					result = result + Character.toString((char)(ids.get(i) + shift));
				}
			}else{
				result = result + Character.toString((char)(ids.get(i)+0));
			}		
		}
		return result;
	}
	
	public ArrayList<String> decryptCaesar(String text){
		ArrayList<String> result = new ArrayList<>();
		ArrayList<Integer> ids = new ArrayList<>();
		readChars(text, ids);
		int difference = end-start;
		for (int j = 0; j <= difference; j++) {
			int shift = j;
			String resultLine = "";
			for (int i = 0; i < ids.size(); i++) {
				int id = ids.get(i);
				if(id >= start && id <= end){
					if(id + shift > end){
						int less = id + shift - end - 1;
						resultLine = resultLine + Character.toString((char)(start + less));
					}else if(id + shift < start){
						int less = start - id - shift - 1;
						resultLine = resultLine + Character.toString((char)(end - less));
					}else{
						resultLine = resultLine + Character.toString((char)(id + shift));
					}
				}else{
					resultLine = resultLine + Character.toString((char)(id));
				}
			}
			result.add(resultLine + " | Shift: " + (difference - shift+1));
		}
		return result;
	}
	
	public void readChars(String text, ArrayList<Integer> ids){
		for (int i = 0; i < text.length(); i++) {
			char currentChar = text.charAt(i);
			ids.add(Integer.parseInt(Integer.toBinaryString(currentChar), 2));
		}
	}
	
}
