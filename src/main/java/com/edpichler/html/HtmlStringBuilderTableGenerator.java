package com.edpichler.html;

public class HtmlStringBuilderTableGenerator implements TableGenerator {

    @Override
    public String generateHtmlTable(String[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return "";
        }

        StringBuilder s = new StringBuilder(1024);

        s.append("<table>");
        appendHeader(s, matrix);
        appendBody(s, matrix);
        s.append("</table>");

        return s.toString();
    }

    private void appendHeader(StringBuilder s, String[][] matrix) {
        s.append("<thead>");
        appendLineWithTh(s, matrix[0]);
        s.append("</thead>");
    }

    private void appendBody(StringBuilder s, String[][] matrix) {
        s.append("<tbody>");
        for (int i = 1; i < matrix.length; i++) {
            appendLineWithTd(s, matrix[i]);
        }
        s.append("</tbody>");
    }

    private void appendLineWithTh(StringBuilder s, String[] line) {
        appendLineWith(s, line, "th");
    }

    private void appendLineWithTd(StringBuilder s, String[] line) {
        appendLineWith(s, line, "td");
    }

    private void appendLineWith(StringBuilder s, String[] line, String element) {
        s.append("<tr>");
        for (String cell : line) {
            s.append("<");
            s.append(element);
            s.append(">");
            s.append(cell);
            s.append("</");
            s.append(element);
            s.append(">");
        }
        s.append("</tr>");
    }

}
