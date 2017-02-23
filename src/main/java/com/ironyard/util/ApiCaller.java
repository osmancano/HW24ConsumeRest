package com.ironyard.util;

import com.ironyard.data.Deck;
import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

/**
 * Created by osmanidris on 2/23/17.
 */
public class ApiCaller {
    RestTemplate restTemplate;
    String url;
    public ApiCaller(){
        restTemplate = new RestTemplate();
    }

    private HttpEntity getHeaders()
    {
        HttpHeaders headers = new HttpHeaders();
        headers.add("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
        HttpEntity headersEntity = new HttpEntity(headers);
        return headersEntity;
    }

    public Deck callNewDeck(){
        url = "https://deckofcardsapi.com/api/deck/new/";
        Deck deck = restTemplate.exchange(url, HttpMethod.GET,getHeaders(),Deck.class).getBody();
        return deck;
    }

    public Deck callShuffledDeck(Integer deck_count){
        url = "https://deckofcardsapi.com/api/deck/new/shuffle/?deck_count="+deck_count;
        Deck deck = restTemplate.exchange(url, HttpMethod.GET,getHeaders(),Deck.class).getBody();
        return deck;
    }

    public Deck callDrawCard(String deck_id, Integer count){
        url = "https://deckofcardsapi.com/api/deck/"+deck_id+"/draw/?count="+count;
        Deck deck = restTemplate.exchange(url, HttpMethod.GET,getHeaders(),Deck.class).getBody();
        return deck;
    }

    public Deck callReShuffle(String deck_id){
        url = "https://deckofcardsapi.com/api/deck/"+deck_id+"/shuffle/";
        Deck deck = restTemplate.exchange(url, HttpMethod.GET,getHeaders(),Deck.class).getBody();
        return deck;
    }

    public Deck callPartialDeck(String cards){
        url = "https://deckofcardsapi.com/api/deck/new/shuffle/?cards="+cards;
        Deck deck = restTemplate.exchange(url, HttpMethod.GET,getHeaders(),Deck.class).getBody();
        return deck;
    }
}
