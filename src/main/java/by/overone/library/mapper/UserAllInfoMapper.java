package by.overone.library.mapper;

import by.overone.library.dto.UserFullInfoDTO;
import by.overone.library.model.Role;
import by.overone.library.model.Status;
import by.overone.library.util.constant.UserConstant;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Locale;

public class UserAllInfoMapper implements RowMapper<UserFullInfoDTO> {
    @Override
    public UserFullInfoDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
        UserFullInfoDTO userFullInfo = new UserFullInfoDTO();
        userFullInfo.setUser_id(rs.getLong(UserConstant.ID));
        userFullInfo.setUser_login(rs.getString(UserConstant.LOGIN));
        userFullInfo.setUser_password(rs.getString(UserConstant.PASSWORD));
        userFullInfo.setUser_email(rs.getString(UserConstant.EMAIL));
        userFullInfo.setUser_role(Role.valueOf(rs.getString(UserConstant.ROLE).toUpperCase(Locale.ROOT)));
        userFullInfo.setUser_status(Status.valueOf(rs.getString(UserConstant.STATUS).toUpperCase(Locale.ROOT)));
        userFullInfo.setUser_details_name(rs.getString(UserConstant.NAME));
        userFullInfo.setUser_details_surname(rs.getString(UserConstant.SURNAME));
        userFullInfo.setUser_details_address(rs.getString(UserConstant.ADDRESS));
        userFullInfo.setUser_details_phonenumber(rs.getString(UserConstant.PHONE));
        userFullInfo.setUsers_user_id(rs.getLong(UserConstant.USER_DETAILS_ID));
        return userFullInfo;
    }
}
