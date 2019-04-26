import com.gargoylesoftware.htmlunit.Page;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomNode;
import com.gargoylesoftware.htmlunit.html.DomNodeList;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.w3c.dom.NamedNodeMap;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WikiCurrencyDetails {

    static List<String> currencyDetailsList = new ArrayList<>();

    final String currenciesWikipedia = "https://en.wikipedia.org/wiki/List_of_circulating_currencies";
    final String currencyDetail = "https://en.wikipedia.org/wiki/Abkhazian_apsar";
    final WebClient webClient = new WebClient();


    public void getMainCurrencyPage() throws IOException {
        HtmlPage page = webClient.getPage(currenciesWikipedia);
        final DomNode table = page.querySelector("table.wikitable");
        DomNodeList<DomNode> trs = table.querySelectorAll("tr");

        DomNode thead = trs.get(0);
        List<String> theadColumns = new ArrayList<>(6);
        Iterable<DomNode> children = thead.getChildren();
        for (DomNode child: children) {
            theadColumns.add(child.asText());
        }

        DomNodeList<DomNode> trList = table.querySelectorAll("tr");



        for (DomNode trNode: trList) {
            System.out.println("TR: "+trNode.getIndex());

            // zobaczmy ile td'ków ma row
            String[] split = trNode.asText().split("\t");


            DomNodeList<DomNode> tds = trNode.querySelectorAll("td");

            for (DomNode td: tds) {
                // sprawdz czy td at index 1 hasRowSpan=...
//                int rowspan = 0;
//                if (td.getIndex() == 1) {
//                    NamedNodeMap attributes = td.getAttributes();
//                    if (attributes.getNamedItem("rowspan") != null) {
//                        rowspan = Integer.parseInt(attributes.getNamedItem("rowspan").getNodeValue());
//                        System.out.println("mamy rowspan: " + attributes.getNamedItem("rowspan").getNodeValue());
//                    }
//                }
                String tdText = td.asText();
                System.out.print("\t\ttd:"+td.getIndex() + " " + tdText + "\t");

                if ( split.length == 6 && td.getIndex() == 3) {

                    // pobierz href z 3
                    getAHrefAttr(td);
                }

                if (split.length == 5 && td.getIndex() == 1) {
                    // pobierz href z 1
                    getAHrefAttr(td);
                }
            }

            System.out.println();
        }

        System.out.println();

        System.out.println(currencyDetailsList.size());
    }

    private static void getAHrefAttr(DomNode td) {
        DomNode a = td.querySelector("a");
        if (a == null) return;
        NamedNodeMap a_attributes = a.getAttributes();
        if (a_attributes.getNamedItem("href") != null) {
            String href = a_attributes.getNamedItem("href").getNodeValue();
            currencyDetailsList.add(href);
            System.out.print(href + "\t\t");
        }
    }

    public void getDetailedPage() throws IOException {
        final HtmlPage page = webClient.getPage(currencyDetail);
        DomNodeList<DomNode> tr_thList = page.querySelectorAll("tr th");

        for (DomNode trth: tr_thList) {
            if (trth.asText().contains("Banknotes")) {
                DomNode parentNode = trth.getParentNode();
                Iterable<DomNode> children = parentNode.getChildren();

                for (DomNode ch: children) {
                    System.out.print(ch.asText() + "\t\t");
                }
                System.out.println();
            }

            if (trth.asText().contains("Coins")) {
                DomNode parentNode = trth.getParentNode();
                Iterable<DomNode> children = parentNode.getChildren();

                for (DomNode ch: children) {
                    System.out.print(ch.asText() + "\t\t");
                }
                System.out.println();
            }
        }

    }
}
