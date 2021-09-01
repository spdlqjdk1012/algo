package baekjoon;

import java.util.Scanner;

public class Num_1244 {
	static int main(String[] args) {
		Scanner scan = new Scanner(System.in);
		// 1번 입력 값 : 스위치 갯수
		int switchNum = scan.nextInt();

		int switchCnt = switchNum / 20; // switchNum 20개 넘어갈때 고려 43개라면 20 20 4 세번 끊어서 입력받음 44/20= 2...4 => 3줄 받아야함
		if (switchNum % 20 > 0)
			switchCnt++;

		// 2번 입력 값 : 스위치 한줄에 20개씩
		int[] switchArray = new int[switchNum];

		int tmpcnt = 0;
		for (int i = 0; i < switchCnt; i++) {
			Scanner scanSD = new Scanner(System.in);
			String switchTmp = scanSD.nextLine();// 스위치 갯수
			String[] switchTmpArray = switchTmp.split(" ");
			for (int j = 0; j < switchTmpArray.length; j++) {
				switchArray[j + tmpcnt] = Integer.parseInt(switchTmpArray[j]);
			}
			tmpcnt += 20;
		}

		Scanner scanp = new Scanner(System.in);
		// 3번 입력 값 : 사람수
		int peopleNum = scanp.nextInt();

		for (int i = 0; i < peopleNum; i++) {
			Scanner scanPDetail = new Scanner(System.in);
			String switchTmp = scanPDetail.nextLine();// 첫번째 사람 1 3
			String[] peopleInfo = switchTmp.split(" ");// 0번째는 성별, 1번째는 스위치 번호

			// 남자일 경우
			if (peopleInfo[0].equals("1")) {
				int numInfo = Integer.parseInt(peopleInfo[1]); // 초기값 3
				if (numInfo <= 0 || numInfo > switchArray.length)
					continue;
				while (numInfo <= switchNum) {
					if (switchArray[numInfo - 1] == 1)
						switchArray[numInfo - 1] = 0;
					else
						switchArray[numInfo - 1] = 1;
					numInfo += numInfo;
				}
			}

			// 여자일 경우
			else if (peopleInfo[0].equals("2")) {
				int numInfo = Integer.parseInt(peopleInfo[1]); // 초기값 3
				if (numInfo <= 1 || numInfo >= switchArray.length)
					continue;
				int firstNum = numInfo - 1;// 2번
				int lastNum = numInfo + 1;// 4번
				int cnt = 0;
				if (firstNum <= 1 || lastNum >= switchArray.length)
					break;

				while (firstNum > 0 && lastNum < switchArray.length + 1) {
					// 대칭일때만 돈다
					if (switchArray[firstNum - 1] != switchArray[lastNum - 1])
						break;

					// 처음 한바퀴 진입하면 자기자신도 스위치 상태 바꾼다
					if (cnt == 0) {
						if (switchArray[numInfo - 1] == 1)
							switchArray[numInfo - 1] = 0;
						else
							switchArray[numInfo - 1] = 1;
						cnt++;
					}
					// 대칭인 경우 중심으로 양쪽 스위치 상태 변경
					if (switchArray[firstNum - 1] == 1)
						switchArray[firstNum - 1] = 0;
					else
						switchArray[firstNum - 1] = 1;

					if (switchArray[lastNum - 1] == 1)
						switchArray[lastNum - 1] = 0;
					else
						switchArray[lastNum - 1] = 1;

					firstNum -= 1;
					lastNum += 1;
				}
			}
		}
		// drawSwitchArray(switchArray);
		return 0;
	}

	public static void drawSwitchArray(int[] switchArray) {
		for (int k = 0; k < switchArray.length; k++) {
			System.out.print(switchArray[k] + " ");
		}
	}
}