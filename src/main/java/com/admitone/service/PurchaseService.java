package com.admitone.service;

import com.admitone.model.Purchase;
import com.admitone.model.UsernameShowIdPK;


import java.util.List;

/**
 * Created by gjohnson on 9/10/16.
 */


public interface PurchaseService {
    void save(Purchase purchase);
    Purchase fetchByUsernameAndShowIdPK(UsernameShowIdPK pk);
     Purchase updateTicketCount(Purchase purchase, int ticketCount);
    void delete(Purchase purchase);
    Purchase processPurchase(Purchase purchase);
    List<Purchase> fetchByShowIdRange(Long fromShowId, Long toShowId);
}