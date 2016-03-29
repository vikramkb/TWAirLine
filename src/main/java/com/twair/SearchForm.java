package com.twair;

public class SearchForm {
    private String from;
    private String to;
    private String number;
    private Integer numberSeats;

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Integer getNumberSeats() {
        return numberSeats;
    }

    public void setNumberSeats(Integer numberSeats) {
        if(numberSeats == null) {
            this.numberSeats = 1;
        }else{
            this.numberSeats = numberSeats;
        }
    }
}
