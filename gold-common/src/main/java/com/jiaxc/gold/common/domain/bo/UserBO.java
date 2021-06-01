package com.jiaxc.gold.common.domain.bo;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author ratel
 * @version 1.0
 * @description:
 * @date 2021/4/18 18:12
 */
@Data
@Accessors(chain = true)
public class UserBO extends BaseBO{
    private String username;
    private Long id;
    private String ip;
}
