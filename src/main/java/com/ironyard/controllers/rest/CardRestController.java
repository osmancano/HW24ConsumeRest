package com.ironyard.controllers.rest;

import com.ironyard.data.Deck;
import com.ironyard.util.ApiCaller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by osmanidris on 2/23/17.
 */
@RestController
public class CardRestController {
    String apiUrl;
    @RequestMapping(path = "/rest/cards/new", method = RequestMethod.GET)
    public Deck newDeck() {
        return (new ApiCaller()).callNewDeck();
    }

    @RequestMapping(path = "/rest/cards/shuffle", method = RequestMethod.GET)
    public Deck shuffle(@RequestParam(required = false) Integer deck_count) {
        if(deck_count == null){
            deck_count = 1;
        }
        return (new ApiCaller()).callShuffledDeck(deck_count);
    }

    @RequestMapping(path = "/rest/cards/drawcard", method = RequestMethod.GET)
    public Deck drawCard(@RequestParam(required = false) String deck_id,
                         @RequestParam(required = false) Integer count) {
        if(deck_id == null || deck_id.equals("")){
            deck_id = "new";
        }
        if(count == null){
            count = 2;
        }
        return (new ApiCaller()).callDrawCard(deck_id,count);
    }

    @RequestMapping(path = "/rest/cards/reshuffle", method = RequestMethod.GET)
    public Deck reshuffle(@RequestParam String deck_id){
        return (new ApiCaller()).callReShuffle(deck_id);
    }

    @RequestMapping(path = "/rest/cards/partialDeck", method = RequestMethod.GET)
    public Deck partialDeck(@RequestParam String cards){
        return (new ApiCaller()).callPartialDeck(cards);
    }

}
