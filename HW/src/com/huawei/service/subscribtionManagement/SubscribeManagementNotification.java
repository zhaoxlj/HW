package com.huawei.service.subscribtionManagement;

import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpResponse;

import com.huawei.utils.Constant;
import com.huawei.utils.HttpsUtil;
import com.huawei.utils.JsonUtil;
import com.huawei.utils.StreamClosedHttpResponse;

/**
 * Subscribe Management Notification :
 * This interface is used to subscribe to management data of IoT platform.
 */
public class SubscribeManagementNotification {

    public static void main(String args[]) throws Exception {

        // Two-Way Authentication
        HttpsUtil httpsUtil = new HttpsUtil();
        httpsUtil.initSSLConfigForTwoWay();

        // Authentication，get token
        String accessToken = login(httpsUtil);

        //Please make sure that the following parameter values have been modified in the Constant file.
        String appId = Constant.APPID;
        String urlSubscribeManagementNotification = Constant.SUBSCRIBE_MANAGEMENT_NOTIFYCATION;
        

        /*
         * subscribe swUpgradeStateChangeNotify notification
         */
        String callbackurl_swUpgradeStateChange = Constant.SW_UPGRADE_CALLBACK_URL;
        String notifyType_swUpgradeStateChange = Constant.SW_UPGRADE_STATE_CHANGED;

        Map<String, Object> paramSubscribe_swUpgradeStateChange = new HashMap<>();
        paramSubscribe_swUpgradeStateChange.put("notifyType", notifyType_swUpgradeStateChange);
        paramSubscribe_swUpgradeStateChange.put("callbackurl", callbackurl_swUpgradeStateChange);

        String jsonRequest_swUpgradeStateChange = JsonUtil.jsonObj2Sting(paramSubscribe_swUpgradeStateChange);

        Map<String, String> header_swUpgradeStateChange = new HashMap<>();
        header_swUpgradeStateChange.put(Constant.HEADER_APP_KEY, appId);
        header_swUpgradeStateChange.put(Constant.HEADER_APP_AUTH, "Bearer" + " " + accessToken);

        HttpResponse httpResponse_swUpgradeStateChange = httpsUtil.doPostJson(
        		urlSubscribeManagementNotification, header_swUpgradeStateChange, jsonRequest_swUpgradeStateChange);

        String bodySubscribe_swUpgradeStateChange = httpsUtil.getHttpResponseBody(httpResponse_swUpgradeStateChange);

        System.out.println("SubscribeManagementNotification: " + notifyType_swUpgradeStateChange + ", response content:");
        System.out.println(httpResponse_swUpgradeStateChange.getStatusLine());
        System.out.println(bodySubscribe_swUpgradeStateChange);
        System.out.println();
        
        
        /*
         * subscribe swUpgradeResultNotify notification
         */
        String callbackurl_swUpgradeResult = Constant.SW_UPGRADE_CALLBACK_URL;
        String notifyType_swUpgradeResult = Constant.SW_UPGRADE_RESULT;

        Map<String, Object> paramSubscribe_swUpgradeResult = new HashMap<>();
        paramSubscribe_swUpgradeResult.put("notifyType", notifyType_swUpgradeResult);
        paramSubscribe_swUpgradeResult.put("callbackurl", callbackurl_swUpgradeResult);

        String jsonRequest_swUpgradeResult = JsonUtil.jsonObj2Sting(paramSubscribe_swUpgradeResult);

        Map<String, String> header_swUpgradeResult = new HashMap<>();
        header_swUpgradeResult.put(Constant.HEADER_APP_KEY, appId);
        header_swUpgradeResult.put(Constant.HEADER_APP_AUTH, "Bearer" + " " + accessToken);

        HttpResponse httpResponse_swUpgradeResult = httpsUtil.doPostJson(
        		urlSubscribeManagementNotification, header_swUpgradeResult, jsonRequest_swUpgradeResult);

        String bodySubscribe_swUpgradeResult = httpsUtil.getHttpResponseBody(httpResponse_swUpgradeResult);

        System.out.println("SubscribeManagementNotification: " + notifyType_swUpgradeResult + ", response content:");
        System.out.println(httpResponse_swUpgradeResult.getStatusLine());
        System.out.println(bodySubscribe_swUpgradeResult);
        System.out.println();
        
        
        /*
         * subscribe fwUpgradeStateChangeNotify notification
         */
        String callbackurl_fwUpgradeStateChange = Constant.FW_UPGRADE_CALLBACK_URL;
        String notifyType_fwUpgradeStateChange = Constant.FW_UPGRADE_STATE_CHANGED;

        Map<String, Object> paramSubscribe_fwUpgradeStateChange = new HashMap<>();
        paramSubscribe_fwUpgradeStateChange.put("notifyType", notifyType_fwUpgradeStateChange);
        paramSubscribe_fwUpgradeStateChange.put("callbackurl", callbackurl_fwUpgradeStateChange);

        String jsonRequest_fwUpgradeStateChange = JsonUtil.jsonObj2Sting(paramSubscribe_fwUpgradeStateChange);

        Map<String, String> header_fwUpgradeStateChange = new HashMap<>();
        header_fwUpgradeStateChange.put(Constant.HEADER_APP_KEY, appId);
        header_fwUpgradeStateChange.put(Constant.HEADER_APP_AUTH, "Bearer" + " " + accessToken);

        HttpResponse httpResponse_fwUpgradeStateChange = httpsUtil.doPostJson(
        		urlSubscribeManagementNotification, header_fwUpgradeStateChange, jsonRequest_fwUpgradeStateChange);

        String bodySubscribe_fwUpgradeStateChange = httpsUtil.getHttpResponseBody(httpResponse_fwUpgradeStateChange);

        System.out.println("SubscribeManagementNotification: " + notifyType_fwUpgradeStateChange + ", response content:");
        System.out.println(httpResponse_fwUpgradeStateChange.getStatusLine());
        System.out.println(bodySubscribe_fwUpgradeStateChange);
        System.out.println();
        
        
        /*
         * subscribe fwUpgradeResultNotify notification
         */
        String callbackurl_fwUpgradeResult = Constant.FW_UPGRADE_CALLBACK_URL;
        String notifyType_fwUpgradeResult = Constant.FW_UPGRADE_RESULT;

        Map<String, Object> paramSubscribe_fwUpgradeResult = new HashMap<>();
        paramSubscribe_fwUpgradeResult.put("notifyType", notifyType_fwUpgradeResult);
        paramSubscribe_fwUpgradeResult.put("callbackurl", callbackurl_fwUpgradeResult);

        String jsonRequest_fwUpgradeResult = JsonUtil.jsonObj2Sting(paramSubscribe_fwUpgradeResult);

        Map<String, String> header_fwUpgradeResult = new HashMap<>();
        header_fwUpgradeResult.put(Constant.HEADER_APP_KEY, appId);
        header_fwUpgradeResult.put(Constant.HEADER_APP_AUTH, "Bearer" + " " + accessToken);

        HttpResponse httpResponse_fwUpgradeResult = httpsUtil.doPostJson(
        		urlSubscribeManagementNotification, header_fwUpgradeResult, jsonRequest_fwUpgradeResult);

        String bodySubscribe_fwUpgradeResult = httpsUtil.getHttpResponseBody(httpResponse_fwUpgradeResult);

        System.out.println("SubscribeManagementNotification: " + notifyType_fwUpgradeResult + ", response content:");
        System.out.println(httpResponse_fwUpgradeResult.getStatusLine());
        System.out.println(bodySubscribe_fwUpgradeResult);
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
