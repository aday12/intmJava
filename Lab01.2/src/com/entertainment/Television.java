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

    /*
    @Override
    public boolean equals(Object o) { //ask for "how to code at x employeer" document to choose which equals is appropriate
        if (this == o) return true;

        if (o == null || this.getClass() != o.getClass()) return false; //getClass is an exact type match
        Television that = (Television) o;

        return this.getVolume() == that.getVolume() &&
                Objects.equals(this.getBrand(), that.getBrand());
    }

     */

    @Override
    public int hashCode() {
        return Objects.hash(getBrand(), getVolume());
    }

    /*
    @Override
    public int hashCode() {
        // System.out.println("hashCode called");

        // return getBrand().length() + getVolume(); this code generates lots of collisions

        return Objects.hash(getBrand(), getVolume());
    }

     */

    @Override
    public boolean equals(Object obj) {
        // System.out.println("equals called");

        boolean result = false;

        //proceed only if obj is really referencing a tv object
        if (obj != null && this.getClass() == obj.getClass()) { //instanceof is an IS-A match, safe to use == w/class objects and enums
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
