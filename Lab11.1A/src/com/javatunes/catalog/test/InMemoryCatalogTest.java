/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */

package com.javatunes.catalog.test;

import com.javatunes.catalog.InMemoryCatalog;
import com.javatunes.catalog.MusicCategory;
import com.javatunes.catalog.MusicItem;

import java.util.Collection;

class InMemoryCatalogTest {

    /*
     * One by one, complete each test method below, and then "activate" it by
     * uncommenting the call to that method in main().
     *
     * Once you see that the test method verifies the corresponding business method
     * works correctly, you can comment out that call in main() and proceed to the next one.
     */
    public static void main(String[] args) {
        // testFindById();
        // testFindByKeyword();
        // testFindByCategory();
        // testSize();
        testGetAll();
        // testFindSelfTitled();
        // testFindCheapRock();
        // findNumberSold();
        // findAvgPrice();
        // findCheapest();
        // testHasGenre();
    }

    private static void testHasGenre() {
        InMemoryCatalog catalog = new InMemoryCatalog();

        System.out.println(catalog.hasGenre(MusicCategory.BLUES));

        System.out.println(catalog.hasGenre(MusicCategory.JAZZ));
    }

    private static void testFindById() {
        InMemoryCatalog catalog = new InMemoryCatalog();

        MusicItem found = catalog.findById(9L);
        System.out.println(found);

        MusicItem notFound = catalog.findById(20L);
        System.out.println(notFound);
    }

    private static void testFindByKeyword() {
    }

    private static void testFindByCategory() {
        InMemoryCatalog catalog = new InMemoryCatalog();

        Collection<MusicItem> popItems = catalog.findByCategory(MusicCategory.POP);
        dump(popItems);
    }

    private static void testSize() {
        InMemoryCatalog catalog = new InMemoryCatalog();
        System.out.println(catalog.size());
    }

    //TODO: TEST METHODS FOR ALL TASKS
    private static void testGetAll() {
        InMemoryCatalog catalog = new InMemoryCatalog();

        Collection<MusicItem> allItems = catalog.getAll();
        dump(catalog.getAll());
    }

    private static void testFindSelfTitled(){
        InMemoryCatalog catalog = new InMemoryCatalog();

        Collection<MusicItem> selfTitled = catalog.findSelfTitled();
        System.out.println(catalog.findSelfTitled());
    }

    private static void testFindCheapRock(){
        InMemoryCatalog catalog = new InMemoryCatalog();

        Collection<MusicItem> cheapRock = catalog.findCheapRock(30);
        System.out.println(cheapRock);
    }

    private static void findNumberSold(){
        InMemoryCatalog catalog = new InMemoryCatalog();

        Integer total = catalog.numberSold(MusicCategory.ROCK);
        System.out.println(total);
    }

    private static void findAvgPrice(){
        InMemoryCatalog catalog = new InMemoryCatalog();

        System.out.println(catalog.findAvgPrice());
    }

    private static void findCheapest(){
        InMemoryCatalog catalog = new InMemoryCatalog();

        System.out.println(catalog.findCheapest(MusicCategory.ROCK));
    }

    //helper method to show collection vertically
    private static void dump(Collection<MusicItem> items) {
        for (MusicItem item : items){
            System.out.println(item);
        }
    }
}