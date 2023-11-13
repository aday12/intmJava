package com.duckrace.client;

import com.duckrace.Board;
import com.duckrace.app.DuckRaceApp;

class Main {
    public static void main(String[] args) {
        //instantiate controller and say "go"
        DuckRaceApp app = new DuckRaceApp();
        Board.getInstance();
        app.run();
    }
}
