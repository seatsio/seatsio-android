package io.seats.seatingChart;

import com.google.gson.annotations.Expose;

import java.util.NoSuchElementException;

import io.seats.utils.Either;

public class SectionCategory {

    @Expose
    public Boolean accessible;

    @Expose
    public String color;

    @Expose
    public Object key;

    @Expose
    public String label;

    @Expose
    public Pricing pricing;

    @Expose
    public Boolean hasSelectableObjects;

    public Either<Integer, String> key() {
        if (key == null) {
            throw new NoSuchElementException("No key present");
        }
        if (key instanceof Number) {
            return Either.left(((Number) key).intValue());
        } else if (key instanceof String) {
            return Either.right((String)key);
        } else {
            throw new IllegalStateException("key is not of an expected type");
        }
    }
}
