package com.huawei.service.deviceManagement;

import java.util.HashMap;
import java.util.Map;

import com.huawei.utils.Constant;
import com.huawei.utils.HttpsUtil;
import com.huawei.utils.JsonUtil;
import com.huawei.utils.StreamClosedHttpResponse;

/**
 * Query Device Realtime Location :
 * This interface is used to query the realtime location information of a device.
 * It need some time to return the location information.
 */
public class QueryDeviceRealtimeLocation {

	public static void main(String args[]) throws Exception {

        // Two-Way Authentication
        HttpsUtil httpsUtil = new HttpsUtil();
        httpsUtil.initSSLConfigForTwoWay();

        // Authentication，get token
        String accessToken = login(httpsUtil);

        //Please make sure that the following parameter values have been modified in the Constant file.
		String appId = Constant.APPID;
		String urlQueryDeviceRealtimeLocation = Constant.QUERY_DEVICE_REALTIME_LOCATION;

        //please replace the deviceId, when you use the demo.
        String code = "4326";
        String codeSpace = "EPSG";
        String edition = "6.1";
        
        Map<String, String> identifier = new HashMap<>();
        identifier.put("code", code);
        identifier.put("codeSpace", codeSpace);
        identifier.put("edition", edition);
        
        Map<String, Object> geoInfo = new HashMap<>();
        geoInfo.put("identifier", identifier);
        
        String deviceId = "9a445dda-f62e-4c78-be05-ef0f0c1b447a";
        Integer horAcc = 10;
        
        Map<String, Object> paramQueryDeviceRealtimeLocation = new HashMap<>();
        paramQueryDeviceRealtimeLocation.put("deviceId", deviceId);
        paramQueryDeviceRealtimeLocation.put("horAcc", horAcc);
        paramQueryDeviceRealtimeLocation.put("geoInfo", geoInfo);
        
        String jsonRequest = JsonUtil.jsonObj2Sting(paramQueryDeviceRealtimeLocation);

        Map<String, String> header = new HashMap<>();
        header.put(Constant.HEADER_APP_KEY, appId);
        header.put(Constant.HEADER_APP_AUTH, "Bearer" + " " + accessToken);

        StreamClosedHttpResponse responseQueryDeviceRealtimeLocation = httpsUtil.doPostJsonGetStatusLine(
        		urlQueryDeviceRealtimeLocation, header, jsonRequest);

        System.out.println("QueryDeviceRealtimeLocation, response content:");
        System.out.println(responseQueryDeviceRealtimeLocation.getStatusLine());
        System.out.println(responseQueryDeviceRealtimeLocation.getContent());
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
