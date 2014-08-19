package com.edpichler.html;

/**
 * Created by eduardo.pichler on 18/08/2014.
 */
public class TableGeneratorImpl implements TableGenerator {

    public static final String CSS_STYLE_COLUMN_HEADER = "display: table-cell; padding: 6px 12px;";
    public static final String CSS_STYLE_CELL = "display: table-cell; padding: 6px 12px;";
    public static final String CSS_STYLE_ROW_1 = "display: table-row; background-color: #f6f6f6;";
    public static final String CSS_STYLE_ROW_2 = "display: table-row; background-color: #e9e9e9;";
    public static final String CSS_STYLE_WRAPPER = "font-family: 'Helvetica Neue', Helvetica, Arial; font-size: 11px; line-height: 20px; font-weight: 400; -webkit-font-smoothing: antialiased; font-smoothing: antialiased; max-width: 800px; margin: 0 auto;";
    public static final String CSS_STYLE_HEAD = "display: table-row; font-weight: 900; color: white; background-color: #2980b9;";
    public static final String CSS_STYLE_TABLE = "width: 100%; box-shadow: 0 1px 3px rgba(0, 0, 0, 0.2); display: table; margin: 0 0 40px;";

    @Override
    public String generateHtmlTable(String[][] matrix) {

        //html base

        DomElement divWrapper = new DomElement("div");
        divWrapper.setCssStyle(CSS_STYLE_WRAPPER);

        //table
        DomElement divTable = divWrapper.addChild("div");
        divTable.setCssStyle(CSS_STYLE_TABLE);

        //table header
        String headers[] = matrix[0];
        DomElement divColumnHeaders = createColumnHeaders(headers);
        divTable.addChild(divColumnHeaders);

        //table data
        for (int i = 1; i < matrix.length; i++) {
            DomElement divRow = createTableRow(matrix[i]);
            if(i % 2 != 0) {
                divRow.setCssStyle(CSS_STYLE_ROW_1);
            }else{
                divRow.setCssStyle(CSS_STYLE_ROW_2);
            }
            divTable.addChild(divRow);
        }
        return divWrapper.toString();
    }

    private DomElement  createTableRow(String[] rows) {
        DomElement divRow = new DomElement("div");
        for (String row : rows) {
            DomElement cell = divRow.addChild("div");
            cell.setContent(row);
            cell.setCssStyle(CSS_STYLE_CELL);
        }
        return divRow;
    }

    private DomElement createColumnHeaders(String[] headers) {
        DomElement divHead = new DomElement("div");
        divHead.setCssStyle(CSS_STYLE_HEAD);
        for (String column : headers) {
            DomElement columnHead = divHead.addChild("div");
            columnHead.setCssStyle(CSS_STYLE_COLUMN_HEADER);
            columnHead.setContent(column);
        }
        return divHead;
    }
}
