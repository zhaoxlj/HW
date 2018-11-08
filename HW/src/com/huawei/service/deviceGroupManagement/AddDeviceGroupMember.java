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
 * Add Device Group Member :
 * This interface is used to add devices to a device group.
 */
public class AddDeviceGroupMember {

    public static void main(String[] args) throws Exception {

        // Two-Way Authentication
        HttpsUtil httpsUtil = new HttpsUtil();
        httpsUtil.initSSLConfigForTwoWay();

        // Authentication，get token
        String accessToken = login(httpsUtil);

        //Please make sure that the following parameter values have been modified in the Constant file.
        String urlAddDeviceGroupMember = Constant.ADD_DEVICE_GROUP_MEMBER;
        String appId = Constant.APPID;

        //please replace the following parameter values, when you use the demo.
        String devGroupId = "b9b4f961-eef8-4cd6-91fe-dd4de1b344da";
        List<String> deviceIds = new ArrayList<String>();
        deviceIds.add("89ef76b8-cb56-4d9d-8a57-61a4e1c32ff1");

        Map<String, Object> paramAddDeviceGroupMember = new HashMap<>();
        paramAddDeviceGroupMember.put("devGroupId", devGroupId);
        paramAddDeviceGroupMember.put("deviceIds", deviceIds);
        
        String jsonRequest = JsonUtil.jsonObj2Sting(paramAddDeviceGroupMember);
                
        Map<String, String> header = new HashMap<>();
        header.put(Constant.HEADER_APP_KEY, appId);
        header.put(Constant.HEADER_APP_AUTH, "Bearer" + " " + accessToken);
        
        StreamClosedHttpResponse responseAddDeviceGroupMember = httpsUtil.doPostJsonGetStatusLine(urlAddDeviceGroupMember, header, jsonRequest);

        System.out.println("AddDeviceGroupMember, response content:");
        System.out.println(responseAddDeviceGroupMember.getStatusLine());
        System.out.println(responseAddDeviceGroupMember.getContent());
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
