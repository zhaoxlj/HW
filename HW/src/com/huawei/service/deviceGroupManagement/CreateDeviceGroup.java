package com.huawei.service.deviceGroupManagement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.huawei.utils.Constant;
import com.huawei.utils.HttpsUtil;
import com.huawei.utils.JsonUtil;
import com.huawei.utils.StreamClosedHttpResponse;

/**
 * Create Device Group :
 * This interface is used to create a device group.
 */
public class CreateDeviceGroup {

    public static void main(String[] args) throws Exception {

        // Two-Way Authentication
        HttpsUtil httpsUtil = new HttpsUtil();
        httpsUtil.initSSLConfigForTwoWay();

        // Authentication，get token
        String accessToken = login(httpsUtil);

        //Please make sure that the following parameter values have been modified in the Constant file.
        String urlCreateDeviceGroup = Constant.CREATE_DEVICE_GROUP;
        String appId = Constant.APPID;
        
        //please replace the following parameter values, when you use the demo.
        String name = "Group02";
        int maxDevNum = 100;
        List<String> deviceIds = new ArrayList<String>();
        deviceIds.add("9e620731-9a8b-42b7-b685-263546b74afc");
      
        Map<String, Object> paramCreateDeviceGroup = new HashMap<>();
        paramCreateDeviceGroup.put("name", name);
        paramCreateDeviceGroup.put("maxDevNum", maxDevNum);
        paramCreateDeviceGroup.put("deviceIds", deviceIds);
        
        String jsonRequest = JsonUtil.jsonObj2Sting(paramCreateDeviceGroup);
                
        Map<String, String> header = new HashMap<>();
        header.put(Constant.HEADER_APP_KEY, appId);
        header.put(Constant.HEADER_APP_AUTH, "Bearer" + " " + accessToken);
        
        StreamClosedHttpResponse responseCreateDeviceGroup = httpsUtil.doPostJsonGetStatusLine(urlCreateDeviceGroup, header, jsonRequest);

        System.out.println("CreateDeviceGroup, response content:");
        System.out.println(responseCreateDeviceGroup.getStatusLine());
        System.out.println(responseCreateDeviceGroup.getContent());
        System.out.println();
    }

    /**
     * Authentication，get token
     */
    @SuppressWarnings("unchecked")
    public static String login(HttpsUtil httpsUtil) throws Exception {

        String appId = Constant.APPID;
        String secret = Constant.SECRET;
        String urlLogin = Constant.APP_AUTH;

        Map<String, String> paramLogin = new HashMap<>();
        paramLogin.put("appId", appId);
        paramLogin.put("secret", secret);

        StreamClosedHttpResponse responseLogin = httpsUtil.doPostFormUrlEncodedGetStatusLine(urlLogin, paramLogin);

        System.out.println("app auth success,return accessToken:");
        System.out.println(responseLogin.getStatusLine());
        System.out.println(responseLogin.getContent());
        System.out.println();

        Map<String, String> data = new HashMap<>();
        data = JsonUtil.jsonString2SimpleObj(responseLogin.getContent(), data.getClass());
        return data.get("accessToken");
    }

}
