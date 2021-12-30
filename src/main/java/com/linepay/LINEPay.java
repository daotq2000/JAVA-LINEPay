package com.linepay;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;


public class LINEPay {
    public static String transactionId;
    public static String web;
    public static void request() {
        Map<String, Object> data = new HashMap<>();
        data.put("productName", "ProductSample");
        data.put("productImageUrl", "https://d.line-scdn.net/linepay/portal/assets/img/linepay-logo-jp-gl.png?dm=1640659041602");
            data.put("amount", "1");
        data.put("currency", "TWD");
        data.put("orderId", "ORD_i0q1kW0yFrOp0fCAvctq7g6Y3");
        data.put("confirmUrl", "http://localhost:8080/appUsers/confirm");
        data.put("cancelUrl", "http://localhost:8080/appUsers/cancel");
        data.put("capture", "true");
        data.put("confirmUrlType", "CLIENT");
        data.put("payType", "NORMAL");

        JSONObject jObj = LINEPayAPI.request("https://sandbox-api-pay.line.me/v2/payments/request", data);
        try {
            System.out.println("");
            System.out.println("returnCode=>" + jObj.getString("returnCode"));
            System.out.println("");
            JSONObject infoOjb = jObj.getJSONObject("info");
            JSONObject payOjb = infoOjb.getJSONObject("paymentUrl");
            System.out.println("paymentUrl.web=>" + payOjb.getString("web"));
            web = payOjb.getString("web");
            System.out.println("");
            System.out.println("paymentUrl.app=>" + payOjb.getString("app"));
            System.out.println("");
            System.out.println("transactionId=>" + infoOjb.get("transactionId").toString());
            transactionId = infoOjb.get("transactionId").toString();
            System.out.println("");
            System.out.println("paymentAccessToken=>" + infoOjb.get("paymentAccessToken").toString());
            System.out.println("");
        } catch (JSONException ex) {
            Logger.getLogger(LINEPay.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
