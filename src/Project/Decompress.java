package Project;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Decompress {
	private static String extension;
	private static int reminder;
	private static String codesTableStr;
	private static String encryptedText;
	private static HuffNode root = new HuffNode();
	private static String plainText;
	
	public static void main(String[] args) throws FileNotFoundException {
		readFile(new File("compressed.hf"));
		
		System.out.println(extension);
		System.out.println(reminder);
		System.out.println(codesTableStr);
		System.out.println(encryptedText);
		
		
		CharCode[] arr = storeCodes(codesTableStr);
		buildHuffmanTree(arr);
		setPlainText(root, getBinaryText());
		System.out.println(plainText);
	}
	
	
	private static void readFile(File file) throws FileNotFoundException {
		Scanner sc = new Scanner(file);
		
		extension = sc.next();
		reminder = sc.nextInt(); sc.nextLine();
		codesTableStr = sc.nextLine();
		encryptedText = sc.nextLine();
		
		sc.close();
	}
	
	
	private static CharCode[] storeCodes(String codesTable) {
		String[] array = codesTable.split(" ");
		CharCode[] arrayOfFreq = new CharCode[array.length];
		
		for (int i = 0; i < array.length; i++) {
			char character = array[i].charAt(0);
			int freq = Integer.parseInt(array[i].substring(1));
			arrayOfFreq[i] = new CharCode(character, freq);
		}
		
//		for (CharCode charCode : arrayOfFreq) {
//			System.out.println(charCode);
//		}
		return arrayOfFreq;
	}
	
	
	
	private static void buildHuffmanTree(CharCode[] arr) {
		for (int i = 0; i < arr.length; i++) {
			huffmanTree(root, arr[i].getCharacter(), arr[i].getCode()+"");
		}
	}
	
	
	private static void huffmanTree(HuffNode node, char character, String directions) {
		if (directions.equals("0")) {
			HuffNode tempNode = new HuffNode(character);
			node.setLeft(tempNode);
			
			return;
		}
		
		if (directions.equals("1")) {
			HuffNode tempNode = new HuffNode(character);
			node.setRight(tempNode);
			
			return;
		}
			
		
		if (directions.charAt(0) == '0') {
			if (node.getLeft() == null) {
				node.setLeft(new HuffNode());
			}
			huffmanTree(node.getLeft(), character, directions.substring(1));
		}
		
		else {
			if (node.getRight() == null) {
				node.setRight(new HuffNode());
			}
			huffmanTree(node.getRight(), character, directions.substring(1));
		}
	}
	
	
	
	private static String getBinaryText() {
		String str = "";
		
		for (int i = 0; i < encryptedText.length()-1; i++) {
			int decimal = encryptedText.charAt(i);
			int binary = Integer.parseInt(Integer.toBinaryString(decimal));
			System.out.println(encryptedText.charAt(i) + " dec " + decimal + " --- bin " + binary);
			str += String.format("%08d", binary);
		}
		
		int decimal = encryptedText.lastIndexOf(0);
		String binary = Integer.toBinaryString(decimal);
		binary = String.format("%08d", Integer.parseInt(binary));
		
		int index = 8-reminder;
		str += binary.substring(index);
//		System.out.println("dec " + decimal + " --- bin " + binary.substring(index));

		System.out.println(str);
		
		return str;
	}
	
	
	private static void setPlainText(HuffNode node, String binaryText) {
		if (binaryText.length() == 0)
			return;
		
		if (binaryText.charAt(0) == '0') {
			if (isLeaf(node.getLeft())) {
				plainText += node.getLeft().getCharacter();
				setPlainText(root, binaryText.substring(1));
			}
			
			else 
				setPlainText(node.getLeft(), binaryText.substring(1));
		}
		
		else {
			if (isLeaf(node.getRight())) {
				plainText += node.getRight().getCharacter();
				setPlainText(root, binaryText.substring(1));
			}
			
			else
				setPlainText(node.getRight(), binaryText.substring(1));
		}
		
		
		 
		
		
	}
	
	private static boolean isLeaf(HuffNode node) {
		if (node.getLeft() == null && node.getRight() == null)
			return true;
		
		return false;
	}
}






