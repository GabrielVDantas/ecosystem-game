package org.example.cells;

import org.example.cells.info.Rock;

import java.util.Arrays;
import java.util.List;

public class CellService {

    private final List<Cell> domain = List.of(
        new Rock()
    );

    private final CellRegistry cellRegistry = new CellRegistry(domain);

    private Cell[][] map;

    public Cell[][] turnSeedIntoMap(String seed, int width, int height) {

        Cell[][] map = new Cell[width][height];

        for (int i = 0; i < seed.length(); i++) {
            String character = String.valueOf(seed.charAt(i));

            for (int j = 0; j < width; j++) {
                for (int k = 0; k < height; k++) {

                    if (character.equals("#")) k++;

                    else {
                        Cell cell = this.cellRegistry.getCellBasedOnCharacter(character);
                        map[j][k] = cell;
                    }
                }
            }
        }

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                if (map[i][j] == null) {
                    map[i][j] = new Rock();
                }
            }
        }

        return map;
    }
}
