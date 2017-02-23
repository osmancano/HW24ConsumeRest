package com.ironyard.controllers.mvc;

import com.ironyard.data.Deck;
import com.ironyard.repos.CardRepo;
import com.ironyard.repos.DeckRepo;
import com.ironyard.util.ApiCaller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * Created by osmanidris on 2/23/17.
 */
@Controller
public class CardController {
    @Autowired
    DeckRepo deckRepo;

    @Autowired
    CardRepo cardRepo;

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String home(){
        return "/home";
    }
    @RequestMapping(path = "/mvc/cards/drawcard", method = RequestMethod.GET)
    public String newDeck(Model model,HttpSession session,
                          @RequestParam(required = false) String deck_id,
                          @RequestParam(required = false) Integer count) {
        if(deck_id == null || deck_id.equals("")){
            deck_id = "new";
        }
        if(count == null){
            count = 1;
        }
        Deck cardDeck = (new ApiCaller()).callDrawCard(deck_id,count);
        session.setAttribute("deck_id",cardDeck.getDeck_id());
        deckRepo.save(cardDeck);
        model.addAttribute("cardDeck", cardDeck);
        return "/home";
    }
}
