/**
 * Package Name : movie.recommendation <br/>
 * Class Name: MovieRecommender2.java <br/>
 * Description:  <br/>
 * Modification imformation : <br/> 
 * ------------------------------------------<br/>
 * 최초 생성일 : 2025-04-21<br/>
 *
 * ------------------------------------------<br/>
 * @author :user
 * @since  :2024-09-09
 * @version: 0.5
 */
package movie.recommendation;

import java.util.Random;
import java.util.Scanner;
import java.util.*;

public class MovieRecommender2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();
//사용자 상태 선택
		System.out.println("당신의 상태를 선택하세요:");
		System.out.println("1. 아무거나 틀어줘.. 고민하기 귀찮아");
		System.out.println("2. 감독 선택");
		System.out.println("3. 아무거나 틀어줘.. 고민하기 귀찮아 (랜덤 추천)");
		System.out.println("4. 피곤해.. 자고 싶어");
//사용자의 선택에 따른 분기
		int choice = scanner.nextInt();
		scanner.nextLine(); // 개행처리
		switch (choice) {
		case 1:
			handleDetailedRecommendation(scanner);
			break;

		case 2:
			handleDirectorSelection(scanner);
			break;

		case 3:
			handleRandomRecommendation();
			break;

		case 4:
			System.out.println("😴 푹 쉬세요. 다음에 또 만나요!");
			break;

		default:
			System.out.println("올바른 번호를 선택하세요.");
		}

		System.out.println("\n프로그램을 종료합니다.");
		scanner.close();
	}

//상세 정보 추천 로직
	private static void handleDetailedRecommendation(Scanner scanner) {
		System.out.println("나라를 선택하세요 (예: 한국, 미국, 일본):");
		String country = scanner.nextLine();

		System.out.println("러닝타임을 입력하세요 (분):");
		int runtime = scanner.nextInt();
		scanner.nextLine();

		System.out.println("장르를 입력하세요 (예: 액션, 코미디, 드라마):");
		String genre = scanner.nextLine();

		System.out.println("제작 연도 입력 (예: 2021):");
		int year = scanner.nextInt();
		scanner.nextLine();

		System.out.println("\n🔍 조건 기반 추천 결과:");
		System.out.printf("국가: %s | 러닝타임: %d분 | 장르: %s | 제작연도: %d\n", country, runtime, genre, year);
		System.out.println("추천 영화: 🎬 '당신 취향의 영화' (가상 추천)");
	}

//감독 선택 추천
	private static void handleDirectorSelection(Scanner scanner) {
		System.out.println("좋아하는 감독을 입력하세요:");
		String director = scanner.nextLine();

		System.out.println("\n🔍 감독 기반 추천 결과:");
		System.out.println("선택한 감독: " + director);
		System.out.println("추천 영화: 🎬 '" + director + "' 감독의 대표작 (가상 추천)");
	}

//랜덤 영화 추천
	private static void handleRandomRecommendation() {
		String[] randomMovies = { "인사이드 아웃", "라라랜드", "매드 맥스: 분노의 도로", "기생충", "인터스텔라" };
		Random random = new Random();
		String result = randomMovies[random.nextInt(randomMovies.length)];

		System.out.println("\n🎲 랜덤 추천: " + result);
	}
}
