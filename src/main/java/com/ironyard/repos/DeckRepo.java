package com.ironyard.repos;

import com.ironyard.data.Deck;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by osmanidris on 2/23/17.
 */
public interface DeckRepo extends CrudRepository<Deck,String>{
}
