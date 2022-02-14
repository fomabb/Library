package by.overone.library.dao;

import by.overone.library.dto.UserGetByBooks;
import by.overone.library.model.User;

public interface Card{

    User getByBooks(long id, UserGetByBooks userGetByBooks);
}
