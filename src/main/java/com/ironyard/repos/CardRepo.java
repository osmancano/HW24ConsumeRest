package com.ironyard.repos;

import com.ironyard.data.Card;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by osmanidris on 2/23/17.
 */
public interface CardRepo extends CrudRepository<Card, String>{
}
