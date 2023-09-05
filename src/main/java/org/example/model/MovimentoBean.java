package org.example.model;

import java.sql.Date;

public class MovimentoBean {
    private int movement_amount;
    private Date movement_date;
    private String movement_type;


    public MovimentoBean() {}

    public MovimentoBean(int movement_amount, Date movement_date, String movement_type) {
        this.setMovement_amount(movement_amount);
        this.setMovement_date(movement_date);
        this.setMovement_type(movement_type);
    }

    public int getMovement_amount() {
        return movement_amount;
    }

    public void setMovement_amount(int movement_amount) {
        this.movement_amount = movement_amount;
    }

    public Date getMovement_date() {
        return movement_date;
    }

    public void setMovement_date(Date movement_date) {
        this.movement_date = movement_date;
    }

    public String getMovement_type() {
        return movement_type;
    }

    public void setMovement_type(String movement_type) {
        this.movement_type = movement_type;
    }
}
