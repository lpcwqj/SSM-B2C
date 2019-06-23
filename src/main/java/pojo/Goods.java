package pojo;

/**
 * @author Lin
 * @Date  2019/6/14
 */

public class Goods {
    /**
    * 商品编号
    */
    private Integer id;

    /**
    * 商品名称
    */
    private String gname;

    /**
    * 原价
    */
    private Double goprice;

    /**
    * 现价
    */
    private Double grprice;

    /**
    * 库存
    */
    private Integer gstore;

    /**
    * 商品图片
    */
    private String gpicture;

    /**
    * 商品类型编号
    */
    private Integer goodstypeId;

    //商品购买数量
    private int shoppingnum;

    //商品类型名称
    private String typename;

    //订单中一条商品的价格
    private Double smallsum;

    public Double getSmallsum() {
        return this.getGrprice()*this.getShoppingnum();
    }

    public void setSmallsum(Double smallsum) {
        this.smallsum = smallsum;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

    public int getShoppingnum() {
        return shoppingnum;
    }

    public void setShoppingnum(int shoppingnum) {
        this.shoppingnum = shoppingnum;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }

    public Double getGoprice() {
        return goprice;
    }

    public void setGoprice(Double goprice) {
        this.goprice = goprice;
    }

    public Double getGrprice() {
        return grprice;
    }

    public void setGrprice(Double grprice) {
        this.grprice = grprice;
    }

    public Integer getGstore() {
        return gstore;
    }

    public void setGstore(Integer gstore) {
        this.gstore = gstore;
    }

    public String getGpicture() {
        return gpicture;
    }

    public void setGpicture(String gpicture) {
        this.gpicture = gpicture;
    }

    public Integer getGoodstypeId() {
        return goodstypeId;
    }

    public void setGoodstypeId(Integer goodstypeId) {
        this.goodstypeId = goodstypeId;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", gname='" + gname + '\'' +
                ", goprice=" + goprice +
                ", grprice=" + grprice +
                ", gstore=" + gstore +
                ", gpicture='" + gpicture + '\'' +
                ", goodstypeId=" + goodstypeId +
                ", shoppingnum=" + shoppingnum +
                ", typename='" + typename + '\'' +
                ", smallsum=" + smallsum +
                '}';
    }
}