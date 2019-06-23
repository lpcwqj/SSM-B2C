package pojo;

/**
 * @author Lin
 * @Date  2019/6/14
 */

public class Buser {
    /**
    * 用户编号
    */
    private Integer id;

    /**
    * 用户邮箱
    */
    private String bemail;

    /**
    * 用户密码
    */
    private String bpwd;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBemail() {
        return bemail;
    }

    public void setBemail(String bemail) {
        this.bemail = bemail;
    }

    public String getBpwd() {
        return bpwd;
    }

    public void setBpwd(String bpwd) {
        this.bpwd = bpwd;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", bemail=").append(bemail);
        sb.append(", bpwd=").append(bpwd);
        sb.append("]");
        return sb.toString();
    }
}