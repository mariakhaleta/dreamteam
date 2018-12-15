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

    @Test
    public void book_book_langofpub_positive() {
        assertEquals(mBooks.getLangOfPub(), LANG_OF_PUB);
    }

    @Test
    public void book_book_langofpub_negative() {
        String LangOfOub = "";

        assertNotEquals(mBooks.getLangOfPub(), LangOfOub);
    }

    @Test
    public void book_book_dateofpub_positive() {
        assertEquals(mBooks.getDateOfPub(), DATA_OF_PUB);
    }

    @Test
    public void book_book_dateofpub_negative() {
        String DateOfPub = "";

        assertNotEquals(mBooks.getDateOfPub(), DateOfPub);
    }

    @Test
    public void book_book_description_positive() {
        assertEquals(mBooks.getDescription(), DESCRIPTION);
    }

    @Test
    public void book_book_description_negative() {
        String Description = "";

        assertNotEquals(mBooks.getDescription(), Description);
    }

    @Test
    public void book_book_textpreview_positive() {
        assertEquals(mBooks.getTextpreview(), TEXT_PREVIEW);
    }

    @Test
    public void book_book_textpreview_negative() {
        String Textpreview = "";

        assertNotEquals(mBooks.getTextpreview(), Textpreview);
    }

    @Test
    public void book_book_binding_positive() {
        assertEquals(mBooks.getBinding(), BINDING);
    }

    @Test
    public void book_book_binding_negative() {
        String Binding = "";

        assertNotEquals(mBooks.getAuthor(), Binding);
    }

    @Test
    public void book_book_publisher_positive() {
        assertEquals(mBooks.getPublisher(), PUBLISHER);
    }

    @Test
    public void book_book_publisher_negative() {
        String Publisher = "";

        assertNotEquals(mBooks.getPublisher(), Publisher);
    }

    @Test
    public void book_book_genre_positive() {
        assertEquals(mBooks.getGenre(), GENRE);
    }

    @Test
    public void book_book_genre_negative() {
        String Genre = "";

        assertNotEquals(mBooks.getGenre(), Genre);
    }

    @Test
    public void book_book_vendorcode_positive() {
        assertEquals(mBooks.getVendorCode(), VENDOR_CODE);
    }

    @Test
    public void book_book_vendorcode_negative() {
        String Vendorcode = "";

        assertNotEquals(mBooks.getVendorCode(), Vendorcode);
    }

    @Test
    public void book_book_cover_positive() {
        assertEquals(mBooks.getCover(), COVER);
    }

    @Test
    public void book_book_cover_negative() {
        String Cover= "";

        assertNotEquals(mBooks.getCover(), Cover);
    }

    @Test
    public void book_book_audiobook_positive() {
        assertEquals(mBooks.getAudiobook(), AUDIOBOOK);
    }

    @Test
    public void book_book_audiobook_negative() {
        String Audiobook = "";

        assertNotEquals(mBooks.getAudiobook(), Audiobook);
    }
}