package pojo;

/**
 * @author Lin
 * @Date  2019/6/14
 */

public class Orderdetail {
    /**
    * 订单详情编号
    */
    private Integer id;

    /**
    * 订单基础编号
    */
    private Integer orderbaseId;

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

    public Integer getOrderbaseId() {
        return orderbaseId;
    }

    public void setOrderbaseId(Integer orderbaseId) {
        this.orderbaseId = orderbaseId;
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
        sb.append(", orderbaseId=").append(orderbaseId);
        sb.append(", goodsId=").append(goodsId);
        sb.append(", shoppingnum=").append(shoppingnum);
        sb.append("]");
        return sb.toString();
    }
}