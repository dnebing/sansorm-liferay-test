package com.liferay.example.api.service;

import org.osgi.service.component.annotations.Component;

import com.liferay.example.api.model.DoubleKey;
import com.liferay.osgi.util.ServiceTrackerFactory;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;
import com.liferay.example.api.service.DoubleKeyService;

import java.util.List;

/**
 * class DoubleKeyServiceUtil: A utility class for the DoubleKeyService.
 * 
 * @author dnebinger
 */
public class DoubleKeyServiceUtil {

    public static DoubleKey getDoubleKey(Double primaryKey) {
        return getService().getDoubleKey(primaryKey);
    }

    public static DoubleKey createDoubleKey(Double primaryKey, String name) {
        return getService().createDoubleKey(primaryKey, name);
    }

    public static DoubleKey updateDoubleKey(Double primaryKey, String name) {
        return getService().updateDoubleKey(primaryKey, name);
    }

    public static void deleteDoubleKey(Double primaryKey) {
        getService().deleteDoubleKey(primaryKey);
    }

    public static DoubleKeyService getService() {
        return _serviceTracker.getService();
    }

    public static List<DoubleKey> getDoubleKeys() {
        return getService().getDoubleKeys();
    }

    private static ServiceTracker<DoubleKeyService, DoubleKeyService> _serviceTracker = ServiceTrackerFactory.open(FrameworkUtil.getBundle(DoubleKeyService.class), DoubleKeyService.class);
}
