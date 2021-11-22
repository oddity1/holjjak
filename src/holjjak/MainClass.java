package holjjak;

import java.util.Random;
import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) {

		System.out.println("오징어 게임에 참가하신 여러분 환영합니다.");
		System.out.println("이번 스테이지는 구슬 홀짝 게임입니다.");
		System.out.println("상대방의 구슬을 모두 획득하면 생존하고");
		System.out.println("구슬을 모두 빼앗기면 탈락입니다.");
		System.out.println("몇개의 구슬을 베팅하겠습니까?");

		int marble = 10;
		Scanner sc = new Scanner(System.in);

		while (true) {
			int bet = 0;
			System.out.println("당신의 구슬은 " + marble + "개 입니다.");
			System.out.println("구슬을 베팅하시오: ");
			try {
				bet = sc.nextInt();
			} catch (Exception e) {
				System.out.println("숫자만 입력이 가능합니다.");
				sc.nextLine();
				continue;
			}
			if (marble < bet) {
				System.out.println("베팅할 구슬이 부족합니다. 다시 입력 바랍니다.");
				continue;
			}

			Random rnd = new Random();
			String cpuDab = "홀";
			if (rnd.nextInt(2) == 0) {
				cpuDab = "짝";
			}

			System.out.println("홀/짝 중에 입력: ");
			String userDab = sc.next();

			if (cpuDab.equals(userDab)) {
				System.out.println("맞췄다 구슬 가지고와!");
				marble = marble + bet;
			} else { 
				System.out.println("내가 졌네...");
				marble = marble - bet;
			}
			if (marble == 0) {
				System.out.println("구슬을 모두 빼앗겨 탈락입니다. 빵!!");
				break;
			}
			if (marble >= 20) {
				System.out.println("상대방의 구슬을 모두 획득했습니다. 다음 스테이지로!!");
			    break;
			}

		}

	}
}
