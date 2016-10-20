package by.epam.kinorating.entity;

import java.time.LocalDateTime;

/**
 * Created by Диана и Глеб on 06.08.2016.
 */
public class Comment {
    private long commentId;
    private long userId;
    private String userName;
    private long filmId;
    private String text;
    private LocalDateTime dateTime;

    public Comment() {
    }

    public Comment(long commentId, String text) {
        this.commentId = commentId;
        this.text = text;
    }

    public Comment(long filmId, long userId, String text) {
        this.filmId = filmId;
        this.userId = userId;
        this.text = text;
    }

    public long getCommentId() {
        return commentId;
    }
    public void setCommentId(long commentId) {
        this.commentId = commentId;
    }
    public long getUserId() {
        return userId;
    }
    public void setUserId(long userId) {
        this.userId = userId;
    }
    public long getFilmId() {
        return filmId;
    }
    public void setFilmId(long filmId) {
        this.filmId = filmId;
    }
    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public LocalDateTime getDateTime() {
        return dateTime;
    }
    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
}
