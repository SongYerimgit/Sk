package movie.recommendation;

import java.util.*;

public class MovieRecommender {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("당신의 상태는 어떤가요?");
        System.out.println("1. 지루해 죽겠어! 뭔가 재밌는 거 없어?");
        System.out.println("2. 아무거나 틀어줘. 고민하기 귀찮아");
        System.out.println("3. 피곤해.. 자고 싶어");

        int choice = scanner.nextInt();
        scanner.nextLine();

        if (choice == 3) {
            System.out.println("😴 푹 쉬세요. 다음에 또 만나요!");
            return;
        } else if (choice == 2) {
            String[] randomMovies = {""};
            String selected = randomMovies[random.nextInt(randomMovies.length)];
            System.out.println("🎲 랜덤 추천: " + selected);
            return;
        }

        // Step 1: 국가 선택
        System.out.println("보고 싶은 영화 국가를 선택하세요 (예: 한국, 미국, 일본):");
        String country = scanner.nextLine();

        // Step 2: 러닝타임
        System.out.println("원하는 러닝타임을 입력하세요 (예: 90, 120, 150 분):");
        int runtime = scanner.nextInt();
        scanner.nextLine(); // 개행 처리

        // Step 3: 장르 선택
        System.out.println("장르를 선택하세요 (예: 액션, 코미디, 드라마, 공포):");
        String genre = scanner.nextLine();

        // Step 4: 제작 연도
        System.out.println("원하는 제작 연도 (예: 2020):");
        int year = scanner.nextInt();
        scanner.nextLine(); // 개행 처리

        // Step 5: 감독
        System.out.println("좋아하는 감독이 있다면 입력하세요 (모르면 Enter):");
        String director = scanner.nextLine();

        // 결과 출력
        System.out.println("\n🔍 당신의 선택을 기반으로 영화를 추천합니다...");
        System.out.println("국가: " + country + " | 러닝타임: " + runtime + "분 | 장르: " + genre + " | 연도: " + year + " | 감독: " + (director.isEmpty() ? "무관" : director));
        System.out.println("추천 영화: 🎬 '당신 취향의 영화' (가상 추천)");

        System.out.println("\n프로그램을 종료합니다.");
        scanner.close();
    }
}
