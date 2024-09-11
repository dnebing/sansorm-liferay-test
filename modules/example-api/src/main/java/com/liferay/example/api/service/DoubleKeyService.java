package com.liferay.example.api.service;

import com.liferay.example.api.model.DoubleKey;
import java.util.List;

/**
 * class DoubleKeyService: This interface defines the service for managing DoubleKey objects.
 * 
 * @author dnebinger
 */
public interface DoubleKeyService {
    DoubleKey getDoubleKey(Double primaryKey);

    DoubleKey createDoubleKey(Double primaryKey, String name);

    DoubleKey updateDoubleKey(Double primaryKey, String name);

    void deleteDoubleKey(Double primaryKey);

    List<DoubleKey> getDoubleKeys();
}