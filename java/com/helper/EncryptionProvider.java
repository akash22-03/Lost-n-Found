package com.helper;

import java.security.SecureRandom;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;

public class EncryptionProvider {

	private static final String AES = "AES";
	//Using block cipher
	private static final String AES_CIP = "AES/CBC/PKCS5PADDING";
	
	//Method to create static key
	public static SecretKey createAESKey() throws Exception
	{
		SecureRandom securerandom = new SecureRandom();			//Create new inst. for SecureRandom class
		KeyGenerator keyGen = KeyGenerator.getInstance(AES);	//Passing string to key generator
		keyGen.init(128,securerandom);							//Initialize key gen with 256bits
		SecretKey key = keyGen.generateKey();
		return key;
	}
	
	public static byte[] createInitialVector()
	{
		byte[] Initial_Vector = new byte[16];
		SecureRandom securerandom = new SecureRandom();
		securerandom.nextBytes(Initial_Vector);
		return Initial_Vector;
	}
	
	//Method to take plain text and with key to convert to CipherText
	public static byte[] doAESEncryption(String plainText,SecretKey secretKey,byte[] Initial_Vector) throws Exception
	{
		Cipher cipher = Cipher.getInstance(AES_CIP);
		IvParameterSpec ivParamspec = new IvParameterSpec(Initial_Vector);//Paramaeter aspects of Cipher Block
		cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivParamspec);//Init Cipher block
		return cipher.doFinal(plainText.getBytes());
	}
	
	//Method to perform Cipher text to plain text
	public static String doAESDecryption(byte[] cipherText, SecretKey secretKey, byte[] Initial_Vector) throws Exception
	{
		Cipher cipher = Cipher.getInstance(AES_CIP);
		IvParameterSpec ivParamspec = new IvParameterSpec(Initial_Vector);
		cipher.init(Cipher.DECRYPT_MODE, secretKey, ivParamspec);
		byte[] result = cipher.doFinal(cipherText);
		return new String(result);
	}
	
	public static void main(String[] args) throws Exception
	{
		SecretKey secretKey = createAESKey();
		System.out.println("-*-Encrypt Mode-*-");
		byte[] Initial_Vector =  createInitialVector();
		String msg = "Hello World.!! How are you all";
		byte[] cipherText = doAESEncryption(msg, secretKey, Initial_Vector);
        System.out.println(Base64.getEncoder().encodeToString(cipherText));
		String plaintext = doAESDecryption(cipherText, secretKey, Initial_Vector);
		System.out.println("Your message was : " + plaintext);
	}

}




	


