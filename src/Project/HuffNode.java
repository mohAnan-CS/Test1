package Project;

public class HuffNode implements Comparable<HuffNode>{
	private char character;
	private int frequency;	
	private HuffNode left;
	private HuffNode right;
		
	public HuffNode() {
	}

	public HuffNode(char character, int frequency, HuffNode left, HuffNode right) {
		this.character = character;
		this.frequency = frequency;
		this.left = left;
		this.right = right;
	}
	
	public HuffNode(char character) {
		this.character = character;
	}

	
	public char getCharacter() {
		return character;
	}

	public void setCharacter(char character) {
		this.character = character;
	}

	public int getFrequency() {
		return frequency;
	}

	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}

	public HuffNode getLeft() {
		return left;
	}

	public void setLeft(HuffNode left) {
		this.left = left;
	}

	public HuffNode getRight() {
		return right;
	}

	public void setRight(HuffNode right) {
		this.right = right;
	}

	
	@Override
	public int compareTo(HuffNode o) {
		return this.frequency - o.getFrequency();
	}

	
//	@Override
//	public String toString() {
//		String ll="", rr="";
//		if (left == null) ll = "null"; else ll = left.getCharacter()+"";
//		if (right == null) rr = "null"; else rr = right.getCharacter()+"";
//		return "HuffNode [character=" + character + ", frequency=" + frequency + ", left=" + ll + ", right=" + rr
//				+ "]";
//	}
}
