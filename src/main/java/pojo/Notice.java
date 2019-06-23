package pojo;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author Lin
 * @Date  2019/6/14
 */

public class Notice {
    /**
    * 公告表的编号
    */
    private Integer id;

    /**
    * 公告标题
    */
    private String ntile;

    /**
    * 公告内容
    */
    private String ncontent;

    /**
    * 公告时间
    */
    private Date ntime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNtile() {
        return ntile;
    }

    public void setNtile(String ntile) {
        this.ntile = ntile;
    }

    public String getNcontent() {
        return ncontent;
    }

    public void setNcontent(String ncontent) {
        this.ncontent = ncontent;
    }

    public Date getNtime() {
        return ntime;
    }

    public void setNtime(Date ntime) {
        this.ntime = ntime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", ntile=").append(ntile);
        sb.append(", ncontent=").append(ncontent);
        sb.append(", ntime=").append(ntime);
        sb.append("]");
        return sb.toString();
    }
}