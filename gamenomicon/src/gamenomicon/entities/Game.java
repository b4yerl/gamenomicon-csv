package gamenomicon.entities;

import java.util.Objects;

public class Game implements Comparable<Game> {
    private String title;
    private String review;
    private int score;

    private int publishingYear;

    public Game(String title, String review, int score, int publishingYear) {
        this.title = title;
        this.review = review;
        this.score = score;
        this.publishingYear = publishingYear;
    }

    public String getTitle() {
        return title;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        if(score >= 0 && score <= 5) {
            this.score = score;
        }
        else {
            System.out.println("Please provide a number between 0 and 5.");
        }
    }

    public int getPublishingYear() {
        return publishingYear;
    }

    public void setPublishingYear(int publishingYear) {
        this.publishingYear = publishingYear;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return Objects.equals(getTitle(), game.getTitle());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTitle());
    }

    @Override
    public int compareTo(Game game) {
        return this.getTitle().compareToIgnoreCase(game.getTitle());
    }

    @Override
    public String toString() {
        return this.getTitle() + "\n" + "Score: " + this.getScore() +
                this.getReview();
    }
}
