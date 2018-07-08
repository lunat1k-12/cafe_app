package com.cafetery.controllers;

import com.cafetery.constants.TableState;
import com.cafetery.domain.CafeTable;
import com.cafetery.domain.wrapper.Result;
import com.cafetery.service.ITableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/table")
public class TableController {

    @Autowired
    private ITableService tableService;

    @GetMapping("/list")
    @ResponseBody
    public List<CafeTable> getTablesList() {
        return tableService.getTablesList();
    }

    @PostMapping("/{userId}/{tableId}/{status}")
    @ResponseBody
    public Result<String> updateTable(@PathVariable("userId") String userId,
                                       @PathVariable("tableId") Long tableId,
                                       @PathVariable("status") String status) {

        switch(TableState.getByShortState(status)) {
            case RESERVED:
                return tableService.reserveTable(userId, tableId);
            case FREE:
                return tableService.freeTable(userId, tableId);
            case BUSY:
                return tableService.busyTable(userId, tableId);
                default:
                    return new Result("Invalid Action.");
        }
    }
}
