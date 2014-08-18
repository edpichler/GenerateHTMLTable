package com.edpichler.html;

import java.io.StringWriter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

public class HtmlDomTableGenerator implements TableGenerator {

    @Override
    public String generateHtmlTable(String[][] matrix) {
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            Document doc = createTable(docBuilder, matrix);

            DOMSource source = new DOMSource(doc);
            StringWriter buffer = new StringWriter();
            StreamResult result = new StreamResult(buffer);

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "no");
            transformer.setOutputProperty(OutputKeys.METHOD, "html");
            transformer.transform(source, result);

            return buffer.toString();
        } catch (ParserConfigurationException | NullPointerException | TransformerException ex) {
            return "";
        }
    }

    private Document createTable(DocumentBuilder docBuilder, String[][] matrix) throws DOMException {
        Document doc = docBuilder.newDocument();

        if (matrix.length > 0) {
            Element table = doc.createElement("table");
            doc.appendChild(table);

            createThead(doc, table, matrix);
            createTbody(doc, table, matrix);
        }

        return doc;
    }

    private void createThead(Document doc, Element table, String[][] matrix) throws DOMException {
        Element thead = doc.createElement("thead");
        table.appendChild(thead);

        createTr(doc, thead, matrix[0], "th");
    }

    private void createTbody(Document doc, Element table, String[][] matrix) throws DOMException {
        Element tbody = doc.createElement("tbody");
        table.appendChild(tbody);

        for (int i = 1; i < matrix.length; i++) {
            createTr(doc, tbody, matrix[i], "td");
        }
    }

    private void createTr(Document doc, Element thead, String[] line, String thtd) throws DOMException {
        Element tr = doc.createElement("tr");
        thead.appendChild(tr);

        for (String cell : line) {
            Element thtdElement = doc.createElement(thtd);
            tr.appendChild(thtdElement);

            Text text = doc.createTextNode(cell);
            thtdElement.appendChild(text);
        }
    }

}
