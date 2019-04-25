import java.util.ArrayList;
import java.util.List;

public class Currency {

    private String name;
    private String symbol;
    private String ISOCode;
    private String fractionalUnit;
    private Integer fractals;

    private List<Country> countries = new ArrayList<>();

    public Currency(String name, String symbol, String ISOCode, String fractionalUnit, Integer fractals) {
        this.name = name;
        this.symbol = symbol;
        this.ISOCode = ISOCode;
        this.fractionalUnit = fractionalUnit;
        this.fractals = fractals;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getISOCode() {
        return ISOCode;
    }

    public void setISOCode(String ISOCode) {
        this.ISOCode = ISOCode;
    }

    public String getFractionalUnit() {
        return fractionalUnit;
    }

    public void setFractionalUnit(String fractionalUnit) {
        this.fractionalUnit = fractionalUnit;
    }

    public Integer getFractals() {
        return fractals;
    }

    public void setFractals(Integer fractals) {
        this.fractals = fractals;
    }

    public List<Country> getCountries() {
        return countries;
    }

    public void setCountries(List<Country> countries) {
        this.countries = countries;
    }
}
