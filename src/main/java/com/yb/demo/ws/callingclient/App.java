package com.yb.demo.ws.callingclient;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {
        System.out.println( "Calling Yes Bank Service" );
        
        String callUrl="https://uatsky.yesbank.in/app/uat/rest/SocialBankingService/getAllAccounts";
        
        String response=callwithParam(callUrl);//callYesBank(callUrl);
        
        System.out.println(response);
        
    }
    
    
    public static String callwithParam(String callUrl) throws IOException {
    	String resp="";
    	
    	
    	OkHttpClient client = new OkHttpClient();

    	MediaType mediaType = MediaType.parse("application/json");
    	
    	RequestBody body = RequestBody.create(mediaType, "{\n\n\t \" getAllAccounts\": {\n\n        \" version\": \"1\",\n\n        \" appID\": \"12345\",\n\n        \" customerIdentity\": {\n\n          \" customerID\": \"1915\",\n\n          \" customerAlternateID\": {\n\n            \" mobileNo\": \"9999999999\",\n\n            \" emailID\": \"poi@gmail.com\",\n\n            \" twitterID\": \"nikcool123\",\n\n            \" genericID\": {\n\n              \" idType\": \"\",\n\n              \" idValue\": \"\"\n\n            }\n\n          }\n\n        },\n\n        \" deviceID\": \"359932063075437\",\n\n        \" criteria\": {\n\n          \" accountType\": \"savings\",\n\n          \" accountRelation\": \"\",\n\n          \" operationName\": \"test\"\n\n        },\n\n        \" numAccounts\": \"\"\n\n      }\n\n    }\n\n  ");
    	
    	
    	Request request = new Request.Builder()
    	  .url(callUrl)
    	  .post(body)
    	  .addHeader("x-ibm-client-id", "b7c695a3-252b-45c2-bef5-c1cc834632c7")
    	  .addHeader("x-ibm-client-secret", "X7bA6gC0iS3pG2vQ8nT7cJ2fV4pK2tL7lH0eM0xF3wS7kL4rP2")
    	  .addHeader("content-type", "application/json")
    	  .addHeader("cache-control", "no-cache")
    	  .addHeader("postman-token", "9b481fef-22cd-ba69-8b36-87331d08e2d4")
    	  .build();

    	System.out.println("Called Yes URL");
    	
    	Response response = client.newCall(request).execute();
    	
    	resp = response.body().string().toString();
    	
    	return resp;
    }
}
