package testing;

public class Crypto {
	public final int start = 1040;
	public final int end = 1103;
	public String cryptCaesar(String text, int shift){
		String result = "";
		int difference = end - start;
		while(shift  - difference > 0){
			shift = shift - difference;
		}
		for (int i = 0; i < text.length(); i++) {
			char currentChar = text.charAt(i);
			int id = Integer.parseInt(Integer.toBinaryString(currentChar), 2);
			if(id + shift > end){
				int difference1 = id + shift - end - 1;
				result = result + Character.toString((char)(start + difference1));
			}else if(id + shift < start){
				int difference1 = start - id + shift - 1;
				result = result + Character.toString((char)(end - difference1));
			}else{
				id = id + shift;
				result = result + Character.toString((char)id);
			}
		}
		return result;
	}
	
}
