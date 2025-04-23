import java.util.*;

public class Director {
    private String title_D;
    private int year_D;
    private String country_D;
    private boolean runtime_D;
    private String genre_D;
    private String name_D;

    public Director(String title, int year, String country, boolean runtime, String genre, String name) {
        this.title_D = title;
        this.year_D = year;
        this.country_D = country;
        this.runtime_D = runtime;
        this.genre_D = genre;
        this.name_D = name;
    }

    // Getter methods...
    public String getGenre_D() { return genre_D; }
    public String getTitle_D() { return title_D; }
    public String getCountry_D() { return country_D; }

    @Override
    public String toString() {
        return "제목: " + title_D + ", 장르: " + genre_D + ", 국가: " + country_D;
    }

    // 🎯 장르별 추천 메서드
    public static Director recommendByGenre(List<Director> list, String genre) {
        List<Director> filtered = new ArrayList<>();
        for (Director d : list) {
            if (d.getGenre_D().equalsIgnoreCase(genre)) {
                filtered.add(d);
            }
        }
        if (filtered.isEmpty()) return null;
        return filtered.get(new Random().nextInt(filtered.size()));
    }

    public static void main(String[] args) {
        List<Director> movies = Arrays.asList(
            new Director("기생충", 2019, "한국", true, "드라마", "봉준호"),
            new Director("인셉션", 2010, "미국", true, "SF", "놀란"),
            new Director("반도", 2020, "한국", true, "액션", "연상호")
        );

        // 장르별 추천 예시
        String genreWanted = "SF";  // 원하는 장르 입력
        Director recommended = recommendByGenre(movies, genreWanted);

        if (recommended != null) {
            System.out.println("🎯 " + genreWanted + " 장르 추천 영화:");
            System.out.println(recommended);
        } else {
            System.out.println("해당 장르의 영화가 없습니다.");
        }
    }
}
