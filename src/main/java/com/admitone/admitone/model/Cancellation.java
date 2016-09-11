package com.admitone.model;

import javax.persistence.*;

/**
 * Created by gjohnson on 9/8/16.
 */

public class Cancellation {

    private String username;
    private int ticketCount;
    private Long showId;

    protected Cancellation(){
        //no args constructor
    }

    public Cancellation(String username, int ticketCount, Long showId){
        this.username = username;
        this.ticketCount = ticketCount;
        this.showId = showId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getTicketCount() {
        return ticketCount;
    }

    public void setTicketCount(int ticketCount) {
        this.ticketCount = ticketCount;
    }

    public Long getShowId() {
        return showId;
    }

    public void setShowId(Long showId) {
        this.showId = showId;
    }
}
