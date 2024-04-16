package com.example.day11.exam4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Movie implements Comparable<Movie> {

    private String title;
    private int year;
    private double score;

    public Movie(String title, int year, double score) {
        this.title = title;
        this.year = year;
        this.score = score;
    }

    public int getYear() {
        return year;
    }

    public double getScore() {
        return score;
    }

    @Override
    public String toString() {
        return title + ", " + year + ", " + score;
    }

    @Override
    public int compareTo(Movie o) {
        return title.compareTo(o.title);
    }
}

class RatingComparator implements Comparator<Movie> {

    @Override
    public int compare(Movie o1, Movie o2) {
        if (o1.getScore() > o2.getScore()) {
            return 1;
        } else if (o1.getScore() < o2.getScore()) {
            return -1;
        } else {
            return 0;
        }
    }
}

class ReleaseYearComparator implements Comparator<Movie> {

    @Override
    public int compare(Movie o1, Movie o2) {
        return o1.getYear() - o2.getYear();
    }
}

public class MovieManager {
    public static void main(String[] args) {
        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie("The Shawshank Redemption", 1994, 9.3));
        movies.add(new Movie("The Godfather", 1972, 9.2));
        movies.add(new Movie("The Dark Knight", 2008, 9.0));

        // 제목 기준 정렬 (Comparable)
        Collections.sort(movies);
        System.out.println("Sorted by title:");
        movies.forEach(System.out::println);

        // 평점 기준 정렬 (Comparator)
        Collections.sort(movies, new RatingComparator());
        System.out.println("Sorted by rating:");
        movies.forEach(System.out::println);

        // 출시 연도 기준 정렬 (Comparator)
        Collections.sort(movies, new ReleaseYearComparator());
        System.out.println("Sorted by release year:");
        movies.forEach(System.out::println);
    }
}

