package com.example.demo.other;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class DemoUmpApp {

    public static void main(String[] args) {

        String restfulURL = "http://open.ump.jd.com/queryMonitorData";
        UmpApp app = new UmpApp();
        app.setMonitorType("AppAllKeyAvgRate");
        app.setAppName("crm.o2ogateway.downstream");
        app.setType("3");
        app.setPageSize("1000");
        app.setPageNum("1");
        app.setOrderField("keyCount");
        app.setOrderFieldType("desc");
        app.setStartTime("2019-09-16 00:00:00");
        app.setEndTime("2019-09-23 00:00:00");
        String params = JSONObject.toJSONString(app);
        String token = "ca709bdffe613bf4bd20a5f14cd7acd8";
        JSONObject bodyJson = JSONArray.parseObject(Utils.queryMonitorData(restfulURL, params, token));
        JSONObject resJosn = bodyJson.getJSONObject("result");
        JSONArray dataArray = resJosn.getJSONArray("dataResult");
        List<String> txtLst = new ArrayList<>();
        for(int i = 0; i < dataArray.size(); i++){
            StringBuffer bf = new StringBuffer();
            JSONObject object = dataArray.getJSONObject(i);
            bf.append(object.getString("monitorKey")).append(",")
                    .append(object.getString("TP50")).append(",")
                    .append(object.getString("TP90")).append(",")
                    .append(object.getString("TP99")).append(",")
                    .append(object.getString("TP999")).append(",")
                    .append(object.getString("MAX")).append(",")
                    .append(object.getString("AVG")).append(",")
                    .append(object.getString("keyCount"));
            txtLst.add(bf.toString());
        }
        Utils.writeFile(txtLst, app.getAppName() + ".txt");

    }

}
