public class Movie {
    private final String title;
    private final double rating;
    private final int releaseYear;

    public Movie(String title, double rating, int releaseYear) {
        this.title = title;
        this.rating = rating;
        this.releaseYear = releaseYear;
    }

    public double getRating() {
        return rating;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public String toString() {
        return title + " | rating=" + rating + " | year=" + releaseYear;
    }
}
