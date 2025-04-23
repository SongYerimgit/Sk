package sk01;

import java.util.List;
import java.util.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static List<Title> movieDB = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        loadSampleMovies(); // 샘플 데이터 로드
        while (true) {
            System.out.println("\n== 영화 추천 시스템 ==");
            System.out.println("1. 사용자");
            System.out.println("2. 관리자");
            System.out.println("0. 종료");
            System.out.print("선택: ");
            int choice = sc.nextInt();

            if (choice == 1) userMenu();
            else if (choice == 2) adminMenu();
            else if (choice == 0) break;
        }
        System.out.println("프로그램 종료");
    }

    // 사용자 메뉴
    static void userMenu() {
        System.out.println("\n== 사용자 메뉴 ==");
        System.out.println("1. 응답에 따른 영화 추천");
        System.out.println("2. 아무거나 추천");
        System.out.println("3. 감독 별 영화 리스트");
        System.out.println("4. 종료");

        System.out.print("선택: ");
        int choice = sc.nextInt();
        sc.nextLine();

        switch (choice) {
            case 1: recommendByAnswers(); break;
            case 2: randomMovie(); break;
            case 3: listByDirector(); break;
            case 4: return;
        }
    }

    // 관리자 메뉴
    static void adminMenu() {
        System.out.print("관리자 비밀번호 입력: ");
        String password = sc.next();

        if (!password.equals("admin123")) {
            System.out.println("비밀번호 틀림");
            return;
        }

        while (true) {
            System.out.println("\n== 관리자 메뉴 ==");
            System.out.println("1. 데이터 등록");
            System.out.println("2. 데이터 수정");
            System.out.println("3. 데이터 삭제");
            System.out.println("0. 돌아가기");
            System.out.print("선택: ");
            int adminChoice = sc.nextInt();
            sc.nextLine();

            if (adminChoice == 1) addMovie();
            else if (adminChoice == 2) editMovie();
            else if (adminChoice == 3) deleteMovie();
            else break;
        }
    }

    // 추천 1: 응답 기반
    static void recommendByAnswers() {
        sc.nextLine();
        System.out.print("나라 입력: ");
        String country = sc.nextLine();
        System.out.print("장르 입력: ");
        String genre = sc.nextLine();
        System.out.print("장편/단편 입력: ");
        String runtime = sc.nextLine();
        System.out.print("제작 연도 입력: ");
        int year = sc.nextInt();

        List<Director> filtered = new ArrayList<>();
        for (Director d : movieDB) {
            if (d.getCountry_D().equals(country)
                && d.getGenre_D().equals(genre)
                && d.getRuntime_D().equals(runtime)
                && d.getYear_D() == year) {
                filtered.add(d);
            }
        }

        if (filtered.isEmpty()) {
            System.out.println("조건에 맞는 영화 없음. 랜덤 추천:");
            randomMovie();
        } else {
            Director result = Director.recommendRandomMovie(filtered);
            System.out.println("추천 영화: " + result.getTitle_D());
        }
    }

    // 추천 2: 아무거나
    static void randomMovie() {
        Director result = Director.recommendRandomMovie(movieDB);
        System.out.println("랜덤 추천 영화: " + result.getTitle_D());
    }

    // 추천 3: 감독 별 영화 리스트
    static void listByDirector() {
        sc.nextLine();
        System.out.print("감독 이름 입력: ");
        String name = sc.nextLine();
        System.out.println("[" + name + "] 감독의 영화:");

        for (director d : movieDB) {
            if (d.getName_D().equals(name)) {
                System.out.println("- " + d.getTitle_D() + " (" + d.getYear_D() + ")");
            }
        }
    }

    // 관리자: 영화 추가
    static void addMovie() {
        Director d = new Director();
        sc.nextLine();
        System.out.print("제목: ");
        d.setTitle_D(sc.nextLine());
        System.out.print("년도: ");
        d.setYear_D(sc.nextInt());
        sc.nextLine();
        System.out.print("나라: ");
        d.setCountry_D(sc.nextLine());
        System.out.print("장편/단편: ");
        d.setRuntime_D(sc.nextLine());
        System.out.print("장르: ");
        d.setGenre_D(sc.nextLine());
        System.out.print("감독 이름: ");
        d.setName_D(sc.nextLine());

        movieDB.add(d);
        System.out.println("등록 완료!");
    }

    // 관리자: 영화 수정
    static void editMovie() {
        sc.nextLine();
        System.out.print("수정할 영화 제목: ");
        String title = sc.nextLine();
        for (Director d : movieDB) {
            if (d.getTitle_D().equals(title)) {
                System.out.print("새 제목: ");
                d.setTitle_D(sc.nextLine());
                System.out.print("새 년도: ");
                d.setYear_D(sc.nextInt());
                sc.nextLine();
                System.out.print("새 나라: ");
                d.setCountry_D(sc.nextLine());
                System.out.print("새 장편/단편: ");
                d.setRuntime_D(sc.nextLine());
                System.out.print("새 장르: ");
                d.setGenre_D(sc.nextLine());
                System.out.print("새 감독 이름: ");
                d.setName_D(sc.nextLine());
                System.out.println("수정 완료!");
                return;
            }
        }
        System.out.println("해당 영화 없음");
    }

    // 관리자: 영화 삭제
    static void deleteMovie() {
        sc.nextLine();
        System.out.print("삭제할 영화 제목: ");
        String title = sc.nextLine();
        movieDB.removeIf(d -> d.getTitle_D().equals(title));
        System.out.println("삭제 완료!");
    }

    // 샘플 데이터
    static void loadSampleMovies() {
        Director d1 = new Director();
        d1.setTitle_D("기생충");
        d1.setYear_D(2019);
        d1.setCountry_D("한국");
        d1.setRuntime_D("장편");
        d1.setGenre_D("드라마");
        d1.setName_D("봉준호");

        Director d2 = new Director();
        d2.setTitle_D("인셉션");
        d2.setYear_D(2010);
        d2.setCountry_D("미국");
        d2.setRuntime_D("장편");
        d2.setGenre_D("SF");
        d2.setName_D("크리스토퍼 놀란");

        movieDB.add(d1);
        movieDB.add(d2);
    }
}


