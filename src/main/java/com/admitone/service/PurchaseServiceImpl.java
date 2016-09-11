package com.admitone.service;

import com.admitone.model.Purchase;
import com.admitone.model.UsernameShowIdPK;
import com.admitone.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by gjohnson on 9/10/16.
 */

@Service
@Transactional
public class PurchaseServiceImpl implements PurchaseService {

    @Autowired
    private PurchaseRepository purchaseRepository;

    public void save(Purchase purchase){
        purchaseRepository.save(purchase);
    }

    public Purchase fetchByUsernameAndShowIdPK(UsernameShowIdPK pk){
        return purchaseRepository.findOne(pk);
    }

    public Purchase updateTicketCount(Purchase purchase, int ticketCount){
        purchase.setTicketCount(ticketCount);
        save(purchase);
        return purchase;
    }

    public void delete(Purchase purchase){
        purchaseRepository.delete(purchase);
    }

    public Purchase processPurchase(Purchase purchase){
        Purchase fetchedPurchase = fetchByUsernameAndShowIdPK(purchase.getUsernameShowIdPK());
        if(fetchedPurchase == null) {
            //customer has no previous order for this show
            save(purchase);
        }
        else {
            //customer has previous order
            updateTicketCount(fetchedPurchase, purchase.getTicketCount() + fetchedPurchase.getTicketCount());
            purchase = fetchedPurchase;
        }
        return purchase;
    }

    public List<Purchase> fetchByShowIdRange(Long fromShowId, Long toShowId){
        return purchaseRepository.findByShowIdRange(fromShowId, toShowId);
    }
}
