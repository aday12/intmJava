/*
 * This code is sample code, provided AS-IS, and we make NO
 * warranties as to its correctness or suitability for any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */

public class MessagePrinterClient {

    public static void main(String[] args) {
        MessagePrinter printer1 = new MessagePrinter("apples are yummy", 1, 4);
        MessagePrinter printer2 = new MessagePrinter("pears, too", 1500, 3);
        MessagePrinter printer3 = new MessagePrinter("roses are red", 3000, 2);
        MessagePrinter printer4 = new MessagePrinter("violets are blue", 6000, 1);

        Thread thd1 = new Thread(printer1, "printer1");
        thd1.start();

        printer1.run();
        printer2.run();
        printer3.run();
        printer4.run();
    }
}