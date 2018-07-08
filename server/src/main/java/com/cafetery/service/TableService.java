package com.cafetery.service;

import com.cafetery.constants.TableState;
import com.cafetery.dao.CafeTableRepository;
import com.cafetery.domain.CafeTable;
import com.cafetery.domain.wrapper.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import java.util.List;

public class TableService implements ITableService {

    @Autowired
    private CafeTableRepository tableRepo;

    @Autowired
    private IClientNotify clientNotify;

    @Override
    public List<CafeTable> getTablesList() {
        return tableRepo.findAll();
    }

    @Override
    public Result<String> reserveTable(String userId, Long tableId) {

        Result<String> result = new Result<>();
        CafeTable table = tableRepo.findById(tableId).get();

        // TODO: implement shared validator
        if(!StringUtils.isEmpty(table.getCurrentUser())) {
            result.setError("Table already reserved.");
            return result;
        }

        table.setCurrentUser(userId);
        table.setState(TableState.RESERVED.name());
        tableRepo.save(table);
        result.setDomain("Reserved");
        clientNotify.tableStatusChange(table);

        return result;
    }

    @Override
    public Result<String> busyTable(String userId, Long tableId) {
        Result<String> result = new Result<>();
        CafeTable table = tableRepo.findById(tableId).get();

        // TODO: implement shared validator
        if(!StringUtils.isEmpty(table.getCurrentUser()) && !userId.equals(table.getCurrentUser())) {
            result.setError("Table busy.");
            return result;
        }

        if((!StringUtils.isEmpty(table.getCurrentUser()) && userId.equals(table.getCurrentUser()))
                || (TableState.FREE.equals(TableState.valueOf(table.getState())))) {
            table.setCurrentUser(userId);
            table.setState(TableState.BUSY.name());
            tableRepo.save(table);
            result.setDomain("Reserved");
        }
        clientNotify.tableStatusChange(table);

        return result;
    }

    @Override
    public Result<String> freeTable(String userId, Long tableId) {
        Result<String> result = new Result<>();
        CafeTable table = tableRepo.findById(tableId).get();

        table.setCurrentUser(null);
        table.setState(TableState.FREE.toString());
        tableRepo.save(table);
        result.setDomain("Table is free now.");
        clientNotify.tableStatusChange(table);
        return result;
    }
}
