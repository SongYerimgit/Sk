
import java.util.*;

public class Director {
    private String title_D;   // 영화 제목
    private int year_D;       // 영화 연도
    private String country_D; // 나라
    private boolean runtime_D; // 장편(true)/단편(false)
    private String genre_D;   // 영화 장르
    private String name_D;    // 감독 이름

    // 생성자
    public Director(String title, int year, String country, boolean runtime, String genre, String name) {
        this.title_D = title;
        this.year_D = year;
        this.country_D = country;
        this.runtime_D = runtime;
        this.genre_D = genre;
        this.name_D = name;
    }

    // Getter 메서드들
    public String getTitle_D() { return title_D; }
    public int getYear_D() { return year_D; }
    public String getCountry_D() { return country_D; }
    public boolean getRuntime_D() { return runtime_D; }
    public String getGenre_D() { return genre_D; }
    public String getName_D() { return name_D; }

    // Setter 메서드들
    public void setTitle_D(String title) { this.title_D = title; }
    public void setYear_D(int year) { this.year_D = year; }
    public void setCountry_D(String country) { this.country_D = country; }
    public void setRuntime_D(boolean runtime) { this.runtime_D = runtime; }
    public void setGenre_D(String genre) { this.genre_D = genre; }
    public void setName_D(String name) { this.name_D = name; }

    // 랜덤 영화 추천 메서드
    public static Director recommendRandomMovie(List<Director> directors) {
        if (directors == null || directors.isEmpty()) return null;
        Random rand = new Random();
        return directors.get(rand.nextInt(directors.size()));
    }

    // toString 오버라이딩
    @Override
    public String toString() {
        return "🎬 제목: " + title_D + ", 연도: " + year_D + ", 나라: " + country_D + 
               ", 장르: " + genre_D + ", 감독: " + name_D + 
               ", 유형: " + (runtime_D ? "장편" : "단편");
    }

    // 테스트용 main 함수
    public static void main(String[] args) {
        List<Director> movies = new ArrayList<>();
        movies.add(new Director("기생충", 2019, "한국", true, "드라마", "봉준호"));
        movies.add(new Director("인셉션", 2010, "미국", true, "SF", "크리스토퍼 놀란"));
        movies.add(new Director("반도", 2020, "한국", true, "액션", "연상호"));

        Director randomMovie = recommendRandomMovie(movies);
        System.out.println("추천 영화:");
        System.out.println(randomMovie);
    }
}
