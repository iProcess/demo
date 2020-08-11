package com.example.demo.file;

import lombok.Data;

import java.io.Serializable;

/**
 * @title: MemberCardConfig
 * @description: 黄金流程 领卡入口信息
 * @date 2020/05/08
 */
@Data
public class MemberCardConfig implements Serializable {

  private static final long serialVersionUID = -2707556004080369715L;

  /**
   * 会员体系ID
   */
  private Long brandsId;

  /**
   * 会员文案
   */
  private String memberTitle;

  /**
   * 非会员文案
   */
  private String nonmemberTitle;

  /**
   * 新老品牌标识
   * 1-老品牌
   * 2-新品牌
   */
  private Integer newOldFlag;


}
