package pojo;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author Lin
 * @Date  2019/6/14
 */

public class Orderbase {
    /**
    * 订单编号
    */
    private Integer id;

    /**
    * 用户编号
    */
    private Integer buserId;

    /**
    * 订单金额
    */
    private Double amount;

    /**
    * 订单状态
    */
    private Byte status;

    /**
    * 下单时间
    */
    private Date orderstate;

    //用户E-mail
    private String bemail;

    public String getBemail() {
        return bemail;
    }

    public void setBemail(String bemail) {
        this.bemail = bemail;
    }

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

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Date getOrderstate() {
        return orderstate;
    }

    public void setOrderstate(Date orderstate) {
        this.orderstate = orderstate;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", buserId=").append(buserId);
        sb.append(", amount=").append(amount);
        sb.append(", status=").append(status);
        sb.append(", orderstate=").append(orderstate);
        sb.append("]");
        return sb.toString();
    }
}