package com.huawei.service.batchTask;

import java.util.HashMap;
import java.util.Map;

import com.huawei.utils.Constant;
import com.huawei.utils.HttpsUtil;
import com.huawei.utils.JsonUtil;
import com.huawei.utils.StreamClosedHttpResponse;

/**
 * Query Batch Task Details :
 * This interface is used to query batch task details.
 */
public class QueryBatchTaskDetails {

    public static void main(String args[]) throws Exception {

        // Two-Way Authentication
        HttpsUtil httpsUtil = new HttpsUtil();
        httpsUtil.initSSLConfigForTwoWay();

        // Authentication，get token
        String accessToken = login(httpsUtil);

        //Please make sure that the following parameter values have been modified in the Constant file.
        String appId = Constant.APPID;
        String urlQueryBatchTaskDetails = Constant.QUERY_BATCH_TASK_DETAILS;

        //please replace the pageNo and pageSize, when you use the demo.
        String taskId = "5b17415b575a4e152f063feb";
        String status = "Success";  //Pending|Success|Fail|Timeout
        Integer pageNo = 3;
        Integer pageSize = 5;

        Map<String, String> paramQueryBatchTaskDetails = new HashMap<>();
        paramQueryBatchTaskDetails.put("taskId", taskId);
        paramQueryBatchTaskDetails.put("status", status);
        paramQueryBatchTaskDetails.put("pageNo", pageNo.toString());
        paramQueryBatchTaskDetails.put("pageSize", pageSize.toString());

        Map<String, String> header = new HashMap<>();
        header.put(Constant.HEADER_APP_KEY, appId);
        header.put(Constant.HEADER_APP_AUTH, "Bearer" + " " + accessToken);
        
        StreamClosedHttpResponse ResponseQueryBatchTaskDetails = httpsUtil.doGetWithParasGetStatusLine(urlQueryBatchTaskDetails,
        		paramQueryBatchTaskDetails, header);

        System.out.println("QueryBatchTaskDetails, response content:");
        System.out.println(ResponseQueryBatchTaskDetails.getStatusLine());
        System.out.println(ResponseQueryBatchTaskDetails.getContent());
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
