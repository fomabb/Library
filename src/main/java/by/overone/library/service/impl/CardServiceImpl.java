package by.overone.library.service.impl;

import by.overone.library.dao.CardDAO;
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
    public List<Card> getAllCard() {
        return cardDAO.getAllCard();
    }

    @Override
    public void cardDelivery(CardDTO cardDTO) {
        Card card = new Card();
        card.setUsers_user_id(cardDTO.getUsers_user_id());
        card.setBooks_book_id(cardDTO.getBooks_book_id());
        card.setDate_of_receiving(null);
        card.setDelivery_date(LocalDateTime.now());
        cardDAO.cardDelivery(card);
    }
}
