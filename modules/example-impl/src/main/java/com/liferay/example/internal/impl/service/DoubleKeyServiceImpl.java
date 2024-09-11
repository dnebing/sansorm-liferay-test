package com.liferay.example.internal.impl.service;

import com.liferay.example.api.model.DoubleKey;
import com.liferay.example.api.service.DoubleKeyService;
import com.liferay.example.internal.impl.model.DoubleKeyImpl;
import com.zaxxer.sansorm.*;

import org.osgi.service.component.annotations.Component;
import java.util.List;
import java.util.ArrayList;

@Component(
    immediate = true,
    service = DoubleKeyService.class
)
public class DoubleKeyServiceImpl implements DoubleKeyService {
    public DoubleKey getDoubleKey(Double primaryKey) {
        return SqlClosureElf.getObjectById(DoubleKeyImpl.class, primaryKey);
    }

    public DoubleKey createDoubleKey(Double primaryKey, String name) {
        return SqlClosureElf.insertObject(new DoubleKeyImpl(primaryKey, name));
    }

    public DoubleKey updateDoubleKey(Double primaryKey, String name) {
        return SqlClosureElf.updateObject(new DoubleKeyImpl(primaryKey, name));
    }

    public void deleteDoubleKey(Double primaryKey) {
        SqlClosureElf.deleteObject(new DoubleKeyImpl(primaryKey, null));
    }

    public List<DoubleKey> getDoubleKeys() {
        List<DoubleKeyImpl> list = SqlClosureElf.listFromClause(DoubleKeyImpl.class, null);

        if (list == null) {
            return null;
        }

        return new ArrayList<>(list);
    }
}
