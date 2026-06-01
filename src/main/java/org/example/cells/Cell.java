package org.example.cells;

public interface Cell {

    String getLetter();

    String getImage();

    String getNumber();

    Cell defineNextGeneration();
}
