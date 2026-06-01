package org.example.cells.info;

import org.example.cells.Cell;

public class Rock implements Cell {

    @Override
    public String getLetter() {
        return "R";
    }

    @Override
    public String getImage() {
        return "🪨";
    }

    @Override
    public String getNumber() {
        return "0";
    }

    @Override
    public Cell defineNextGeneration() {
        return null;
    }
}
