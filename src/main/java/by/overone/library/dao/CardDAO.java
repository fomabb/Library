package by.overone.library.dao;

import by.overone.library.dto.CardDataDTO;
import by.overone.library.model.Card;

import java.util.List;
import java.util.Optional;

public interface CardDAO {

    void cardAdd(Card card);

    void cardDelivery(Card card);

    List<Card> getAllCard();

    List<CardDataDTO> getCardById(long id);

    List<CardDataDTO> getCardDelivery(long id);

    List<CardDataDTO> getCardNull();

    Optional<Card> getCardReturn(long user_id, long book_id);
}
