package com.duckrace;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

/*
 * This is a lookup table of ids to student names.
 * When a duck wins for the first time, we need to find out who that is.
 * This lookup table could be hardcoded with the data, or we could read the data
 * in from a file, so that no code changes would need to be made for each cohort.
 *
 * Map<Integer,String> studentIdMap;
 *
 * Integer    String
 * =======    ======
 *    1       John
 *    2       Jane
 *    3       Danny
 *    4       Armando
 *    5       Sheila
 *    6       Tess
 *
 *
 * We also need a data structure to hold the results of all winners.
 * This data structure should facilitate easy lookup, retrieval, and storage.
 *
 * Map<Integer,DuckRacer> racerMap;
 *
 * Integer    DuckRacer
 * =======    =========
 *            id    name     wins   rewards
 *            --    ----     ----   -------
 *    5        5    Sheila     2    PRIZES, PRIZES
 *    6        6    Tess       1    PRIZES
 *   13       13    Zed        3    PRIZES, DEBIT_CARD, DEBIT_CARD
 *   17       17    Dom        1    DEBIT_CARD
 */

class Board {
    private final Map<Integer, String> studentIdMap = loadStudentIDMap();
    private final Map<Integer, DuckRacer> racerMap = new TreeMap<>();

    /*
     * updates board (racerMap) by making a DuckRacer win()
     * could fetch existing DuckRacer from racerMap
     * or create new DuckRacer, put it in map then win()
     */
    public void update(int id, Reward reward) {
        DuckRacer racer = null;
        if (racerMap.containsKey(id)) {
            racer = racerMap.get(id);
        } else {
            racer = new DuckRacer(id, studentIdMap.get(id));
            racerMap.put(id, racer);
        }
        racer.win(reward);
    }

    /*
     * TODO: render data to look like board on jay's notepad
     * NOT A toString
     * StringBuilder using append is a possible approach, instead of sout
     *
     * "Duck Race Results"
     * ==================
     * id   name    wins    rewards
     * --   ----    ----    -------
     *  1   Aaron   1       PRIZES
     *  3   Bullen  1       DEBIT_CARD
     *  3   CJ      2       DEBIT_CARD, DEBIT_CARD
     */
    void show(){
        Collection<DuckRacer> racers = racerMap.values();

        for (DuckRacer racer : racers){
            System.out.printf("%s   %s  %s  %s\n",
                    racer.getId(), racer.getName(), racer.getWins(), racer.getRewards());
        }
    }

    void dumpStudentID() {
        System.out.println(studentIdMap);
    }

    private Map<Integer, String> loadStudentIDMap() {
        Map<Integer, String> idMap = new HashMap<>();

        try {
            //read all lines from conf/student-ids.csv
            List<String> lines = Files.readAllLines(Path.of("conf/student-ids.csv"));

            //for each line, split it into Integers and Strings (tokens)
            for (String line : lines) {
                String[] tokens = line.split(",");   //tokens[0] is "1" and tokens[1] is "Aaron"

                idMap.put(Integer.valueOf(String.valueOf(tokens[0])), tokens[1]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return idMap;
    }
}