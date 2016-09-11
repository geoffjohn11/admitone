package com.admitone.service;

import com.admitone.model.Purchase;
import com.admitone.model.UsernameShowIdPK;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by gjohnson on 9/10/16.
 */

@Service
@Transactional
public class TicketServiceImpl implements TicketService {

    @Autowired
    PurchaseService purchaseService;

    public void processExchange(String username, Long fromShowId, int newTicketCount, Long toShowId){
        Purchase fromPurchase = purchaseService.fetchByUsernameAndShowIdPK(new UsernameShowIdPK(username, fromShowId));
        validateTicketCount(fromPurchase.getTicketCount(), newTicketCount);

        if(fromPurchase.getTicketCount() == newTicketCount){
            //Transfer all the tickets to the new show
            UsernameShowIdPK pk = new UsernameShowIdPK();
            pk.setShowId(toShowId);
            pk.setUsername(fromPurchase.getUsernameShowIdPK().getUsername());
            purchaseService.processPurchase(new Purchase(pk, newTicketCount));
            purchaseService.delete(fromPurchase);
        }else{
            int ticketsToKeep = fromPurchase.getTicketCount() - newTicketCount;
            //Keep some tickets
            purchaseService.updateTicketCount(fromPurchase, ticketsToKeep);
            //Transfer other tickets
            UsernameShowIdPK pk = new UsernameShowIdPK();
            pk.setShowId(toShowId);
            pk.setUsername(fromPurchase.getUsernameShowIdPK().getUsername());
            purchaseService.processPurchase(new Purchase(pk, newTicketCount));
        }
    }

    public void processCancellation(String username, Long showId, int newTicketCount){
        Purchase purchase = purchaseService.fetchByUsernameAndShowIdPK(new UsernameShowIdPK(username, showId));
        validateTicketCount(purchase.getTicketCount(), newTicketCount);
        int ticketsToKeep = purchase.getTicketCount() - newTicketCount;

        if(ticketsToKeep == 0)
            purchaseService.delete(purchase);
        else
            purchaseService.updateTicketCount(purchase, ticketsToKeep);
    }

    private void validateTicketCount(int purchaseTicketCount, int ticketCount){
        if(purchaseTicketCount < ticketCount){
            throw new IllegalArgumentException(
                    "Cannot exchange or cancel more tickets than you have");
        }
    }
}
