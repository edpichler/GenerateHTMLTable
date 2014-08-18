package com.edpichler.html;

import junit.framework.TestCase;
import org.junit.Test;

public class DomElementTest_table {

    public static final String CSS_STYLE_COLUMN_HEADER1 = "display: table-cell; padding: 6px 12px;";
    public static final String CSS_STYLE_CELL = "display: table-cell; padding: 6px 12px;";
    public static final String CSS_STYLE_ROW_1 = "display: table-row; background-color: #f6f6f6;";
    public static final String CSS_STYLE_BODY = "font-family: 'Helvetica Neue', Helvetica, Arial; font-size: 11px; line-height: 20px; font-weight: 400; color: #3b3b3b; -webkit-font-smoothing: antialiased; font-smoothing: antialiased; background-color: #2b2b2b;";
    public static final String CSS_STYLE_HEAD = "display: table-row; font-weight: 900; color: white; background-color: #2980b9;";
    public static final String CSS_STYLE_WRAPPER = "width: 100%; box-shadow: 0 1px 3px rgba(0, 0, 0, 0.2); display: table; margin: 0 0 40px;";

    /**
     * Test calling the toString Method with Dom elements.
     * @throws Exception
     */
    @Test
    public void testToString() throws Exception {

        DomElement html = new DomElement("html");
        DomElement body = new DomElement("body");
        body.setCssStyle(CSS_STYLE_BODY);

        DomElement divWrapper = body.addChild("div");
        divWrapper.setCssStyle("max-width: 800px; margin: 0 auto; padding: 40px;");

        DomElement divTable = divWrapper.addChild("div");
        divTable.setCssStyle(CSS_STYLE_WRAPPER);

        DomElement divHead = divTable.addChild("div");
        divHead.setCssStyle(CSS_STYLE_HEAD);

        DomElement columnHead1 = divHead.addChild("div");
        columnHead1.setCssStyle(CSS_STYLE_COLUMN_HEADER1);
        columnHead1.setContent("Vôo");

        DomElement columnHead2 = divHead.addChild("div");
        columnHead2.setCssStyle(CSS_STYLE_COLUMN_HEADER1);
        columnHead2.setContent("Aeroporto de partida");

        DomElement columnHead3 = divHead.addChild("div");
        columnHead3.setCssStyle(CSS_STYLE_COLUMN_HEADER1);
        columnHead3.setContent("Aeroporto de chegada");


        DomElement columnHead4 = divHead.addChild("div");
        columnHead4.setCssStyle(CSS_STYLE_COLUMN_HEADER1);
        columnHead4.setContent("Horário de partida");

        DomElement columnHead5 = divHead.addChild("div");
        columnHead5.setCssStyle(CSS_STYLE_COLUMN_HEADER1);
        columnHead5.setContent("Horário de chegada");

        DomElement divRow = divTable.addChild("div");
        divRow.setCssStyle(CSS_STYLE_ROW_1);

        DomElement divCell1 = divRow.addChild("div");
        divCell1.setCssStyle(CSS_STYLE_CELL);
        divCell1.setContent("Tam 2321");

        DomElement divCell2 = divRow.addChild("div");
        divCell2.setCssStyle(CSS_STYLE_CELL);
        divCell2.setContent(" Stuttgart Airport (STR)<br/>Stuttgart, Germany");

        DomElement divCell3 = divRow.addChild("div");
        divCell3.setCssStyle(CSS_STYLE_CELL);
        divCell3.setContent("Munich Airport (MUC)<br/>Munich, Bavaria, Germany");

        DomElement divCell4 = divRow.addChild("div");
        divCell4.setCssStyle(CSS_STYLE_CELL);
        divCell4.setContent("Ter 23/Mar 10:50");

        DomElement divCell5 = divRow.addChild("div");
        divCell5.setCssStyle(CSS_STYLE_CELL);
        divCell5.setContent("19:50");

        html.addChild(body);
        System.out.println(html);
   }

    /**
     * Test calling toString methods with null tagname.
     * @throws Exception
     */
    @Test(expected = IllegalArgumentException.class)
    public void testToStringNull() {
        new DomElement(null);
    }
}