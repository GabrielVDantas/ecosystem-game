package org.example;

import org.example.cells.Cell;
import org.example.inputs.InputService;
import org.example.inputs.info.Exhibition;

public class Engine {

    private final InputService inputService = new InputService();

    public Engine(String[] inputs) {

        this.inputService.validateInputs(inputs);
    }

    public void printMap(Cell[][] map) {

        Exhibition exhibition = (Exhibition) this.inputService.getInput(new Exhibition().getPattern());

        for (Cell[] cells : map) {
            for (int j = 0; j < map[0].length; j++) {

                String exhibitionValue = exhibition.getValue();

                String character = exhibitionValue.equals("l") ? cells[j].getLetter() :
                        exhibitionValue.equals("n") ? cells[j].getNumber() : cells[j].getImage();

                System.out.print(" " + character + " ");
            }
            System.out.println();
        }
    }
}
