package com.admitone.service;

/**
 * Created by gjohnson on 9/10/16.
 */
public interface TicketService {
    void processCancellation(String username, Long showId, int newTicketCount);
    void processExchange(String username, Long showId, int newTicketCount, Long newShowId);
}
