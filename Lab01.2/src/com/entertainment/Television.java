package com.entertainment;

import java.util.Objects;

public class Television {
    //fields
    private String brand;
    private int volume;
    private Tuner tuner = new Tuner();

    //ctor
    public Television() {

    }

    public Television(String brand, int volume) {
        setBrand(brand);
        setVolume(volume);
    }

    // get & set
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public int getCurrentChannel() {
        return tuner.getChannel();
    }

    public void changeChannel(int channel) {
        tuner.setChannel(channel);
    }

    @Override
    public int hashCode() {
        /*
         * poorly written hash function, becauses it easily yields hash collisions
         * hash collision: different objects have the same hash code
         */
       // return getBrand().length() + getVolume();
        return Objects.hash(getBrand(), getVolume());
    }

    @Override
    public boolean equals(Object obj) {
        boolean result = false;

        //proceed only if obj is really referencing a tv object
        if (obj instanceof Television) {
            //safely downcast obj to more specific reference Television
            Television other = (Television) obj;

            //do check: check brand and volume are the same
            result = Objects.equals(this.getBrand(), other.getBrand()) && //null-safe check of brand field
                    this.getVolume() == other.getVolume();                        //primitives can't be null
        }
        return result;
    }

    //toString
    @Override
    public String toString() {
        return getClass().getSimpleName() + " brand=" + getBrand() + ", volume=" + getVolume() +
                ", currentChannel= " + getCurrentChannel();
    }
}
