package by.overone.library.dao;

import by.overone.library.dto.CardDTO;
import by.overone.library.model.Card;

import java.util.List;
import java.util.Optional;

public interface CardDAO {

    void cardAdd(Card card);

    void cardDelivery(Card card);

    List<Card> getAllCard();

    List<CardDTO> getCardById(long id);

    List<CardDTO> getCardDelivery(long id);

    List<CardDTO> getCardNull();

    Optional<Card> getCardReturn(long user_id, long book_id);
}
