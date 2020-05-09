package com.example.demo.file;

import lombok.Data;

import java.io.Serializable;

/**
 * @title: MemberCardConfig
 * @projectName pop-crm
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
   * 开卡页面跳转链接
   * 如："http://membercard.m.jd.com/?jdreactkey=JDReactCardPackage&rn_brandId=100000000000115&rn_channelId=401&rn_returnUrl="
   */
  private String openCardUrl;


}
