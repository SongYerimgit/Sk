# Sk
	package com.teamsk;

	import java.io.*;
	import java.util.*;

	public class Director {
	    private static final String FILE_PATH = "File/director.csv"; // 현재 구조에 맞춘 경로

	    public void showDirectorMenu() {
	        List<String[]> movies = readCSV(FILE_PATH);
	        Set<String> directorSet = new LinkedHashSet<>();

	        for (String[] row : movies) {
	            if (row.length >= 6) {
	                directorSet.add(row[5]); // 6번째 열: 감독
	            }
	        }

	        List<String> directorList = new ArrayList<>(directorSet);
	        Scanner scanner = new Scanner(System.in);

	        System.out.println("\n🎬 감독을 선택하세요:");
	        for (int i = 0; i < directorList.size(); i++) {
	            System.out.printf("%2d. %s\n", i + 1, directorList.get(i));
	        }

	        System.out.print("감독 번호 입력: ");
	        int choice = scanner.nextInt();
	        if (choice < 1 || choice > directorList.size()) {
	            System.out.println("잘못된 번호입니다.");
	            return;
	        }

	        String selectedDirector = directorList.get(choice - 1);
	        System.out.println("\n📽️ [" + selectedDirector + "] 감독의 영화 리스트:");

	        for (String[] row : movies) {
	            if (row.length >= 6 && row[5].equals(selectedDirector)) {
	                System.out.printf(" - %s | %s | %s | %s | %s\n",
	                        row[0], row[4], row[2], row[1], row[3]);  // title, genre, country, year, runtime
	            }
	        }
	    }

	    // CSV 읽기 메서드
	    private List<String[]> readCSV(String path) {
	        List<String[]> data = new ArrayList<>();
	        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
	            String line;
	            boolean isFirst = true;

	            while ((line = br.readLine()) != null) {
	                if (isFirst) {
	                    isFirst = false; // 첫 줄 건너뛰기 (헤더)
	                    continue;
	                }
	                data.add(line.split(","));
	            }
	        } catch (IOException e) {
	            System.out.println("파일을 읽는 중 오류가 발생했습니다: " + e.getMessage());
	        }
	        return data;
	    }
	}
