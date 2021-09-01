package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class Num_1032 {
	public static void main(String[] args) {
		String result = "";
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();

		String[] array = new String[num];

		for (int i = 0; i < array.length; i++) {
			Scanner scanTmp = new Scanner(System.in);
			array[i] = scanTmp.nextLine();
		}

		// 글자수만큼 체크
		boolean diff = false;
		for (int i = 0; i < array[0].length(); i++) {
			//전체 입력한 문자열의 i번쨰 문자 비교
			for (int j = 0; j < array.length; j++) {
				diff = false;
				if (array[0].charAt(i) != array[j].charAt(i)) {
					diff = true;
					break;
				}
			}

			if (diff == true) {
				result += "?";
			} else {
				result += array[0].charAt(i);
			}
		}

		System.out.println("result:" + result);
	}

}