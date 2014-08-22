package com.edpichler.html;

/**
 * Created by eduardo.pichler on 22/08/2014.
 */
public enum TableStyle {
    /**
     * Blue table just using DIV tags (not table) and CSS to show tabular data (unfortunately not supported in old mail clients).
     */
    BLUE_TABLE_WITH_DIVS,
    /**
     * Blue table. Aupported in old mail clients. (Tested in Litmus.com).
     */
    BLUE_TABLE
}
