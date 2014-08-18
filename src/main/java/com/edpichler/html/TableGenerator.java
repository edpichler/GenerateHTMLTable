package com.edpichler.html;

/**
 * Interface for the HTML Table generator.
 */

public interface TableGenerator {

    /**
     * Generates an HTML Table using the content of the matrix.<br/>
     * The first row of the matrix represents the table header, other rows the data.
     *
     * @param matrix the table content.
     * @return a String with the HTML Table code. Inline CSS.
     */
    public String generateHtmlTable(String[][] matrix);

}
