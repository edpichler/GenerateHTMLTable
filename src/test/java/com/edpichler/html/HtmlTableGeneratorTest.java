package com.edpichler.html;

import java.util.Arrays;
import java.util.Collection;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class HtmlTableGeneratorTest {

    @Parameters
    public static Collection<TableGenerator[]> gensToBeTested() {
        return Arrays.asList(new TableGenerator[][]{
            {new HtmlStringBuilderTableGenerator()},
            {new HtmlDomTableGenerator()}
        });
    }

    private TableGenerator gen;

    public HtmlTableGeneratorTest(TableGenerator gen) {
        this.gen = gen;
    }

    @Test
    public void testNullMatrix() {
        String result = gen.generateHtmlTable(null);
        assertThat(result, is(""));
    }

    @Test
    public void testEmptyMatrix() {
        String result = gen.generateHtmlTable(new String[][]{});
        assertThat(result, is(""));
    }

    @Test
    public void testSimpleMatrix() {
        String result = gen.generateHtmlTable(new String[][]{
            {"Ano", "Vendas"},
            {"1999", "R$ 1.000,00"},
            {"2000", "R$ 2.000,00"}
        });
        assertThat(result, is("<table>"
                + "<thead>"
                + "<tr>"
                + "<th>Ano</th>"
                + "<th>Vendas</th>"
                + "</tr>"
                + "</thead>"
                + "<tbody>"
                + "<tr>"
                + "<td>1999</td>"
                + "<td>R$ 1.000,00</td>"
                + "</tr>"
                + "<tr>"
                + "<td>2000</td>"
                + "<td>R$ 2.000,00</td>"
                + "</tr>"
                + "</tbody>"
                + "</table>"));
    }

    @Test
    @Ignore("TODO")
    public void testJaggedMatrix() {
    }

    @Test
    @Ignore("TODO")
    public void testCellWithHtml() {
    }

}
