/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fullfillment;


import com.fasterxml.jackson.core.JsonParseException;
import static com.sun.org.apache.xalan.internal.lib.ExsltDynamic.map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import static jdk.nashorn.internal.objects.NativeArray.map;
import org.json.JSONArray;
import org.json.JSONObject;
import static org.springframework.core.convert.TypeDescriptor.map;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
/**
 *
 * @author admin
 */
@RestController
public class FullfillmentController {
    
    
    
    @RequestMapping(value = "/hello", method = RequestMethod.POST, produces = "application/json")
    public Fullfillment greeting(@RequestBody String json) {
        
      JSONObject obj = new JSONObject(json);
        
      String action=obj.getJSONObject("result").getString("action");
      Object ageAmount=obj.getJSONObject("result").getJSONObject("parameters").getJSONObject("age").get("amount");
      String age=ageAmount.toString();
      
      
      //Calculation Part----------------------
      Object duration=obj.getJSONObject("result").getJSONObject("parameters").get("duration");
        String[] partsDuration = duration.toString().split("/");
        String[] fromDate=partsDuration[0].split("-");
        String[] toDate=partsDuration[1].split("-");
        
        int fromYear=Integer.parseInt(fromDate[0]);
        int toYear=Integer.parseInt(toDate[0]);
        
        int yearDifference = toYear-fromYear;
        
        //--------------------------------------
        
        
       
      Map<String, String> map1 = new HashMap<String, String>();
      map1.put("name", (String) toDate[0]);
      map1.put("diff", "Diff");
          
      ArrayList<Object> arr = new ArrayList();
      arr.add(map1);
        
     
     Fullfillment fulfillment = new Fullfillment();
     fulfillment.speech="Speech";
     fulfillment.displayText="You have a "+String.valueOf(yearDifference)+" Years of Insuerence";
     fulfillment.source="source";
     fulfillment.data=map1;
     fulfillment.contextOut=arr;
     
    
      
        return fulfillment;
        
    }
    
   
    
}
