package com.phone.commons;

import org.apache.commons.httpclient.methods.PostMethod;

public class MyPostMethod extends PostMethod{   
	  private String charSet;
       public MyPostMethod(String url , String charSet){     
           super(url);
           this.charSet =  charSet;
       }     
       public String getRequestCharSet() {       
           return charSet;    
       }     
   }       