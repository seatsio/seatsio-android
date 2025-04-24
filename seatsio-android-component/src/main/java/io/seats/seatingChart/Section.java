package io.seats.seatingChart;

import com.google.gson.annotations.Expose;

import java.util.List;

public class Section {

    @Expose
    public String objectType;

    @Expose
    public Category sectionCategory;

    @Expose
    public String label;

    @Expose
    public Long numberOfSelectableObjects;

    @Expose
    public Long numberOfSelectedObjects;

    @Expose
    public List<Category> selectableCategories;

    @Expose
    public Boolean isInteractive;
}
