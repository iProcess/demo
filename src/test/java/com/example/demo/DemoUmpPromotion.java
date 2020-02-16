package com.example.demo;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.*;

public class DemoUmpPromotion {

    public static void main(String[] args) {
        String token = "ca709bdffe613bf4bd20a5f14cd7acd8";
        String restfulURL = "http://open.ump.jd.com/queryMonitorData";

        String scopeValues[] = new String[]{
                "pop-crm.soa.method.ShopLevelRuleServiceImpl.getShopLevelRule",
                "pop-crm.soa.method.VenderShopServiceImpl.getShopLevelRule",
                "pop-crm.soa.method.O2OCustomerServiceImpl.getO2OCustomerInfo",
                "pop-crm.soa.method.VenderShopServiceImpl.getShopLevelRuleDiscount",
                "pop-crm.soa.method.VenderCustomerClientServiceImpl.getCustomer",
                "pop-crm.soa.method.O2OCustomerBasicJsfServiceImpl.getO2OCustomerInfo",
                "pop-crm.soa.method.VenderShopServiceImpl.isOpenedCustomer",
                "pop-crm.soa.method.OpenFunctionServiceImpl.getCrmServiceControlByUniqueKey",
                "pop-crm.soa.method.O2OCustomerReadDaoImpl.getO2OCustomerInfo",
                "pop-crm.method.VenderCustomerShopServiceImpl.getCustomerList",
                "pop-vender-customer.soa.method.BrandMemberBasicJsfServiceImpl.getMemberBasicInfo",
                "pop-crm.soa.method.O2OCustomerBasicJsfServiceImpl.getO2OCustomerInfoAllStatus",
                "pop-crm.soa.method.O2OCustomerServiceImpl.getO2OCustomerInfoAllStatus",
                "pop-crm.soa.method.O2OCustomerBasicJsfServiceImpl.getO2OCustomerInfoByPin",
                "pop-crm.soa.method.O2OCustomerServiceImpl.getO2OCustomerInfoListByPin",
                "pop-crm.soa.method.O2OCustomerBasicJsfServiceImpl.getBindedO2OCustomerInfoByPin",
                "pop-crm.method.VenderCustomerShopServiceImpl.getCustomerListScan",
                "pop-crm.method.VenderCustomerShopServiceImpl.getCustomer",
                "pop-crm.soa.method.VenderCustomerClientServiceImpl.getOriginalCustomer",
                "points.soa.method.CustomerPointsManagerImpl.savePointsWithDetail",
                "points.soa.method.CrmPointsServiceImpl.getCouponInfoForC",
                "points.soa.method.CrmPointsServiceImpl.isPointsEnabledForC",
                "point.soa.method.PointsDetailsServiceImpl.ifBusinessIdExist",
                "points.soa.method.PointsSendService.sendPoints",
                "points.soa.method.PointsReadServiceImpl.getGiftSkuByPromoId",
                "points.soa.method.PointsReadServiceImpl.queryValidSku",
                "points.soa.method.PointsExchangeGiftSkuService.getValidSku",
                "point.soa.method.PointsExchangeActivityService.loadActivityResourceInfo.",
                "points.soa.method.CrmPointsServiceImpl.getCustomerPoints",
                "points.soa.method.BrandsRpcImpl.getBrandsId",
                "points.soa.method.BrandsRpcImpl.getBrandsInfoByBrandsId",
                "points.soa.method.CrmPointsServiceImpl.getCustomerPointsWithExpired",
                "points.soa.method.PointRetrieveServiceImpl.isPointsEnabled",
                "points.soa.method.BasePointWriteService.sendPoints",
                "point.soa.method.PointsCouponManagerImpl.getCouponByCouponId",
                "point.soa.method.OfflineCustomerPointServiceImpl.getOfflineCustomerPoints",
                "points.soa.method.PointsMallInnerServiceImpl.updatePointMallBrandInfo",
                "point.soa.jos.method.PointWriteJsfServiceImpl.sendPoints",
                "point.soa.method.PointsMallQueryServiceImpl.searchPointsActivitiesByBrandId",
                "point.soa.method.PointsExchangeActivityServiceImpl.getPointsActivitiesByBrandId",
                "points.soa.method.PointsValidHbaseDaoImpl.query",
                "points.soa.method.PointWriteJsfServiceImpl.sendPoints",
                "points.soa.method.CrmPointsServiceImpl.getVenderPointsRule",
                "points.soa.method.O2OCustomerServiceRpcImpl.isBindAgain",
                "points.soa.method.CrmPointsServiceImpl.consumePointsWay",
                "points.soa.method.CrmPointsServiceImpl.getCouponInfo",
                "points.soa.method.CrmPointsServiceImpl.getPointsRule",
                "points.soa.method.CrmPointsServiceImpl.isPointsEnabled",
                "points.soa.method.PointsReadServiceImpl.queryInitPointsRule",
                "points.soa.method.PointsReadServiceImpl.queryPointsCouponByDate",
                "points.soa.method.PointsReadServiceImpl.getPointsSumRule",
                "pop-crm.method.PointsVirtualSkuJsfServiceImpl.searchVirtualSkuById",
                "points.soa.method.CrmPointsServiceImpl.sendPoints",
                "points.soa.method.CrmPointsServiceImpl.tradePoints2Coupon",
                "points.soa.method.CrmPointsServiceImpl.tradePoints2Token",
                "point.soa.method.PointsMallQueryServiceImpl.batchSearchBrandActivities",
                "point.soa.method.PointsMallQueryServiceImpl.getActivityExchangeTimes",
                "point.soa.method.PointsMallQueryServiceImpl.getCustomerExchangeNumberInfo",
                "point.soa.method.PointsMallQueryServiceImpl.searchAdvertisingActivityList",
                "point.soa.method.PointsMallQueryServiceImpl.searchBetterBrands",
                "point.soa.method.PointsMallQueryServiceImpl.searchPointsMallActivities",
                "point.soa.method.PointsMallQueryServiceImpl.searchPointsMallActivityById",
                "point.soa.method.PointsMallQueryServiceImpl.searchPointsTradeDetail",
                "point.soa.method.PointsExchangeActivityServiceImpl.getSelfPointsActivitiesByBrandId",
                "point.soa.method.BatchReadRpcServiceImpl.getBatchInfoById.",
                "points.soa.method.RealPriceRpc.byChannel",
                "brands.fans.center.service.BrandsReadJsfServiceImpl.getBrandsVenderByVenderId",
                "brands.fans.center.rpc.ConfigClientServiceImpl.getBrandsIdByIdCache",
                "brands.fans.center.service.BrandsReadJsfServiceImpl.getBrandsByVenderId",
                "brands.fans.center.rpc.ConfigClientServiceImpl.getBrandsIdByVenderIdSwitch",
                "brands.fans.center.service.BrandsReadJsfServiceImpl.getBrandsByIdCache",
                "brands.fans.center.service.BrandsPointsConfigReadJsfServiceImpl.queryBrandsPointConfigByBrandsId",
                "brands.fans.center.service.BrandsOpenGiftActivityAppServiceImpl.getAllOpenGiftActivitys",
                "brands.fans.center.service.BrandsOpenAppJsfServiceImpl.getAllOpenGiftActivitys",
                "brands.fans.center.rpc.ConfigClientServiceImpl.getAllOpenGiftActSwitch",
                "brands.fans.center.service.BrandsReadJsfServiceImpl.getBrandsByAppId",
                "brands.fans.center.service.MemberReadJsfServiceImpl.queryListByCardId",
                "brands.fans.center.service.BrandsRightMappingJsfServiceImpl.getStartLevelMappings",
                "brands.fans.center.rpc.JdMemberServiceImpl.getPlusInfoByJdPin",
                "brands.fans.center.rpc.SamsCardServiceImpl.getSamsCardByJdPin",
                "brands.fans.center.service.BrandsOpenGiftActivityShopServiceImpl.getStartActitvityByBrandId",
                "brands.fans.center.service.BrandsReadJsfServiceImpl.batchQueryBrandsIndfo",
                "brands.fans.center.service.MemberReadJsfServiceImpl.queryListByBrandId",
                "brands.fans.center.service.BrandsFansInfoReadServiceImpl.getOwnCardList",
                "brands.fans.center.service.BrandsOpenAppJsfServiceImpl.queryDrawPrizeResult",
                "brands.fans.center.service.BrandsReadJsfServiceImpl.getBrandsIdByBidRefId",
                "brands.fans.center.rpc.OpenGiftRpcServiceImpl.drawGift",
                "brands.fans.center.service.BrandsReadJsfServiceImpl.getBrandsIdByBidAndrefBrandsId",
                "pop-crm.soa.method.VipCouponLogicService.getCoupons",
                "pop-crm.soa.method.CardHolderJsfService.getCardsByBrandId",
                "pop-crm.soa.method.CrmMerchantService.getShopRuleType",
                "pop-crm.soa.method.ShopGiftDependenceJsfServiceImpl.findGroupModelTaskById",
                "pop-crm.points.method.CrmMemberGroupHbaseServiceImpl.findCrmMemberSwarmByRowkey",
                "pop-crm.soa.method.ShopGiftDependenceJsfServiceImpl.findCrmMemberGroupByUserPin",
                "pop-crm.method.SmartActivityServiceImpl.getEffectiveActivity",
                "pop-crm.soa.method.CardHolderJsfService.checkCustomerInBrand",
                "pop-crm.soa.method.ShopGiftDependenceJsfServiceImpl.findLastGroupModel",
                "pop-crm.soa.method.CrmMemberService.getMembers",
                "pop-crm.soa.method.CrmCustomerServiceImpl.getMemberInVender",
                "pop-crm.soa.method.MarketingSkuService.getMarketingSku",
                "pop-crm.soa.method.MarketingExtendsDao.findAvailableEvtIds",
                "pop-crm.soa.method.CrmMerchantService.isOpenActivity",
                "pop-crm.soa.method.OwnMarketingSkuService.fetchAvailableSku",
                "pop-crm.soa.method.CrmMerchantService.getCustomerStatistics",
                "pop-crm.soa.method.CrmMemberService.getMember",
                "pop-crm.soa.method.CardHolderJsfService.getRights",
                "pop-crm.soa.method.CardHolderJsfService.getStartMappingActivities",
                "pop-crm.soa.method.WalmartSamClubJSFService.getSamClubCardByCustomerPin",
                "pop-crm.soa.method.CardHolderJsfService.getBrandCustomer",
                "pop-crm.soa.method.MarketingSkuService.getMarketingSkuWithPage",
                "pop-crm.soa.method.CardHolderJsfService.getGeneralRights",
                "pop-crm.soa.method.CardHolderService.getNewBindCards",
                "pop-crm.soa.method.CardHolderJsfServiceImpl.getBrandsInfo",
                "pop-crm.soa.method.CardHolderJsfService.getBindCards",
                "pop-crm.soa.method.CardHolderJsfService.getUnBindCards",
                "pop-crm.soa.method.CrmMemberService.getMembersByScan",
                "pop-crm.soa.method.CardHolderJsfService.getBrand"
        };
        List<String> txtLst = new ArrayList<>();
        for(String scopeValue : scopeValues){
            UmpPromotion promotion = new UmpPromotion();
            promotion.setScopeValues(scopeValue);
            promotion.setScope("key");
            promotion.setDagaCycle("oneMinute");
            promotion.setMonitorType("Method");
            promotion.setDataType("TP50,TP90,TP99,TP999,MIN,MAX,AVG,TotalCount,SuccessCount,FailCount,AvailRate");
//            promotion.setStartTime("20181110235000");
//            promotion.setEndTime("20181111002000");
            promotion.setStartTime("20190916000000");
            promotion.setEndTime("20190923000000");
            JSONObject bodyJson = JSONArray.parseObject(Utils.queryMonitorData(restfulURL, JSONObject.toJSONString(promotion), token));
            JSONObject resJosn = bodyJson.getJSONObject("result");
            JSONArray dataArray = resJosn.getJSONArray(promotion.getScopeValues());
            if(dataArray == null){
                continue;
            }
            JSONObject maxObject = new JSONObject();
            long maxTotalCount = 0L;
            for(int i = 0; i < dataArray.size(); i++){
                JSONObject object = dataArray.getJSONObject(i);
                long tempTotalCount = Long.parseLong(object.getString("TotalCount"));
                if(tempTotalCount > maxTotalCount){
                    maxTotalCount = tempTotalCount;
                    maxObject = object;
                }
            }
            StringBuffer bf = new StringBuffer();
            bf.append(promotion.getScopeValues()).append(",")
                    .append(maxObject.getString("TP50")).append(",")
                    .append(maxObject.getString("TP90")).append(",")
                    .append(maxObject.getString("TP99")).append(",")
                    .append(maxObject.getString("TP999")).append(",")
                    .append(maxObject.getString("MAX")).append(",")
                    .append(maxObject.getString("MIN")).append(",")
                    .append(maxObject.getString("AVG")).append(",")
                    .append(maxObject.getString("AvailRate")).append(",")
                    .append(maxObject.getString("TotalCount")).append(",")
                    .append(maxObject.getString("dataTime"));
            txtLst.add(bf.toString());
        }
        Utils.writeFile(txtLst, "promotion-20190916至20190923.txt");

    }


}
