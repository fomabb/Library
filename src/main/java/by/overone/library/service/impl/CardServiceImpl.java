package by.overone.library.service.impl;

import by.overone.library.dao.BookDAO;
import by.overone.library.dao.CardDAO;
import by.overone.library.dto.BookDataDTO;
import by.overone.library.dto.CardDataDTO;
import by.overone.library.exception.EntityNotFoundException;
import by.overone.library.exception.ExceptionCode;
import by.overone.library.model.Card;
import by.overone.library.service.BookService;
import by.overone.library.service.CardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CardServiceImpl implements CardService {

    private final CardDAO cardDAO;
    private final BookDAO bookDAO;
    private final BookService bookService;

    @Transactional
    @Override
    public void cardAdd(CardDataDTO cardAddDTO) {
        Card card = new Card();
        card.setBooks_book_id(cardAddDTO.getBooks_book_id());
        card.setUsers_user_id(cardAddDTO.getUsers_user_id());
        card.setDate_of_receiving(LocalDateTime.now());
        card.setDelivery_date(null);
        cardDAO.cardAdd(card);
        BookDataDTO book = bookService.getBookByIdActive(cardAddDTO.getBooks_book_id());
        bookDAO.updateBookCounter(cardAddDTO.getBooks_book_id(), book.getBook_count() - 1);
    }

    @Transactional
    @Override
    public void cardDelivery(CardDataDTO cardDTO) {
        Card cardReturn = cardDAO.getCardReturn(cardDTO.getUsers_user_id(), cardDTO.getBooks_book_id())
                .orElseThrow(() -> new EntityNotFoundException(ExceptionCode.NOT_EXISTING_BOOK.getErrorCode()));

//        if (cardReturn.getDelivery_date() == null) {
//        log.info(cardReturn.toString());

        cardReturn.setUsers_user_id(cardDTO.getUsers_user_id());
        cardReturn.setBooks_book_id(cardDTO.getBooks_book_id());
        cardReturn.setDate_of_receiving(null);
        cardReturn.setDelivery_date(LocalDateTime.now());
        cardDAO.cardDelivery(cardReturn);
        log.info(cardReturn.toString());
        BookDataDTO book = bookService.getBookById(cardDTO.getBooks_book_id());
        bookDAO.updateBookCounter(cardDTO.getBooks_book_id(), book.getBook_count() + 1);
//            log.info("1");
//        } else {
//            throw new RuntimeException("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
//        }
    }

    @Override
    public List<Card> getAllCard() {
        return cardDAO.getAllCard();
    }

    @Override
    public List<CardDataDTO> getCardById(long id) {
        return cardDAO.getCardById(id);
    }

    @Override
    public List<CardDataDTO> getCardDelivery(long id) {
        return cardDAO.getCardDelivery(id);
    }

    @Override
    public List<CardDataDTO> getCardNull() {
        return cardDAO.getCardNull();
    }
}
