package demo.cloud.product.entity;

import java.util.Date;

import com.baomidou.mybatisplus.extension.activerecord.Model;

/**
 * 商品详情信息(SpuDetail)表实体类
 *
 * @author makejava
 * @since 2022-03-03 16:52:14
 */
@SuppressWarnings("serial")
public class SpuDetail extends Model<SpuDetail> {
    //商品id
    private Long spuId;
    //创建时间
    private Date createTime;
    //更新时间
    private Date updateTime;
    //商品详情
    private String detail;


    public Long getSpuId() {
        return spuId;
    }

    public void setSpuId(Long spuId) {
        this.spuId = spuId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }


}

