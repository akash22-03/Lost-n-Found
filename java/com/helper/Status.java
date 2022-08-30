package com.helper;
import java.util.Base64;

import javax.crypto.SecretKey;

import com.helper.EncryptionProvider;
public class Status {

	public static void main(String[] args) throws Exception {
		SecretKey key = EncryptionProvider.createAESKey();
		String stringKey = Base64.getEncoder().encodeToString(key.getEncoded());
		System.out.println(stringKey);
	}

}
