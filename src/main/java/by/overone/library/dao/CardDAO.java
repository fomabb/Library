package by.overone.library.dao;

import by.overone.library.dto.CardDTO;
import by.overone.library.model.Card;

import java.util.List;

public interface CardDAO {

   void cardAdd(Card card);

   List<Card> getAllCard();

   void cardDelivery(Card card);


}
