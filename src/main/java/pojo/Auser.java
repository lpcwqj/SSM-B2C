package pojo;

/**
 * @author Lin
 * @Date  2019/6/14
 */

public class Auser {
    /**
    * 管理员名字
    */
    private String aname;

    /**
    * 管理员密码
    */
    private String apwd;

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public String getApwd() {
        return apwd;
    }

    public void setApwd(String apwd) {
        this.apwd = apwd;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", aname=").append(aname);
        sb.append(", apwd=").append(apwd);
        sb.append("]");
        return sb.toString();
    }
}