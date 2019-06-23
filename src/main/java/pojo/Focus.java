package pojo;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author Lin
 * @Date  2019/6/14
 */

public class Focus {
    /**
    * 关注表的编号
    */
    private Integer id;

    /**
    * 商品编号
    */
    private Integer goodsId;

    /**
    * 用户编号
    */
    private Integer buserId;

    /**
    * 关注时间
    */
    private Date focustime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getBuserId() {
        return buserId;
    }

    public void setBuserId(Integer buserId) {
        this.buserId = buserId;
    }

    public Date getFocustime() {
        return focustime;
    }

    public void setFocustime(Date focustime) {
        this.focustime = focustime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", goodsId=").append(goodsId);
        sb.append(", buserId=").append(buserId);
        sb.append(", focustime=").append(focustime);
        sb.append("]");
        return sb.toString();
    }
}