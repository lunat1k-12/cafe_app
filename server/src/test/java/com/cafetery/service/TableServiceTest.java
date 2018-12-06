package com.cafetery.service;

import com.cafetery.dao.CafeTableRepository;
import com.cafetery.domain.CafeTable;
import com.cafetery.domain.wrapper.Result;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TableServiceTest {

    @Mock
    private CafeTableRepository tableRepo;

    @Mock
    private IClientNotify clientNotify;

    @InjectMocks
    private TableService service;

    @Test
    public void getTablesList_hp() {

        when(tableRepo.findAll()).thenReturn(Collections.singletonList(new CafeTable()));

        List<CafeTable> res = service.getTablesList();

        assertFalse(CollectionUtils.isEmpty(res));
        verify(tableRepo).findAll();
    }

    @Test
    public void reserveTable_hp() {

        String userId = "userId";
        Long tableId = 12L;

        when(tableRepo.findById(tableId)).thenReturn(Optional.of(new CafeTable()));

        Result<String> res = service.reserveTable(userId,tableId);

        assertNotNull(res.getDomain());
        verify(tableRepo).findById(tableId);
        verify(tableRepo).save(any(CafeTable.class));
        verify(clientNotify).tableStatusChange(any(CafeTable.class));
    }

    @Test
    public void reserveTable_tableReserved() {

        String userId = "userId";
        Long tableId = 12L;
        CafeTable table = new CafeTable();
        table.setCurrentUser("user");

        when(tableRepo.findById(tableId)).thenReturn(Optional.of(table));

        Result<String> res = service.reserveTable(userId,tableId);

        assertNotNull(res.getError());
        verify(tableRepo).findById(tableId);
        verify(tableRepo,never()).save(any(CafeTable.class));
        verify(clientNotify,never()).tableStatusChange(any(CafeTable.class));
    }

    @Test
    public void busyTable_hp() {

        String userId = "userId";
        Long tableId = 12L;
        CafeTable table = new CafeTable();
        table.setCurrentUser(userId);

        when(tableRepo.findById(tableId)).thenReturn(Optional.of(table));

        Result<String> res = service.busyTable(userId,tableId);

        assertEquals("Reserved", res.getDomain());
        verify(tableRepo).findById(tableId);
        verify(tableRepo).save(any(CafeTable.class));
        verify(clientNotify).tableStatusChange(any(CafeTable.class));
    }

    @Test
    public void busyTable_tableBusy() {

        String userId = "userId";
        Long tableId = 12L;
        CafeTable table = new CafeTable();
        table.setCurrentUser("other");

        when(tableRepo.findById(tableId)).thenReturn(Optional.of(table));

        Result<String> res = service.busyTable(userId,tableId);

        assertEquals("Table busy.",res.getError());
        verify(tableRepo).findById(tableId);
        verify(tableRepo,never()).save(any(CafeTable.class));
        verify(clientNotify,never()).tableStatusChange(any(CafeTable.class));
    }

    @Test
    public void freeTable_hp() {

        String userId = "userId";
        Long tableId = 12L;
        CafeTable table = new CafeTable();

        when(tableRepo.findById(tableId)).thenReturn(Optional.of(table));

        Result<String> res = service.freeTable(userId,tableId);

        assertEquals("Table is free now.",res.getDomain());
        verify(tableRepo).save(any(CafeTable.class));
        verify(clientNotify).tableStatusChange(any(CafeTable.class));
    }
}
