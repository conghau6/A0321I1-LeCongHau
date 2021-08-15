package _16_io_text_file.bai_tap.optional_doc_file_csv;

public class Country {
    private String startIp;
    private String endIp;
    private String numStart;
    private String numEnd;
    private String countryCode;
    private String country;

    public Country() {
    }

    public Country(String startIp, String endIp, String numStart, String numEnd, String countryCode, String country) {
        this.startIp = startIp;
        this.endIp = endIp;
        this.numStart = numStart;
        this.numEnd = numEnd;
        this.countryCode = countryCode;
        this.country = country;
    }

    public String getStartIp() {
        return startIp;
    }

    public void setStartIp(String startIp) {
        this.startIp = startIp;
    }

    public String getEndIp() {
        return endIp;
    }

    public void setEndIp(String endIp) {
        this.endIp = endIp;
    }

    public String getNumStart() {
        return numStart;
    }

    public void setNumStart(String numStart) {
        this.numStart = numStart;
    }

    public String getNumEnd() {
        return numEnd;
    }

    public void setNumEnd(String numEnd) {
        this.numEnd = numEnd;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Country{" +
                "startIp='" + startIp + '\'' +
                ", endIp='" + endIp + '\'' +
                ", numStart='" + numStart + '\'' +
                ", numEnd='" + numEnd + '\'' +
                ", countryCode='" + countryCode + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
