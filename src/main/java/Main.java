import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomNode;
import com.gargoylesoftware.htmlunit.html.DomNodeList;
import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static java.util.logging.Logger.*;

public class Main {


    public static void main(String[] args) throws IOException {

        // turn off htmlunit warnings
        getLogger("com.gargoylesoftware.htmlunit").setLevel(java.util.logging.Level.OFF);
        getLogger("org.apache.http").setLevel(java.util.logging.Level.OFF);


        final String currenciesWikipedia = "https://en.wikipedia.org/wiki/List_of_circulating_currencies";
        final WebClient webClient = new WebClient();
        final HtmlPage page = webClient.getPage(currenciesWikipedia);

        final DomNode table = page.querySelector("table.wikitable");
        DomNodeList<DomNode> trs = table.querySelectorAll("tr");

        DomNode thead = trs.get(0);
        List<String> theadColumns = new ArrayList<>(6);
        Iterable<DomNode> children = thead.getChildren();
        for (DomNode child: children) {
            theadColumns.add(child.asText());
        }

        DomNodeList<DomNode> tr = table.querySelectorAll("tr");

        System.out.println(theadColumns);

    }
}
