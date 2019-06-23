package pojo;

/**
 * @author Lin
 * @Date  2019/6/14
 */

public class Goodstype {
    /**
    * 商品类型编号
    */
    private Integer id;

    /**
    * 类型名称
    */
    private String typename;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", typename=").append(typename);
        sb.append("]");
        return sb.toString();
    }
}