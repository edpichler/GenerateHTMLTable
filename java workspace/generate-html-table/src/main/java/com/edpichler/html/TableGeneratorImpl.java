package com.edpichler.html;

import com.edpichler.html.factory.BlueTableWithDivsCreator;
import com.edpichler.html.factory.BlueTableWithoutDivsCreator;

/**
 * Created by eduardo.pichler on 18/08/2014.
 */
public class TableGeneratorImpl implements TableGenerator {
    @Override
    public String generateHtmlTable(String[][] matrix, TableStyle style) {
        switch (style) {
            case BLUE_TABLE:
                return new BlueTableWithoutDivsCreator().createHTML(matrix);
            case BLUE_TABLE_WITH_DIVS:
                return new BlueTableWithDivsCreator().createHTML(matrix);
        }
        return null;
    }
}
