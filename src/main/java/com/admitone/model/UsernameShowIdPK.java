package com.admitone.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by gjohnson on 9/10/16.
 */

@Embeddable
public class UsernameShowIdPK implements Serializable {

    public UsernameShowIdPK() {
        //no args constructor
    }

    public UsernameShowIdPK(String username, Long showId) {
        this.username = username;
        this.showId = showId;
    }

    @Column(nullable = false)
    private Long showId;

    @Column(nullable = false)
    private String username;

    public Long getShowId() {
        return showId;
    }

    public void setShowId(Long showId) {
        this.showId = showId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UsernameShowIdPK that = (UsernameShowIdPK) o;

        if (!showId.equals(that.showId)) return false;
        return username.equals(that.username);

    }

    @Override
    public int hashCode() {
        int result = showId.hashCode();
        result = 31 * result + username.hashCode();
        return result;
    }
}
