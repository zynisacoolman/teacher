package cn.jucheng.www.hulisiwei.widget;

import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class HexadecimalConver {  
    
	private static String hexString="0123456789ABCDEF";  
	  public static String toStringHex(String s){  
	    byte[] baKeyword = new byte[s.length()/2];  
	    for(int i = 0; i < baKeyword.length; i++){  
	     try{  
	      baKeyword[i] = (byte)(0xff & Integer.parseInt(s.substring(i*2, i*2+2),16));  
	     }catch(Exception e){  
	      e.printStackTrace();  
	     }  
	    }  
	    try{  
	     s = new String(baKeyword, "GB2312");  
	    }catch (Exception e1){  
	     e1.printStackTrace();  
	    }  
	    return s;  
	   }  
	     
	   /** 
	    * ���ַ�����16��������,�����������ַ�������ģ� 
	    */  
	   public static String encode(String str){  
	    //���Ĭ�ϱ����ȡ�ֽ�����  
	    byte[] bytes=str.getBytes();  
	    StringBuilder sb=new StringBuilder(bytes.length*2);  
	    //���ֽ�������ÿ���ֽڲ���2λ16��������  
	    for(int i=0;i<bytes.length;i++){  
	     sb.append(hexString.charAt((bytes[i]&0xf0)>>4));  
	     sb.append(hexString.charAt((bytes[i]&0x0f)>>0));  
	    }  
	    return sb.toString();  
	   }  
	   /** 
	    * ��16�������ֽ�����ַ�,�����������ַ�������ģ� 
	    */  
	   public static String decode(String bytes)  
	   {  
	        ByteArrayOutputStream baos=new ByteArrayOutputStream(bytes.length()/2);  
	        //��ÿ2λ16����������װ��һ���ֽ�  
	        for(int i=0;i<bytes.length();i+=2)  
	        baos.write((hexString.indexOf(bytes.charAt(i))<<4 |hexString.indexOf(bytes.charAt(i+1))));  
	        String bb = "";  
	        try {  
	            bb = new String(baos.toByteArray(), "GB2312");  
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }  
	    return bb;  
	   } 
	   
	   public static String encodeCN(String data) {  
	       byte[] bytes;  
	       try {  
	           bytes = data.getBytes("gbk");  
	           StringBuilder sb = new StringBuilder(bytes.length * 2);  
	 
	           for (int i = 0; i < bytes.length; i++) {  
	               sb.append(hexString.charAt((bytes[i] & 0xf0) >> 4));  
	               sb.append(hexString.charAt((bytes[i] & 0x0f) >> 0));  
	           }  
	           return sb.toString();  
	       } catch (UnsupportedEncodingException e) {  
	           e.printStackTrace();  
	       }  
	       return "";  
	   }  
	     
	   public static String encodeStr(String data) {  
	       String result = "";  
	       byte[] bytes;  
	       try {  
	           bytes = data.getBytes("gbk");  
	           for (int i = 0; i < bytes.length; i++) {  
	               result += Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1);  
	           }  
	           return result;  
	       } catch (UnsupportedEncodingException e) {  
	           e.printStackTrace();  
	       }  
	       return "";  
	   }  
	     
	   /** 
	    * �ж��Ƿ�Ϊ���ĺ��� 
	    * @param data 
	    * @return 
	    */  
	   public static boolean isCN(String data) {  
	       boolean flag = false;  
	       String regex = "^[\u4e00-\u9fa5]*$";  
	       if (data.matches(regex)) {  
	           flag = true;  
	       }  
	       return flag;  
	   }  
	 
	   public static String getHexResult(String targetStr) {  
	       StringBuilder hexStr = new StringBuilder();  
	       int len = targetStr.length();  
	       if (len > 0) {  
	           for (int i = 0; i < len; i++) {  
	               char tempStr = targetStr.charAt(i);  
	               String data = String.valueOf(tempStr);  
	               if (isCN(data)) {  
	                   hexStr.append(encodeCN(data));  
	               } else {  
	                   hexStr.append(encodeStr(data));  
	               }  
	           }  
	       }  
	       return hexStr.toString();  
	   }  
	}
