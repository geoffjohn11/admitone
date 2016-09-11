package com.admitone.model;
import javax.persistence.*;

/**
 * Created by gjohnson on 9/8/16.
 */

@Entity
public class Purchase {
    @EmbeddedId
    private UsernameShowIdPK usernameShowIdPK;

    @Column(nullable = false)
    private int ticketCount;

    protected Purchase(){
        //No arg constructor
    }

    public Purchase(UsernameShowIdPK usernameShowIdPK, int ticketCount){
        this.usernameShowIdPK = usernameShowIdPK;
        this.ticketCount = ticketCount;
    }


    public UsernameShowIdPK getUsernameShowIdPK() {
        return usernameShowIdPK;
    }

    public void setUsernameShowIdPK(UsernameShowIdPK usernameShowIdPK) {
        this.usernameShowIdPK = usernameShowIdPK;
    }

    public int getTicketCount() {
        return ticketCount;
    }

    public void setTicketCount(int ticketCount) {
        this.ticketCount = ticketCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Purchase purchase = (Purchase) o;

        return usernameShowIdPK.equals(purchase.usernameShowIdPK);

    }

    @Override
    public int hashCode() {
        return usernameShowIdPK.hashCode();
    }
}
