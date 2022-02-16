package by.overone.library.service.impl;

import by.overone.library.dao.CardDAO;
import by.overone.library.dao.mapper.CardRowMapper;
import by.overone.library.dto.CardDTO;
import by.overone.library.model.Card;
import by.overone.library.service.CardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CardServiceImpl implements CardService {

    private final CardDAO cardDAO;

    @Override
    public void cardAdd(CardDTO cardAddDTO) {
        Card card = new Card();
        card.setBooks_book_id(cardAddDTO.getBooks_book_id());
        card.setUsers_user_id(cardAddDTO.getUsers_user_id());
        card.setDate_of_receiving(LocalDateTime.now());
        card.setDelivery_date(null);
        cardDAO.cardAdd(card);
    }

    @Override
    public List<Card> getAllCard(CardDTO cardDTO) {
        String sql = "SELECT * FROM card";
        if (cardDTO.getUsers_user_id() != 0 && cardDTO.getBooks_book_id() != 0) {
            sql = sql + "WHERE users_user_id=" + cardDTO.getUsers_user_id() + "AND books_book_id="
                    + cardDTO.getBooks_book_id();
        }
        if (cardDTO.getUsers_user_id() != 0 && cardDTO.getBooks_book_id() == 0) {
            sql = sql + "WHERE users_user_id=" + cardDTO.getUsers_user_id();
        }
        if (cardDTO.getUsers_user_id() == 0 && cardDTO.getBooks_book_id() != 0) {
            sql = sql + "WHERE books_book_id=" + cardDTO.getBooks_book_id();
        }
        return cardDAO.getAllCard(sql, new Object[]{}, new CardRowMapper(Card.class));
    }

    @Override
    public void cardDelivery(CardDTO cardDTO) {
        Card card = new Card();
        card.setUsers_user_id(cardDTO.getUsers_user_id());
        card.setBooks_book_id(cardDTO.getBooks_book_id());
        card.setDate_of_receiving(null);
        card.setDelivery_date(LocalDateTime.now());
        System.out.println(card.toString());
        cardDAO.cardDelivery(card);
    }
}
