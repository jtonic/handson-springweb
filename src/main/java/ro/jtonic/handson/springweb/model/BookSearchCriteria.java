package ro.jtonic.handson.springweb.model;

/**
 * Created by jtonic on 8/31/13.
 */
public class BookSearchCriteria {

    private String title;

    public BookSearchCriteria(String title) {
        this.title = title;
    }

    public BookSearchCriteria() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
