package by.overone.library.service;

import by.overone.library.dto.CardDataDTO;
import by.overone.library.model.Card;
import by.overone.library.dto.CardNullDTO;

import java.util.List;

public interface CardService {

    void cardAdd(CardDataDTO cardAddDTO);

    void cardDelivery(CardDataDTO cardDTO);

    List<Card> getAllCard();

    List<CardNullDTO> getCardById(long id);

    List<CardDataDTO> getCardDelivery(long id);

    List<CardNullDTO> getCardNull();
}
