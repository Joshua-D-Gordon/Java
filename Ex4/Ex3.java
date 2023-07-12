
public class Ex3 {

	public static String moveCharToLast(String str, char ch){
		
		if(str.length() == 0) {
			return "";
		}
		
		String tempSt = str.substring(1, str.length());
		
		if(str.charAt(0) == ch) {
			return moveCharToLast(tempSt, ch) + ch ;
		} else {
			return str.charAt(0) + moveCharToLast(tempSt,ch);
		}
		
	}
	
	public static String reduce(String str) {
		
		if(str.length() == 1) {
			char last = str.charAt(0);
			return String.valueOf(last);
		}
		
		String tempSt = str.substring(1);
		
		if(str.charAt(0) == tempSt.charAt(0)) {
			return reduce(tempSt);
		} else {
			return str.charAt(0) + reduce(tempSt);
		}
		
	}
	
	public static boolean HelpMysplit(int[] nums, int sum1, int sum2,int size) {
		
		if(size == -1) {
			if(sum1 ==sum2) {
				return true;
			} else {
				return false;
			}
			
		}
		if(nums[size] % 5 == 0) {
			sum1+=nums[size];
			size = size - 1;
			return HelpMysplit(nums, sum1, sum2, size);
		}
		if(nums[size] % 3 == 0) {
			sum2 += nums[size];
			size = size -1;
			return HelpMysplit(nums, sum1, sum2, size);
		}
	
		return HelpMysplit(nums, sum1 + nums[size], sum2, size - 1) || HelpMysplit(nums, sum1, sum2 + nums[size], size - 1);
	
	
	}

	public static boolean mySplit(int[] nums) {
		
		int sum1 = 0 ,sum2 = 0, size = nums.length - 1;
		
		
		return HelpMysplit(nums, sum1, sum2,size);
	}
	
	
	
	

	public static int[][] sumOfNeighbours(int[][] mat){
		
		int[][] sumOfN = new int[mat.length][mat[0].length];
		
		int[][] matExtended = new int[mat.length + 2][mat[0].length + 2];
		
		for(int i = 1; i<matExtended.length - 1;i++) {
			for(int j = 1; j<matExtended[0].length - 1;j++) {
				matExtended[i][j] = mat[i-1][j-1];
			}
		}
		
		for(int i = 1; i<matExtended.length-1;i++) {
			for(int j = 1;j<matExtended[0].length-1;j++) {
				sumOfN[i-1][j-1] = matExtended[i-1][j-1] + matExtended[i-1][j] + matExtended[i-1][j+1] + matExtended[i][j-1] + matExtended[i][j+1] + matExtended[i+1][j-1] + matExtended[i+1][j] + matExtended[i+1][j+1];             
			}
		}
		

		return sumOfN;
	}
	
	
	
	
	public static String caesarCipherText(String str, int key) {
		
		String encrypted = "";
		String alphabet = "abcdefghijklmnopqrstuvwxyz";
		char[] chAlphabet = alphabet.toCharArray();
		char[] chSentence = str.toCharArray();
		
		for(int i = 0; i<chSentence.length; i++) {
			int count = 0;
			for(int j = 0; j<chAlphabet.length;j++) {
				
				if(key >= 0) {
					if(chAlphabet[j] == chSentence[i]) {
						encrypted += chAlphabet[(j+key)%26];
						count = -27;
					}
					count+=1;
				} else {
					if(chAlphabet[j] == chSentence[i]) {
						encrypted += chAlphabet[(j+ 26 + key)%26];
						count = -27;
					}
					count+=1;
				}
				
				
			}
			if(count>0) {
				encrypted += chSentence[i];
			}
		}
		
		return encrypted;
	}
	
	
	public static String vigenereCipherText(String str, String key) {
		
		int longKey = str.length()/key.length();
		int longkeyRemainder = str.length() % key.length();
		
		String newLongKey = "";
		for (int i = 0;i<longKey;i++) {
			newLongKey += key;
		}
		if(longkeyRemainder != 0) {
			char[] temp = key.toCharArray();
			for(int i = 0; i<longkeyRemainder;i++) {
				newLongKey += temp[i];
			}
		}
		
		String encrypted = "";
		String alphabet = "abcdefghijklmnopqrstuvwxyz";
		
		char[] strToChar = str.toCharArray();
		char[] newLongKeyToChar = newLongKey.toCharArray();
		for(int i = 0; i<strToChar.length;i++) {
			
			int indexStr = alphabet.indexOf(strToChar[i]);
			int indexLongKey = alphabet.indexOf(newLongKeyToChar[i]);
			int totalIndexs = indexStr + indexLongKey;
			
			if(indexStr == -1) {
				encrypted += strToChar[i];
			} else if(totalIndexs>=26) {
				encrypted += alphabet.charAt(totalIndexs%26);
			} else {
				encrypted += alphabet.charAt(totalIndexs);
			}
			
		}
		
		return encrypted;
	}
	
	
	public static String vigenereDecipherText(String str, String key) {
		
		int longKey = str.length()/key.length();
		int longkeyRemainder = str.length() % key.length();
		
		String newLongKey = "";
		for (int i = 0;i<longKey;i++) {
			newLongKey += key;
		}
		if(longkeyRemainder != 0) {
			char[] temp = key.toCharArray();
			for(int i = 0; i<longkeyRemainder;i++) {
				newLongKey += temp[i];
			}
		}
		
		String decrypted = "";
		String alphabet = "abcdefghijklmnopqrstuvwxyz";
		
		char[] strToChar = str.toCharArray();
		char[] newLongKeyToChar = newLongKey.toCharArray();
		for(int i = 0; i<strToChar.length;i++) {
			
			int indexStr = alphabet.indexOf(strToChar[i]);
			int indexLongKey = alphabet.indexOf(newLongKeyToChar[i]);
			int totalIndexs = indexStr - indexLongKey;
			
			if(indexStr != -1) {
				if(totalIndexs>=0) {
					decrypted += alphabet.charAt(totalIndexs%26);
				}else {
					decrypted += alphabet.charAt(26 + totalIndexs);
				}
			} else {
				decrypted += strToChar[i];
			}
			
			
		}
		
		return decrypted;
		
	
	}


}
