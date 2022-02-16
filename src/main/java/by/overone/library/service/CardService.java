package by.overone.library.service;

import by.overone.library.dto.CardDTO;
import by.overone.library.model.Card;

import java.util.List;

public interface CardService {

    void cardAdd(CardDTO cardAddDTO);

    List<Card> getAllCard();

    void cardDelivery(CardDTO cardDTO);
}
