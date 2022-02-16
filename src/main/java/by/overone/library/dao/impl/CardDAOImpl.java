package by.overone.library.dao.impl;

import by.overone.library.dao.CardDAO;
import by.overone.library.mapper.CardRowMapper;
import by.overone.library.model.Card;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Slf4j
@Repository
@RequiredArgsConstructor
public class CardDAOImpl implements CardDAO {

    private final String ADD_CARD_SQL = "INSERT INTO card VALUES(?,?,?,?)";
    private final String GET_CARD_SQL = "SELECT * FROM card";
    private final String DELIVERY_CARD_SQL = "UPDATE card SET delivery_date=? WHERE users_user_id=? AND books_book_id=?";

    private final JdbcTemplate jdbcTemplate;

    @Override
    public void cardAdd(Card card) {
        jdbcTemplate.update(ADD_CARD_SQL, card.getUsers_user_id(), card.getBooks_book_id(),
                card.getDate_of_receiving(), card.getDelivery_date());
    }

    @Override
    public List<Card> getAllCard() {
        return jdbcTemplate.query(GET_CARD_SQL, new CardRowMapper());
    }


    @Override
    public void cardDelivery(Card card) {
        jdbcTemplate.update(DELIVERY_CARD_SQL, card.getDelivery_date(), card.getUsers_user_id(),
                card.getBooks_book_id());
    }

//    @Override
//    public List<Card> getAllCard(CardDTO cardDTO) {
//        String sql = "SELECT * FROM card ";
//        if (cardDTO.getUsers_user_id() != 0 && cardDTO.getBooks_book_id() != 0) {
//            sql = sql + "WHERE users_user_id=" + cardDTO.getUsers_user_id() + " AND books_book_id="
//                    + cardDTO.getBooks_book_id();
//        }
//        if (cardDTO.getUsers_user_id() != 0 && cardDTO.getBooks_book_id() == 0) {
//            sql = sql + "WHERE users_user_id=" + cardDTO.getUsers_user_id();
//        }
//        if (cardDTO.getUsers_user_id() == 0 && cardDTO.getBooks_book_id() != 0) {
//            sql = sql + "WHERE books_book_id=" + cardDTO.getBooks_book_id();
//        }
//        return jdbcTemplate.query(sql, new Object[]{}, new CardRowMapper());
//    }
}
