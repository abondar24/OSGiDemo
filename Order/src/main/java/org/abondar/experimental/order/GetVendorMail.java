package org.abondar.experimental.order;


import org.apache.camel.language.XPath;

import java.util.HashMap;
import java.util.Map;

public class GetVendorMail {
    Map<String,String> mailMap = new HashMap<>();

    public GetVendorMail(String mailAdress){
        mailMap.put("vendor1",mailAdress);
    }

    public String getMail(@XPath("/item/@vendor")String vendor){
        return mailMap.get(vendor);
    }
}
