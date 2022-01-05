package by.overone.library.dao.mapper;

import by.overone.library.dto.UserDetailsDTO;
import by.overone.library.util.constant.UserConstant;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDetailsRowMapper implements RowMapper<UserDetailsDTO> {

    @Override
    public UserDetailsDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
        UserDetailsDTO userDetailsDTO = new UserDetailsDTO();
        userDetailsDTO.setUser_details_name(rs.getString(UserConstant.NAME));
        userDetailsDTO.setUser_details_surname(rs.getString(UserConstant.SURNAME));
        userDetailsDTO.setUser_details_address(rs.getString(UserConstant.ADDRESS));
        userDetailsDTO.setUser_details_phonenumber(rs.getString(UserConstant.PHONE));
        userDetailsDTO.setUsers_user_id(rs.getLong(UserConstant.USER_DETAILS_ID));
        return userDetailsDTO;
    }
}
