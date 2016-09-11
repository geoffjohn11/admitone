package com.admitone.repository;
import com.admitone.model.UsernameShowIdPK;
import com.admitone.model.Purchase;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by gjohnson on 9/10/16.
 */
public interface PurchaseRepository extends CrudRepository<Purchase, UsernameShowIdPK> {

    @Query("select p from Purchase p where p.usernameShowIdPK.showId >= ?1 and p.usernameShowIdPK.showId <= ?2")
    List<Purchase> findByShowIdRange(Long fromShowId, Long toShowId);
}
