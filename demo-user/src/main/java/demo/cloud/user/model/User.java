package demo.cloud.user.model;


import demo.cloud.common.core.model.BaseModel;
import lombok.Data;

import java.io.Serializable;

/**
 * 用户表
 *
 * @author YXF
 * @date 2020-12-08 11:18:04
 */
@Data
public class User extends BaseModel implements Serializable{
    private static final long serialVersionUID = 1L;

	public static final String DISTRIBUTED_ID_KEY = "mall4cloud-user";

    /**
     * ID
     */
    private Long userId;

    /**
     * 用户昵称
     */
    private String nickName;

    /**
     * 头像图片路径
     */
    private String pic;

    /**
     * 状态 1 正常 0 无效
     */
    private Integer status;


}
