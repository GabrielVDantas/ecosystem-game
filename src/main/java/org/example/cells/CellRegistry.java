package org.example.cells;

import org.example.exceptions.cell.CellNotFoundException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CellRegistry {

    private final Map<String, Cell> cells = new HashMap<>();

    public Cell getCellBasedOnNumber(String number) {
        Cell cell = this.cells.get(number);

        if (cell == null) throw new CellNotFoundException(number);

        return cell;
    }

    public CellRegistry(List<Cell> cells) {
        cells.forEach(cell -> this.cells.put(cell.getNumber(), cell));
    }
}
