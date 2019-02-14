package com.yy.pwd;

import javax.crypto. *;

public class Eryptogram {

	private static String Algorithm ="DES";
    //定义加密算法,可用DES,DESede,Blowfish
     static boolean debug = false ;
    /**
    *构造子注解.
    */
    public Eryptogram ()
    {
    }
    /**
    *生成密钥
    *@returnbyte[]返回生成的密钥
    *@throwsexception扔出异常.
    */
    public static byte []getSecretKey () throws Exception 
    {
        KeyGenerator keygen =KeyGenerator.getInstance (Algorithm );
        SecretKey deskey = keygen.generateKey ();
        if (debug)System.out.println ("生成密钥:"+byte2hex (deskey.getEncoded ()));
        return deskey.getEncoded ();
    }
    /**
    *将指定的数据根据提供的密钥进行加密
    *@paraminput需要加密的数据
    *@paramkey密钥
    *@returnbyte[]加密后的数据
    *@throwsException
    */
    public static byte []encryptData (byte []input ,byte []key ) throws Exception 
    {
        SecretKey deskey = new javax.crypto.spec.SecretKeySpec (key ,Algorithm );
        if (debug)
        {
            System.out.println ("加密前的二进串:"+byte2hex (input ));
            System.out.println ("加密前的字符串:"+new String (input ,"UTF8"));
        }
        Cipher c1 = Cipher.getInstance (Algorithm);
        c1.init (Cipher.ENCRYPT_MODE ,deskey);
        byte [] cipherByte = c1.doFinal (input);
        if (debug){
        	System.out.println ("加密后的二进串:"+byte2hex (cipherByte ));
        }
        return cipherByte;
    }
    /**
    *将给定的已加密的数据通过指定的密钥进行解密
    *@paraminput待解密的数据
    *@paramkey密钥
    *@returnbyte[]解密后的数据
    *@throwsException
    */
    public static byte []decryptData (byte []input ,byte []key )throws Exception 
    {
        SecretKey deskey = new javax.crypto.spec.SecretKeySpec (key ,Algorithm );
        if (debug )System.out.println ("解密前的信息:"+byte2hex (input ));
        Cipher c1 =Cipher.getInstance (Algorithm );
        c1.init (Cipher.DECRYPT_MODE ,deskey );
        byte []clearByte =c1.doFinal (input );
        if (debug )
        {
            System.out.println ("解密后的二进串:"+byte2hex (clearByte ));
            System.out.println ("解密后的字符串:"+(new String (clearByte )));
        }
        return clearByte ;
    }
    /**
    *字节码转换成16进制字符串
    *@parambyte[]b输入要转换的字节码
    *@returnString返回转换后的16进制字符串
    */
    public static String byte2hex (byte []b )
    {
        String hs ="";
        String stmp ="";
        for (int n =0 ;n <b.length ;n ++)
        {
            stmp =(java.lang.Integer.toHexString (b [n ]&0XFF ));
            if (stmp.length ()==1 )hs =hs +"0"+stmp ;
            else hs =hs +stmp ;
            if (n <b.length -1 )hs =hs +":";
        }
        return hs.toUpperCase ();
    }
    public static void main (String []args)
    {
    	
        try 
        {
            debug = false ;
            Eryptogram etg =new Eryptogram ();
            byte []key =etg.getSecretKey ();
           // System.out.println ("key="+key );
            String aa ="系统管理";
            byte [] data = aa.getBytes ();
           // System.out.println (data);
            byte []en = etg.encryptData (data ,key);
            System.out.println ("加密 encryptData="+new String (en ,"UTF8"));
            byte []de = etg.decryptData (en ,key );
            System.out.println ("解密decryptData="+new String (de ,"UTF8" ));
        }
        catch (Exception e )
        {
            e.printStackTrace ();
        }
    }
	
}
