package com.jiaxc.gold.base.log.model.po;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import lombok.Data;

/**
    * API日志
    */
@ApiModel(value="com-jiaxc-gold-base-model-po-ApiLog")
@Data
@TableName(value = "api_log")
public class ApiLog extends BasePO{
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value="")
    private Long id;

    /**
     * 用户ID
     */
    @TableField(value = "user_id",fill = FieldFill.INSERT)
    @ApiModelProperty(value="用户ID")
    private Long userId;

    /**
     * IP
     */
    @TableField(value = "ip",fill = FieldFill.INSERT)
    @ApiModelProperty(value="IP")
    private String ip;

    /**
     * 操作系统
     */
    @TableField(value = "os",fill = FieldFill.INSERT)
    @ApiModelProperty(value="操作系统")
    private String os;

    /**
     * 浏览器
     */
    @TableField(value = "brower",fill = FieldFill.INSERT)
    @ApiModelProperty(value="浏览器")
    private String brower;

    /**
     * 操作类型
     */
    @TableField(value = "option_type",fill = FieldFill.INSERT)
    @ApiModelProperty(value="操作类型")
    private String optionType;

    /**
     * 请求结果
     */
    @TableField(value = "success",fill = FieldFill.INSERT)
    @ApiModelProperty(value="请求结果")
    private Boolean success;

    /**
     * 错误编码
     */
    @TableField(value = "code",fill = FieldFill.INSERT)
    @ApiModelProperty(value="错误编码")
    private String code;

    /**
     * 请求时间
     */
    @TableField(value = "request_time")
    @ApiModelProperty(value="请求时间")
    private Date requestTime;

    /**
     * 响应时间
     */
    @TableField(value = "response_time")
    @ApiModelProperty(value="响应时间")
    private Date responseTime;

    /**
     * API描述
     */
    @TableField(value = "desc",fill = FieldFill.INSERT)
    @ApiModelProperty(value="API描述")
    private String desc;

    /**
     * 执行耗时
     */
    @TableField(value = "elapsed_time",fill = FieldFill.INSERT)
    @ApiModelProperty(value="执行耗时")
    private Long elapsedTime;

    /**
     * 请求参数
     */
    @TableField(value = "request_args",fill = FieldFill.INSERT)
    @ApiModelProperty(value="请求参数")
    private String requestArgs;

    /**
     * 响应参数
     */
    @TableField(value = "response_result")
    @ApiModelProperty(value="响应参数")
    private String responseResult;

    /**
     * 创建时间
     */
    @TableField(value = "create_time",fill = FieldFill.INSERT)
    @ApiModelProperty(value="创建时间")
    private Date createTime;

    private static final long serialVersionUID = 1L;

    public static final String COL_ID = "id";

    public static final String COL_USER_ID = "user_id";

    public static final String COL_IP = "ip";

    public static final String COL_OS = "os";

    public static final String COL_BROWER = "brower";

    public static final String COL_OPTION_TYPE = "option_type";

    public static final String COL_SUCCESS = "success";

    public static final String COL_CODE = "code";

    public static final String COL_REQUEST_TIME = "request_time";

    public static final String COL_RESPONSE_TIME = "response_time";

    public static final String COL_DESC = "desc";

    public static final String COL_ELAPSED_TIME = "elapsed_time";

    public static final String COL_REQUEST_ARGS = "request_args";

    public static final String COL_RESPONSE_RESULT = "response_result";

    public static final String COL_CREATE_TIME = "create_time";
}