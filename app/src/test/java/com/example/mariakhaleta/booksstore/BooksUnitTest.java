package com.example.mariakhaleta.booksstore;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class BooksUnitTest {
    private Books mBooks;

    private static final Integer BOOK_ID = 1;
    private static final String TITLE = "БЛАБЛАБЛА";
    private static final String AUTHOR = "Павел Муратов";
    private static final String LANG_OF_PUB = "Русский";
    private static final  String DATA_OF_PUB = "1997" ;
    private static final String DESCRIPTION = "Студент 5 курса ИПСА";
    private static final String AUDIOBOOK = "ссылка";
    private static final String TEXT_PREVIEW = "ссылка";
    private static final String BINDING = "Мускулистый";
    private static final String PUBLISHER = "Мама и папа";
    private static final String GENRE = "программист";
    private static final String VENDOR_CODE = "1234567890";
    private static final String COVER = "https://www.instagram.com/pavlomuratov/";
    private static final Integer PRICE = 10000000;

    @Before
    public void init_books() {
        mBooks = new Books(BOOK_ID, TITLE, AUTHOR, LANG_OF_PUB, DATA_OF_PUB, DESCRIPTION, AUDIOBOOK,
                TEXT_PREVIEW, BINDING, PUBLISHER, GENRE, VENDOR_CODE, COVER, PRICE);
    }

    @Test
    public void book_init_negative() {
        Books books = null;

        assertNull(books);
    }

    @Test
    public void book_init_positive() {
        assertNotNull(mBooks);
    }

    @Test
    public void book_book_id_positive() {
        assertEquals(mBooks.getBookID(), BOOK_ID);
    }

    @Test
    public void book_book_id_negative() {
        Integer bookId = 0;

        assertNotEquals(mBooks.getBookID(), bookId);
    }

    @Test
    public void book_book_price_positive() {
        assertEquals(mBooks.getPrice(), PRICE);
    }

    @Test
    public void book_book_price_negative() {
        Integer price = 0;

        assertNotEquals(mBooks.getPrice(), price);
    }

    @Test
    public void book_book_title_positive() {
        assertEquals(mBooks.getTitle(), TITLE);
    }

    @Test
    public void book_book_title_negative() {
        String title = "";

        assertNotEquals(mBooks.getTitle(), title);
    }

    @Test
    public void book_book_author_positive() {
        assertEquals(mBooks.getAuthor(), AUTHOR);
    }

    @Test
    public void book_book_author_negative() {
        String Author = "";

        assertNotEquals(mBooks.getAuthor(), Author);
    }

}