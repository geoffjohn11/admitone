package com.admitone.model;

import javax.persistence.*;

/**
 * Created by gjohnson on 9/8/16.
 */

public class Exchange {

    private String username;
    private int ticketCount;
    private Long fromShowId;
    private Long toShowId;

    protected Exchange(){
        //No args constructor
    }

    public Exchange(String username, int ticketCount, Long fromShowId, Long toShowId){
        this.username = username;
        this.ticketCount = ticketCount;
        this.fromShowId = fromShowId;
        this.toShowId = toShowId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getToShowId() {
        return toShowId;
    }

    public void setToShowId(Long toShowId) {
        this.toShowId = toShowId;
    }

    public Long getFromShowId() {
        return fromShowId;
    }

    public void setFromShowId(Long fromShowId) {
        this.fromShowId = fromShowId;
    }

    public int getTicketCount() {
        return ticketCount;
    }

    public void setTicketCount(int ticketCount) {
        this.ticketCount = ticketCount;
    }

}
