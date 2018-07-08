package com.cafetery.service;

import com.cafetery.domain.CafeTable;
import com.cafetery.domain.wrapper.Result;

import java.util.List;

public interface ITableService {

    List<CafeTable> getTablesList();

    Result<String> reserveTable(String userId, Long tableId);

    Result<String> busyTable(String userId, Long tableId);

    Result<String> freeTable(String userId, Long tableId);
}
