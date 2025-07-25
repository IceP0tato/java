package examples.assignment.ex_dookdak.model.dto;

public class ProductDto {
    private int pId, pPrice, count;
    private String pUser, pName, pDesc, pPw, pDate;
    private boolean isSold;

    public ProductDto() {
    }

    public ProductDto(String pUser, int count) {
        this.pUser = pUser;
        this.count = count;
    }

    public ProductDto(int pId, String pName, String pDesc, int pPrice) {
        this.pId = pId;
        this.pName = pName;
        this.pDesc = pDesc;
        this.pPrice = pPrice;
    }

    public ProductDto(int pId, String pUser, String pName, int pPrice, boolean isSold, String pDate) {
        this.pId = pId;
        this.pUser = pUser;
        this.pName = pName;
        this.pPrice = pPrice;
        this.isSold = isSold;
        this.pDate = pDate;
    }

    public ProductDto(int pId, int pPrice, String pUser, String pName, String pDesc, String pPw, String pDate, boolean isSold) {
        this.pId = pId;
        this.pPrice = pPrice;
        this.pUser = pUser;
        this.pName = pName;
        this.pDesc = pDesc;
        this.pPw = pPw;
        this.pDate = pDate;
        this.isSold = isSold;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getpId() {
        return pId;
    }

    public void setpId(int pId) {
        this.pId = pId;
    }

    public int getpPrice() {
        return pPrice;
    }

    public void setpPrice(int pPrice) {
        this.pPrice = pPrice;
    }

    public String getpUser() {
        return pUser;
    }

    public void setpUser(String pUser) {
        this.pUser = pUser;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getpDesc() {
        return pDesc;
    }

    public void setpDesc(String pDesc) {
        this.pDesc = pDesc;
    }

    public String getpPw() {
        return pPw;
    }

    public void setpPw(String pPw) {
        this.pPw = pPw;
    }

    public String getpDate() {
        return pDate;
    }

    public void setpDate(String pDate) {
        this.pDate = pDate;
    }

    public boolean isSold() {
        return isSold;
    }

    public void setSold(boolean sold) {
        isSold = sold;
    }

    @Override
    public String toString() {
        return "ProductDto{" +
                "pId=" + pId +
                ", pPrice=" + pPrice +
                ", pUser='" + pUser + '\'' +
                ", pName='" + pName + '\'' +
                ", pDesc='" + pDesc + '\'' +
                ", pPw='" + pPw + '\'' +
                ", pDate='" + pDate + '\'' +
                ", isSold=" + isSold +
                '}';
    }
}
