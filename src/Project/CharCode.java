package Project;

public class CharCode implements Comparable<CharCode>{
	private char character;
	private int code;
	
	
	public CharCode(char character, int code) {
		this.character = character;
		this.code = code;
	}


	public char getCharacter() {
		return character;
	}

	public void setCharacter(char character) {
		this.character = character;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}


	@Override
	public String toString() {
		return "CharFreq [character=" + character + ", frequency=" + code + "]\n";
	}


	@Override
	public int compareTo(CharCode o) {
		return this.code - o.getCode();
	}
	
	
}
