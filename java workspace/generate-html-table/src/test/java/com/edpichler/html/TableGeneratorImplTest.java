package com.edpichler.html;

import junit.framework.TestCase;
import org.junit.Test;

import java.io.File;
import java.io.FileWriter;

public class TableGeneratorImplTest {

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

        String x = new TableGeneratorImpl().generateHtmlTable(matrix).toString();
        FileWriter fileWriter = new FileWriter(new File("test.html"));
        fileWriter.write(x);
        fileWriter.close();
    }
}