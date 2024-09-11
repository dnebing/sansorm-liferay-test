package com.liferay.example.api.model;


/**
 * class DoubleKey: An example interface for the actual database object.
 * @author dnebinger
 */
public interface DoubleKey {
    public Double getPrimaryKey();
    public void setPrimaryKey(Double primaryKey);

    public String getName();
    public void setName(String name);
}
