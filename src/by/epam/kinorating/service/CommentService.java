package by.epam.kinorating.service;

import by.epam.kinorating.dao.impl.CommentDAO;
import by.epam.kinorating.entity.Comment;
import by.epam.kinorating.exception.DAOException;
import by.epam.kinorating.exception.ServiceException;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by Диана и Глеб on 22.08.2016.
 */
public class CommentService {

    public static List<Comment> findCommentsByFilmId(long filmId) throws ServiceException {
        try {
            return new CommentDAO().findByFilmId(filmId);
        } catch (DAOException e) {
            throw new ServiceException("Invalid service operation occurred during getting comments", e);
        }
    }

    public static void addComment (long filmId, long userId, String text) throws ServiceException {
        Comment comment = new Comment(filmId, userId, text);
        comment.setDateTime(LocalDateTime.now());
        try {
            new CommentDAO().add(comment);
        } catch (DAOException e) {
            throw new ServiceException("Invalid service operation occurred during adding comment", e);
        }
    }

    public static Comment findCommentById (long commentId) throws ServiceException {
        try {
            return new CommentDAO().findById(commentId);
        } catch (DAOException e) {
            throw  new ServiceException("Invalid operation occurred during finding comment by ID", e);
        }
    }

    public static void editComment (Comment comment) throws ServiceException {
        long commentId = comment.getCommentId();
        try {
            new CommentDAO().updateById(commentId, comment);
        } catch (DAOException e) {
            throw new ServiceException("Invalid operation occurred during updating comment", e);
        }
    }

    public static void delComment (long commentId) throws ServiceException {
        try {
            new CommentDAO().deleteById(commentId);
        } catch (DAOException e) {
            throw new ServiceException("Invalid operation occurred during deleting comment by ID", e);
        }
    }

    public static List<Comment> findAllComments () throws ServiceException {
        try {
            return new CommentDAO().findAll();
        } catch (DAOException e) {
            throw new ServiceException("Invalid operation occurred in comment service in findAllComments method", e);
        }
    }

}
