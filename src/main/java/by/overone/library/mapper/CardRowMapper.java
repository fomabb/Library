package by.overone.library.mapper;

import by.overone.library.model.Card;
import by.overone.library.util.constant.CardConstant;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class CardRowMapper implements RowMapper<Card> {

    @Override
    public Card mapRow(ResultSet rs, int rowNum) throws SQLException {
        Card card = new Card();
        card.setUsers_user_id(rs.getLong(CardConstant.ID_USER));
        card.setBooks_book_id(rs.getLong(CardConstant.ID_BOOKS));
        card.setDate_of_receiving(LocalDateTime.parse((rs.getString(CardConstant.RECEIVING))));
        card.setDelivery_date(LocalDateTime.parse(rs.getString(CardConstant.DELIVERY)));
        return card;
    }
}
