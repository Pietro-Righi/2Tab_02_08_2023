package org.example.model;

import java.beans.JavaBean;
import java.io.Serializable;
import java.sql.Date;


@JavaBean
public class ClienteBean implements Serializable {
    private String name;
    private String surname;
    private String tax_code;
    private Date creation_date;
    private int amount;
    private Date last_movement;
    private String movement_type;
    private int movement_amount;

    public ClienteBean() {
    }

    public ClienteBean(String name, String surname, String tax_code, Date creation_date, int amount, Date last_movement, String movement_type, int movement_amount) {
        this.setName(name);
        this.setSurname(surname);
        this.setTax_code(tax_code);
        this.setCreation_date(creation_date);
        this.setAmount(amount);
        this.setLast_movement(last_movement);
        this.setMovement_type(movement_type);
        this.setMovement_amount(movement_amount);
    }

    public ClienteBean(String name, String surname, String tax_code, Date register_date, int amount) {
        this.setName(name);
        this.setSurname(surname);
        this.setTax_code(tax_code);
        this.setCreation_date(register_date);
        this.setAmount(amount);
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getTax_code() {
        return tax_code;
    }

    public void setTax_code(String tax_code) {
        this.tax_code = tax_code;
    }

    public Date getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(Date creation_date) {
        this.creation_date = creation_date;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Date getLast_movement() {
        return last_movement;
    }

    public void setLast_movement(Date last_movement) {
        this.last_movement = last_movement;
    }

    public String getMovement_type() {
        return movement_type;
    }

    public void setMovement_type(String movement_type) {
        this.movement_type = movement_type;
    }

    public int getMovement_amount() {
        return movement_amount;
    }

    public void setMovement_amount(int movement_amount) {
        this.movement_amount = movement_amount;
    }
}
