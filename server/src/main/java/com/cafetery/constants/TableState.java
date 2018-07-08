package com.cafetery.constants;

public enum TableState {
    BUSY("busy"), FREE("free"), RESERVED("reserved");

    TableState(String shortState) {
        this.shortState = shortState;
    }

    private String shortState;

    public String getShortState() {
        return shortState;
    }

    public  static TableState getByShortState(String shortState) {
        TableState[] values = TableState.values();

        for(TableState state : values)
        {
            if(state.getShortState().equals(shortState)) {
                return state;
            }
        }

        return null;
    }
}
