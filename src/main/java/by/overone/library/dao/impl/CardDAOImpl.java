package by.overone.library.dao.impl;

import by.overone.library.dao.CardDAO;
import by.overone.library.dto.CardDataDTO;
import by.overone.library.mapper.CardRowMapper;
import by.overone.library.model.Card;
import by.overone.library.model.CardNullDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Slf4j
@Repository
@RequiredArgsConstructor
public class CardDAOImpl implements CardDAO {

    private final String ADD_CARD_SQL = "INSERT INTO card VALUES(?,?,?,?)";
    private final String GET_CARD_SQL = "SELECT * FROM card";
    private final String DELIVERY_CARD_SQL = "UPDATE card SET delivery_date=? WHERE users_user_id=? AND books_book_id=?";
    private final String GET_BY_ID_SQL = "SELECT * FROM card WHERE users_user_id=?";
    private final String GET_CARD_FOR_DELIVERY_IS_NULL = "SELECT * FROM card WHERE books_book_id=? AND delivery_date IS NULL";
    private final String GET_CARD_FOR_DELIVERY_NULL = "SELECT * FROM card WHERE delivery_date IS NULL";
    private final String GET_CARD_RETURN_SQL = "SELECT * FROM card WHERE users_user_id=? AND books_book_id=?";

    private final JdbcTemplate jdbcTemplate;

    @Override
    public void cardAdd(Card card) {
        jdbcTemplate.update(ADD_CARD_SQL, card.getUsers_user_id(), card.getBooks_book_id(),
                card.getDate_of_receiving(), card.getDelivery_date());
    }

    @Override
    public void cardDelivery(Card card) {
        jdbcTemplate.update(DELIVERY_CARD_SQL, card.getDelivery_date(), card.getUsers_user_id(),
                card.getBooks_book_id());
    }

    @Override
    public List<Card> getAllCard() {
        return jdbcTemplate.query(GET_CARD_SQL, new CardRowMapper());
    }

    @Override
    public List<CardDataDTO> getCardById(long id) {
        return jdbcTemplate.query(GET_BY_ID_SQL, new Object[]{id}, new BeanPropertyRowMapper<>(CardDataDTO.class));
    }

    @Override
    public List<CardDataDTO> getCardDelivery(long id) {
        return jdbcTemplate.query(GET_CARD_FOR_DELIVERY_IS_NULL, new Object[]{id},
                new BeanPropertyRowMapper<>(CardDataDTO.class));
    }

    @Override
    public List<CardNullDTO> getCardNull() {
        return jdbcTemplate.query(GET_CARD_FOR_DELIVERY_NULL, new BeanPropertyRowMapper<>(CardNullDTO.class));
    }

    @Override
    public Optional<Card> getCardReturn(long user_id, long book_id) {
        return jdbcTemplate.query(GET_CARD_RETURN_SQL, new Object[]{user_id, book_id},
                        new BeanPropertyRowMapper<>(Card.class))
                .stream()
                .findAny();
    }
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

