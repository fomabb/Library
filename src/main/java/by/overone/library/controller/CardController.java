package by.overone.library.controller;

import by.overone.library.dto.CardDataDTO;
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
    public void cardAdd(@Validated @RequestBody CardDataDTO cardDTO) {
        cardService.cardAdd(cardDTO);
    }

    @PutMapping
    public void cardDelivery(@Validated @RequestBody CardDataDTO cardDTO) {
        cardService.cardDelivery(cardDTO);
    }

    @GetMapping
    public List<Card> cards() {
        return cardService.getAllCard();
    }


    @GetMapping("/{id}")
    public List<CardDataDTO> getCardById(@Validated @PathVariable long id) {
        return cardService.getCardById(id);
    }

    @GetMapping("del/{id}")
    public List<CardDataDTO> getCardDelivery(@PathVariable long id) {
        return cardService.getCardDelivery(id);
    }

    @GetMapping("/null")
    public List<CardDataDTO> getCardNull() {
        return cardService.getCardNull();
    }
}
