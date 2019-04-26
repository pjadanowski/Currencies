import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomNode;
import com.gargoylesoftware.htmlunit.html.DomNodeList;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.w3c.dom.NamedNodeMap;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static java.util.logging.Logger.*;

public class Main {

    static List<String> currencyDetailsList = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        // turn off htmlunit warnings
        getLogger("com.gargoylesoftware.htmlunit").setLevel(java.util.logging.Level.OFF);
        getLogger("org.apache.http").setLevel(java.util.logging.Level.OFF);



        final WebClient webClient = new WebClient();
//        final HtmlPage page = webClient.getPage(currenciesWikipedia);

        WikiCurrencyDetails wikiCurrencyDetails = new WikiCurrencyDetails();
        wikiCurrencyDetails.getDetailedPage();



    }


}
