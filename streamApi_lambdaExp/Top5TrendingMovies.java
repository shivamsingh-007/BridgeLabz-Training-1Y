import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Top5TrendingMovies {

    public static void main(String[] args) {
        List<Movie> movies = Arrays.asList(
                new Movie("Nova", 8.9, 2024),
                new Movie("Orbit", 8.4, 2023),
                new Movie("Zenith", 9.1, 2024),
                new Movie("Pulse", 8.7, 2022),
                new Movie("Echo", 8.8, 2023),
                new Movie("Vista", 9.0, 2021),
                new Movie("Drift", 8.6, 2024)
        );

        movies.stream()
                .filter(movie -> movie.getRating() >= 8.5)
                .sorted((m1, m2) -> {
                    int ratingCompare = Double.compare(m2.getRating(), m1.getRating());
                    if (ratingCompare != 0) {
                        return ratingCompare;
                    }
                    return Integer.compare(m2.getReleaseYear(), m1.getReleaseYear());
                })
                .limit(5)
                .forEach(System.out::println);
    }
}
