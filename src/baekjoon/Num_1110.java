package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class Num_1110 {
	public static int main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String num = scan.nextLine();
		if (Integer.parseInt(num) < 10)
			num = "0" + num;
		String fristNum = num;
		int cnt = 0;
		while (true) {
			cnt++;
			String[] numArray = num.split("");// 26 [2][6]
			int sum = Integer.parseInt(numArray[0]) + Integer.parseInt(numArray[1]);
			String sumString = "" + sum;
			if (sum < 10)
				sumString = "0" + sum;
			String[] sumArray = sumString.split("");

			String newNum = numArray[1] + sumArray[1];
			if (newNum.compareTo(fristNum) == 0)
				break;
			num = newNum;
		}

		System.out.println("cnt:" + cnt);
		return 0;
	}

}