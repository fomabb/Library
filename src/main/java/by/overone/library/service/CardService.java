package by.overone.library.service;

import by.overone.library.dto.CardDTO;
import by.overone.library.model.Card;

import java.util.List;

public interface CardService {

    void cardAdd(CardDTO cardAddDTO);

    void cardDelivery(CardDTO cardDTO);

    List<Card> getAllCard();

    List<CardDTO> getCardById(long id);

    List<CardDTO> getCardDelivery(long id);
}
