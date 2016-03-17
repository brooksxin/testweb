package com.xin.demo.Util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.URLDecoder;
import java.util.Enumeration;

public class StringUtil {
    private final static String DEFAULTECODE = "ISO-8859-1";
    private final static int BUFFER_SIZE = 1024;
    public static int str2Int(String str){
        if(isEmptyStr(str)){
            return 0;
        }
        try{
            return Integer.parseInt(str);
        }catch(Exception e){
            return 0;
        }
    }
    /**取得本机IP，默认先按Linux方式获取*/
    public static String getLocalHostIp(){
    	try {
			Enumeration<NetworkInterface> allnetInface = NetworkInterface.getNetworkInterfaces();
			InetAddress ip = null;
			while(allnetInface.hasMoreElements()){
				NetworkInterface netInface = allnetInface.nextElement();
				Enumeration<InetAddress> addresses = netInface.getInetAddresses();
				while(addresses.hasMoreElements()){
					ip = addresses.nextElement();
					if(ip !=null && ip instanceof Inet4Address){
						break;
					}
				}
				if(ip !=null && ip instanceof Inet4Address){
					break;
				}
			}
			if(ip !=null && ip instanceof Inet4Address){
				return ip.getHostAddress();
			}
			return "";
		} catch (Exception e) {
			try {//windows下有效
	            return InetAddress.getLocalHost().getHostAddress().toString(); // 获取服务器IP地址
	        } catch (Exception ex) {
	        	return "";
	        }
		}
    }
    public static String arrStr2Str(String[] arrStr) {
        StringBuffer json = new StringBuffer();
        json.append("[");
        if (arrStr != null) {
            for (int i = 0; i < arrStr.length; i++) {
                if (i > 0)
                    json.append(",");
                json.append(arrStr[i]);
            }
        }
        json.append("]");
        return json.toString();
    }
    public static boolean isNullStr(String str){
        return str == null;
    }
    public static boolean isEmptyStr(String str){
        return trimStr(str).length() < 1;
    }
    
    /**删除字符串前后空格，如果@param str 为空对象，则设置成空字符串*/
    public static String trimStr(String str){
        if(isNullStr(str)){
            str = "";
        }
        return str.trim();
    }
    /**string 转成 inputream*/
    public static InputStream str2InputStream(String str,String strecode){
        if(strecode == null )strecode = DEFAULTECODE;
        try {
            ByteArrayInputStream is = new ByteArrayInputStream(str.getBytes(strecode));
            return is;
        } catch (Exception e) {
           return null;
        }
    }
//    /**string 编码成base64*/
//    public static String str2Base64(String str){
//        String base64 = str;
//        try {
//            byte[] inputBytes = str.getBytes("UTF8");
//            BASE64Encoder encoder = new BASE64Encoder();
//            base64 = encoder.encode(inputBytes);
//        } catch (Exception e) {
//            base64 = str;
//        }
//        return base64;
//    }
//    /**base64 string 反编码*/
//    public static String getDecryptedstr(String input){
//        String result = input;
//        try {
//            BASE64Decoder decoder = new BASE64Decoder();
//            byte[] raw = decoder.decodeBuffer(input);
//            result = new String(raw, "UTF8");
//        } catch (Exception e) {
//            result  = input;
//        }
//        return result;
//    }
    /**string 转成 inputream*/
    public static InputStream str2InputStream(String str){
        return str2InputStream(str,DEFAULTECODE);
    }
    /**inputream 转成 string*/
    public static String inputStream2String(InputStream in){
        return inputStream2String(in,null);
    }
    /**inputream 转成 string*/
    public static String inputStream2String(InputStream in,String strecode){
        if(in == null )return null;
        if(strecode == null )strecode = DEFAULTECODE;
        ByteArrayOutputStream outStream = new ByteArrayOutputStream(); 
        byte[] data = new byte[BUFFER_SIZE];
        String rtn = null;
        int count = -1;
        try {
            while ((count = in.read(data, 0, BUFFER_SIZE)) != -1) {
                outStream.write(data, 0, count);
            }
            rtn = new String(outStream.toByteArray(),strecode);
        } catch (Exception e) {
        }
        try {
            data = null;
            if(in!=null)in.close();
            if(outStream!=null)outStream.close();
        } catch (Exception e) {
        }
        return rtn;
    }
    /***
     * Desc  解密：数字到原字符串
     * @param str
     * @return
     */
    public static String numToString(String str) {
        try{
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < str.length(); i += 2) {
                int  a  =   Integer.parseInt(str.substring(i, i+2)) + 23;
                sb.append((char)a + "");
            }
            return URLDecoder.decode(sb.toString(), "UTF-8");
        }catch (Exception e){
            e.printStackTrace();
        }
        return "";
    }
}
