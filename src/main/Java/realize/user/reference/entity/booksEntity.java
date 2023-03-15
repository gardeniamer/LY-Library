package realize.user.reference.entity;

public class booksEntity {
    private String bookname;
    private String writer;
    private String publishing_house;
    private String number;
    private String classification;
    private String introduction;

    public booksEntity() {
    }

    public booksEntity(String bookname, String writer, String publishing_house, String number, String classification, String introduction) {
        this.bookname = bookname;
        this.writer = writer;
        this.publishing_house = publishing_house;
        this.number = number;
        this.classification = classification;
        this.introduction = introduction;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getPublishing_house() {
        return publishing_house;
    }

    public void setPublishing_house(String publishing_house) {
        this.publishing_house = publishing_house;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    @Override
    public String toString() {
        return "booksEntity{" +
                "bookname='" + bookname + '\'' +
                ", writer='" + writer + '\'' +
                ", publishing_house='" + publishing_house + '\'' +
                ", number='" + number + '\'' +
                ", classification='" + classification + '\'' +
                ", introduction='" + introduction + '\'' +
                '}';
    }
}
