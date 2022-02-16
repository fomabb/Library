package by.overone.library.controller;

import by.overone.library.dto.CardDTO;
import by.overone.library.model.Card;
import by.overone.library.service.CardService;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@AllArgsConstructor
@RequestMapping("/api/card")
public class CardController {

    private final CardService cardService;

    @PostMapping
    public void cardAdd(@Validated @RequestBody CardDTO cardDTO) {
        cardService.cardAdd(cardDTO);
    }

    @GetMapping
    public List<Card> cards() {
        return cardService.getAllCard();
    }

    @PutMapping
    public void cardDelivery(@Validated @RequestBody CardDTO cardDTO) {
        cardService.cardDelivery(cardDTO);
    }
}
