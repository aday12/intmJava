package com.duckrace;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

class DuckRacer implements Serializable {
    private final int id;
    private String name;
    private final Collection<Reward> rewards = new ArrayList<>();

    //ctors
    public DuckRacer(int id, String name) {
        this.id = id;
        setName(name);
    }

    //business methods
    public void win(Reward reward) {
        rewards.add(reward);
    }

    //accessor methods
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //derived property
    public int getWins() {
        return rewards.size();
    }

    /*
     * instead of returning direct reference return a read only view
     */
    public Collection<Reward> getRewards() {
        return Collections.unmodifiableCollection(rewards);
        // return List.copyOf(rewards); returns snapshot, List must be called again after using win()
    }

    @Override
    public String toString() {
        return String.format("%s: id= %s, name= %s, wins= %s, rewards= %s",
                getClass().getSimpleName(), getId(), getName(), getWins(), getRewards());
    }
}
