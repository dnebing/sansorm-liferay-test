package com.liferay.example.internal.impl;

import com.zaxxer.sansorm.SansOrm;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import javax.sql.DataSource;
import java.util.Properties;

import java.util.Properties;

import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.dao.jdbc.DataSourceFactoryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;


/**
 * class SansORMInitializer: Initializes the SansORM framework as part of a BundleActivator.
 * 
 * @author: dnebinger
 */
public class SansORMInitializer implements BundleActivator {

    public void initialize() throws Exception {
        // initialize the SansORM framework with the datasource using a simple transaction model.
        SansOrm.initializeTxSimple(getDataSource());
    }

    private DataSource getDataSource() throws Exception {
        // get the properties for the external datasource
        Properties properties = PropsUtil.getProperties("jdbc.testing.", true);

        // have liferay load it up
        return DataSourceFactoryUtil.initDataSource(properties);
    }

    @Override
    public void start(BundleContext bundleContext) throws Exception {
        initialize();
    }

    @Override
    public void stop(BundleContext bundleContext) throws Exception {
    }
}
