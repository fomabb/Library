package by.overone.library.service.impl;

import by.overone.library.dao.BookDAO;
import by.overone.library.dao.CardDAO;
import by.overone.library.dto.BookDataDTO;
import by.overone.library.dto.CardDTO;
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
    public void cardAdd(CardDTO cardAddDTO) {
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
    public void cardDelivery(CardDTO cardDTO) {
//        Card card1 = cardDAO.getCardReturn(cardDTO.getUsers_user_id(), cardDTO.getBooks_book_id())
//                .orElseThrow(() -> new EntityNotFoundException(ExceptionCode.NOT_EXISTING_BOOK.getErrorCode()));
//        log.info(card1.toString());
//        if (card1.getDelivery_date() == null) {
        Card card = new Card();
        card.setUsers_user_id(cardDTO.getUsers_user_id());
        card.setBooks_book_id(cardDTO.getBooks_book_id());
        card.setDate_of_receiving(null);
        card.setDelivery_date(LocalDateTime.now());
        cardDAO.cardDelivery(card);
        log.info(card.toString());
        BookDataDTO book = bookService.getBookById(cardDTO.getBooks_book_id());
        bookDAO.updateBookCounter(cardDTO.getBooks_book_id(), book.getBook_count() + 1);
//            log.info("1");
//        } else {
//            throw new RuntimeException(cardDTO + "Books is return");
//        }
    }

    @Override
    public List<Card> getAllCard() {
        return cardDAO.getAllCard();
    }

    @Override
    public List<CardDTO> getCardById(long id) {
        return cardDAO.getCardById(id);
    }

    @Override
    public List<CardDTO> getCardDelivery(long id) {
        return cardDAO.getCardDelivery(id);
    }

    @Override
    public List<CardDTO> getCardNull() {
        return cardDAO.getCardNull();
    }
}
