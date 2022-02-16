package by.overone.library.mapper;

import by.overone.library.model.Role;
import by.overone.library.model.Status;
import by.overone.library.model.User;
import by.overone.library.util.constant.UserConstant;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Locale;

public class UserRowMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = new User();
        user.setUser_id(rs.getLong(UserConstant.ID));
        user.setUser_login(rs.getString(UserConstant.LOGIN));
        user.setUser_password(rs.getString(UserConstant.PASSWORD));
        user.setUser_email(rs.getString(UserConstant.EMAIL));
        user.setUser_role(Role.valueOf(rs.getString(UserConstant.ROLE).toUpperCase(Locale.ROOT)));
        user.setUser_status(Status.valueOf(rs.getString(UserConstant.STATUS).toUpperCase(Locale.ROOT)));
        return user;
    }
}
