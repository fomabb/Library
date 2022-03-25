package by.overone.library.service;

import by.overone.library.dto.CardDataDTO;
import by.overone.library.model.Card;

import java.util.List;

public interface CardService {

    void cardAdd(CardDataDTO cardAddDTO);

    void cardDelivery(CardDataDTO cardDTO);

    List<Card> getAllCard();

    List<CardDataDTO> getCardById(long id);

    List<CardDataDTO> getCardDelivery(long id);

    List<CardDataDTO> getCardNull();
}
