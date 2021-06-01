create database gold charset='uft8mb4';

-- auto-generated definition
create table api_log
(
    id              bigint auto_increment
        primary key,
    user_id         bigint       default 0                 not null comment '用户ID',
    ip              varchar(20)  default ''                not null comment 'IP',
    os              varchar(20)  default ''                not null comment '操作系统',
    brower          varchar(20)  default ''                not null comment '浏览器',
    option_type     varchar(10)  default ''                not null comment '操作类型',
    success         tinyint(1)   default 0                 not null comment '请求结果',
    code            varchar(10)  default ''                not null comment '错误编码',
    request_time    datetime                               not null comment '请求时间',
    response_time   datetime                               not null comment '响应时间',
    `desc`          varchar(50)  default ''                not null comment 'API描述',
    elapsed_time    bigint       default 0                 not null comment '执行耗时',
    request_args    varchar(255) default ''                not null comment '请求参数',
    response_result text                                   not null comment '响应参数',
    create_time     datetime     default CURRENT_TIMESTAMP null comment '创建时间',
    business_key    varchar(20)  default ''                not null comment '业务ID'
)
    comment 'API日志';

