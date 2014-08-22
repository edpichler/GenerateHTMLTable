package com.edpichler.html;

import junit.framework.TestCase;
import org.junit.Test;

import java.io.File;
import java.io.FileWriter;

/**
 * Test generating BLUE_TABLE_WITH_DIVS style.
 * */
public class TableGeneratorImplTest1 {

    /**
     * Generate table with 10 columns and 10 rows.
     * @throws Exception
     */
    @Test
    public void testGenerateHtmlTable() throws Exception {
        String[][] matrix = new String[10][10];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = "Line:" + i + "; Column:" + j;
            }
        }

        String x = new TableGeneratorImpl().generateHtmlTable(matrix, TableStyle.BLUE_TABLE_WITH_DIVS).toString();
//        FileWriter fileWriter = new FileWriter(new File("test.html"));
//        fileWriter.write(x);
//        fileWriter.close();
    }

    /**
     * Generate example table
     * @throws Exception
     */
    @Test
    public void testGenerateExampleHtmlTable() throws Exception {
        String[][] matrix = new String[4][3];
        matrix[0][0] = "Country";
        matrix[0][1] = "Language";
        matrix[0][2] = "Currency";

        matrix[1][0] = "Brazil";
        matrix[1][1] = "Portuguese";
        matrix[1][2] = "Real";

        matrix[2][0] = "Germany";
        matrix[2][1] = "Deutsch";
        matrix[2][2] = "Euro";

        matrix[3][0] = "United States of America";
        matrix[3][1] = "English";
        matrix[3][2] = "Dollar";

        String x = new TableGeneratorImpl().generateHtmlTable(matrix, TableStyle.BLUE_TABLE_WITH_DIVS).toString();
//        FileWriter fileWriter = new FileWriter(new File("countries.html"));
//        fileWriter.write(x);
//        fileWriter.close();
    }
}