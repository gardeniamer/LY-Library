package realize.user.borrowbook.entity;

import java.util.Date;

public class borrowersEntity {
    private String name;
    private String book;
    private String examined;
    private String approved;
    private String Borrow_Date;
    private String returned;
    private String Return_Date;
    private String ActualReturn_Date;

    @Override
    public String toString() {
        return "borrowersEntity{" +
                "name='" + name + '\'' +
                ", book='" + book + '\'' +
                ", examined='" + examined + '\'' +
                ", approved='" + approved + '\'' +
                ", Borrow_Date='" + Borrow_Date + '\'' +
                ", returned='" + returned + '\'' +
                ", Return_Date='" + Return_Date + '\'' +
                ", ActualReturn_Date='" + ActualReturn_Date + '\'' +
                '}';
    }

    public String getActualReturn_Date() {
        return ActualReturn_Date;
    }

    public void setActualReturn_Date(String actualReturn_Date) {
        ActualReturn_Date = actualReturn_Date;
    }

    public borrowersEntity(String name, String book, String examined, String approved, String borrow_Date, String returned, String return_Date, String actualReturn_Date) {
        this.name = name;
        this.book = book;
        this.examined = examined;
        this.approved = approved;
        Borrow_Date = borrow_Date;
        this.returned = returned;
        Return_Date = return_Date;
        ActualReturn_Date = actualReturn_Date;
    }

    public borrowersEntity() {
    }

    public borrowersEntity(String name, String book, String examined, String approved, String borrow_Date, String returned, String return_Date) {
        this.name = name;
        this.book = book;
        this.examined = examined;
        this.approved = approved;
        Borrow_Date = borrow_Date;
        this.returned = returned;
        Return_Date = return_Date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBook() {
        return book;
    }

    public void setBook(String book) {
        this.book = book;
    }

    public String getExamined() {
        return examined;
    }

    public void setExamined(String examined) {
        this.examined = examined;
    }

    public String getApproved() {
        return approved;
    }

    public void setApproved(String approved) {
        this.approved = approved;
    }

    public String getBorrow_Date() {
        return Borrow_Date;
    }

    public void setBorrow_Date(String borrow_Date) {
        Borrow_Date = borrow_Date;
    }

    public String getReturned() {
        return returned;
    }

    public void setReturned(String returned) {
        this.returned = returned;
    }

    public String getReturn_Date() {
        return Return_Date;
    }

    public void setReturn_Date(String return_Date) {
        Return_Date = return_Date;
    }


}
