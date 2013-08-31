package ro.jtonic.handson.springweb.services;

import ro.jtonic.handson.springweb.model.BookSearchCriteria;

/**
 * Created by jtonic on 8/31/13.
 */
public class BookSearchCriteriaService {

    public BookSearchCriteria createBookSearchCriteria() {
        return new BookSearchCriteria("title 3");
    }

}
