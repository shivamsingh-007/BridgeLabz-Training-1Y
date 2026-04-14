package com.gla.collectionframework;

import java.util.*;

public class StreamingWatchHistory {
    private Stack<Movie> watchHistory;
    private List<Movie> watchList;
    private Set<String> watchedMovieIds;
    private Queue<Movie> continueWatching;

    public StreamingWatchHistory() {
        this.watchHistory = new Stack<>();
        this.watchList = new ArrayList<>();
        this.watchedMovieIds = new HashSet<>();
        this.continueWatching = new LinkedList<>();
    }

    public void addToWatchList(Movie movie) {
        watchList.add(movie);
    }

    public void startWatching(Movie movie) {
        continueWatching.offer(movie);
    }

    public void finishWatching(Movie movie) {
        continueWatching.remove(movie);
        watchedMovieIds.add(movie.getMovieId());
        watchHistory.push(movie);
    }

    public Movie goBack() {
        if (watchHistory.size() > 1) {
            watchHistory.pop();
            return watchHistory.peek();
        }
        return null;
    }

    public List<Movie> getRecentlyWatched(int count) {
        List<Movie> recent = new ArrayList<>();
        int size = watchHistory.size();
        for (int i = size - 1; i >= Math.max(0, size - count); i--) {
            recent.add(watchHistory.get(i));
        }
        return recent;
    }

    public Set<String> getWatchedMovieIds() {
        return watchedMovieIds;
    }

    public List<Movie> getWatchList() {
        return watchList;
    }

    public Queue<Movie> getContinueWatching() {
        return continueWatching;
    }

    public static void main(String[] args) {
        StreamingWatchHistory history = new StreamingWatchHistory();
        Movie m1 = new Movie("MV001", "Action Movie");
        Movie m2 = new Movie("MV002", "Comedy Movie");
        Movie m3 = new Movie("MV003", "Drama Movie");
        history.addToWatchList(m1);
        history.addToWatchList(m2);
        history.startWatching(m1);
        history.finishWatching(m1);
        history.startWatching(m3);
        history.finishWatching(m3);
        System.out.println("Watched: " + history.getWatchedMovieIds());
        System.out.println("Continue: " + history.getContinueWatching());
        System.out.println("Recent: " + history.getRecentlyWatched(2));
    }
}

class Movie {
    private String movieId;
    private String title;

    public Movie(String movieId, String title) {
        this.movieId = movieId;
        this.title = title;
    }

    public String getMovieId() { return movieId; }
    public String getTitle() { return title; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return Objects.equals(movieId, movie.movieId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(movieId);
    }

    @Override
    public String toString() {
        return title;
    }
}
