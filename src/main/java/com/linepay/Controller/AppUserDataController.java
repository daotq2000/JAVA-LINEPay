package com.linepay.Controller;

import com.linepay.LINEPay;
import com.linepay.LINEPayAPI;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;

@RestController
@RequestMapping("/appUsers")
public class AppUserDataController {

    @RequestMapping(value = "/confirm", method = RequestMethod.GET)
    public void confirm(@RequestParam("transactionId") String transactionId) {
        System.out.println("CONFIRM");
        Map<String, String> data = new HashMap<String, String>();
        data.put("amount", "1");
        data.put("currency", "TWD");

        System.out.println("transactionId=>"+ transactionId);
        JSONObject jObj = LINEPayAPI.request("https://sandbox-api-pay.line.me/v2/payments/" + transactionId + "/confirm", data);
        System.out.println(jObj.toString());
//            JSONObject infoOjb = jObj.getJSONObject("info");
//            System.out.println("orderId=>" + infoOjb.getString("orderId"));
//            System.out.println("transactionId=>" + infoOjb.getString("transactionId"));
//            System.out.println("returnCode=>" + jObj.getString("returnCode"));
    }

}
