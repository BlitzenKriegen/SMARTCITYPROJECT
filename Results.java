/**
 *
 */
package SeleniumScraper;

/**
 * @author kiril
 *
 */
public class Results {
    private String resultName;
    private String resultAddress;

    public Results() {
        resultName = null;
        resultAddress = null;
    }

    public String getResultName() {
        return resultName;
    }

    public void setResultName(String resultName) {
        this.resultName = resultName;
    }

    public String getResultAddress() {
        return resultAddress;
    }

    public void setResultAddress(String resultAddress) {
        this.resultAddress = resultAddress;
    }
}
