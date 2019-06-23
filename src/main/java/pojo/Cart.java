package pojo;

/**
 * @author Lin
 * @Date  2019/6/14
 */

public class Cart {
    /**
    * 购物车编号
    */
    private Integer id;

    /**
    * 用户编号
    */
    private Integer buserId;

    /**
    * 商品编号
    */
    private Integer goodsId;

    /**
    * 购买数量
    */
    private Integer shoppingnum;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBuserId() {
        return buserId;
    }

    public void setBuserId(Integer buserId) {
        this.buserId = buserId;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getShoppingnum() {
        return shoppingnum;
    }

    public void setShoppingnum(Integer shoppingnum) {
        this.shoppingnum = shoppingnum;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", buserId=").append(buserId);
        sb.append(", goodsId=").append(goodsId);
        sb.append(", shoppingnum=").append(shoppingnum);
        sb.append("]");
        return sb.toString();
    }
}