package com.liferay.example.internal.impl.model;

import com.liferay.example.api.model.DoubleKey;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.AttributeConverter;
import javax.persistence.Convert;
import java.math.BigDecimal;

/**
 * class DoubleKeyImpl: An implementation of the DoubleKey interface.
 * 
 * @author: dnebinger
 */
@Table(name = "doublekey")
public class DoubleKeyImpl implements DoubleKey {

    public static class DoubleConverter implements AttributeConverter<BigDecimal, Double> {

        @Override
        public Double convertToDatabaseColumn(BigDecimal attribute) {
            if (attribute == null) {
                return null;
            }
            return attribute.doubleValue();
        }
    
        @Override
        public BigDecimal convertToEntityAttribute(Double dbData) {
            if (dbData == null) {
                return null;
            }
            return BigDecimal.valueOf(dbData);
        }
    }

    @Id
    @Column(name = "pkey")
    private Double primaryKey;

    @Column(name = "name")
    private String name;

    public DoubleKeyImpl() {
    }

    public DoubleKeyImpl(Double primaryKey, String name) {
        this.primaryKey = primaryKey;
        this.name = name;
    }
    
    @Override
    public Double getPrimaryKey() {
        return primaryKey;
    }

    @Override
    public void setPrimaryKey(Double primaryKey) {
        this.primaryKey = primaryKey;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return "DoubleKeyImpl [primaryKey=" + primaryKey + ", name=" + name + "]";
    }
}
