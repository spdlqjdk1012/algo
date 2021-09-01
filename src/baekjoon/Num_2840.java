package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class Num_2840 {
	public static void main(String[] args) {
		String result = null;
		Scanner scan = new Scanner(System.in);
		String info = scan.nextLine();
		String[] infoArray = info.split(" ");	
		int N =  Integer.parseInt(infoArray[0]);//바퀴 칸의 수
		int K =  Integer.parseInt(infoArray[1]);//바퀴 돌리는 수
		
		String[] charArray = new String[N];//바퀴 칸의 수 만큼 배열
		Arrays.fill(charArray, null);
		
		
		int check = 0;
		for(int i = 0; i < K; i++){
			Scanner scanDetail = new Scanner(System.in);
			String infoDetail = scanDetail.nextLine();
			String[] inputArray = infoDetail.split(" ");
			check += Integer.parseInt(inputArray[0]);			
			
			String nextChar = inputArray[1];
			if(charArray[check%N] != null && charArray[check%N].compareTo(nextChar)!=0) {
				result = "!";
				break;
			}
			charArray[check%N] = nextChar;
			
		}
		
		for(int i = 0; i<charArray.length; i++){
			if(charArray[i] == null)
				result += "?";
			else
				result += charArray[i];
		}
		
		System.out.println("result:"+result);
		//return 0;
	}

}