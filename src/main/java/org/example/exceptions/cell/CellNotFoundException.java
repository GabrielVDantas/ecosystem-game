package org.example.exceptions.cell;

public class CellNotFoundException extends RuntimeException {

    public CellNotFoundException(String number) {
        super("Não foi encontrado uma Cell para o seguinte number: " + number);
    }
}
