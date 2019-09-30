package com.example.demo;

import com.example.demo.domain.Products;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class ProductTest {
    public static void main(String[] args) throws IOException, JSONException {
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("name","Samsung s10").put("price",56000).put("details","\n" +
                "    Triple rear camera setup: 16MP with f2.2 aperture ultra wide + 12MP with f1.5 and f2.4 aperture wide + 12MP f2.4 tele| 10MP f1.9 front facing camera\n" +
                "    15.51 centimeters (6.1-inch) Dynamic AMOLED multi-touch capacitive touchscreen with 3040 x 1440 pixels resolution, 550 ppi pixel density\n" +
                "    Memory, Storage and SIM: 8GB RAM | 128GB internal memory expandable up to 512GB | Dual SIM (nano+nano) dual stand by (4G+4G)\n" +
                "    Android Pie v9.0 operating system with 2.7GHz + 2.3GHz + 1.9GHz Exynos 9820 octa core processor\n" +
                "    3400mAH lithium-ion battery, The large, notch-free display is a visual treat on the eyes\n" +
                "    1 year manufacturer warranty for device and 6 months manufacturer warranty for in-box accessories including batteries from the date of purchase\n" +
                "    Box also includes: Earphones, Travel Adapter, USB Cable, Ejection Pin, User Manual\n").put("imgUrl","https://images-na.ssl-images-amazon.com/images/I/61BAVcOnyiL._SY606_.jpg").
                put("category","mobiles").put("inStock",true);

        Products products=new ObjectMapper().readValue(jsonObject.toString(),Products.class);
        System.out.println(new ObjectMapper().writeValueAsString(products));
    }
}
