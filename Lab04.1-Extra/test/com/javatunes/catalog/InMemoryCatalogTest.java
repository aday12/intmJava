package com.javatunes.catalog;

import org.junit.Before;
import org.junit.Test;

import java.sql.Date;
import java.util.Collection;
import static org.junit.Assert.*;
import java.sql.Date;

public class InMemoryCatalogTest {
    private InMemoryCatalog catalog;

    @Before
    public void setUp(){
        catalog = new InMemoryCatalog();
    }

    @Test
    public void isCheap_shouldReturnTrue_priceLessThanTen() {
       Collection<MusicItem> items = catalog.getInventory();

       for (MusicItem item : items){
           assertTrue(catalog.isCheap(item.getId()));
       }
    }

    @Test(expected = UnsupportedOperationException)
    public void getInventory_shouldReturnReadOnlyCollection() throws UnsupportedOperationException{
        //  Collection<Television> tvs = new Catalog.getInventory();
        // tvs.clear();
    }

    @Test
    public void numberInGenre_shouldReturnCorrectResult() {
        int result = catalog.numberInGenre(MusicCategory.POP);

        assertEquals(4, result);
    }

    @Test
    public void findSelfTitled_shouldReturnCollection_albumTitleIsSameAsArtist() {
        Collection<MusicItem> items = catalog.findSelfTitled();

        assertEquals(2, items.size());

        for (MusicItem item : items){
            assertEquals(item.getArtist(), item.getTitle());
        }
    }

    @Test
    public void findByCategory_shouldReturnCollection_categoryFound() {
        Collection<MusicItem> items = catalog.findByCategory(MusicCategory.POP);

        assertEquals(4, items.size());
        for (MusicItem item : items){
            assertEquals(item.getMusicCategory(), MusicCategory.POP); //can also do with assertTrue
            assertSame(MusicCategory.POP, item.getMusicCategory());
        }
    }

    @Test
    public void findByCategory_shouldReturnEmptyCollection_whenCategoryNotFound() {
        Collection<MusicItem> items = catalog.findByCategory(MusicCategory.JAZZ);

        assertEquals(0, items.size());
        assertTrue(items.isEmpty()); //either assertion here is fine
    }

    @Test
    public void findById_shouldReturnMusicItem_IdFound() {
        MusicItem item = catalog.findById(1L);

        assertEquals(1L, item.getId().longValue());
    }

    @Test
    public void findById_shouldReturnNull_whenIdNotFound() {
        MusicItem item = catalog.findById(19L);

        assertNull(item);
    }
}
