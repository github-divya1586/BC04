package com.utils;

import java.io.File;

import com.exceptions.CryptoException;

/**
 * A tester for the CryptoUtils class.
 * 
 * 
 *
 */
public class CryptoUtilsTest {
	public static void encrptAlgoritham(String pkey, File inputFile, File encryptedFile) {
		String key = pkey;

		try {
			CryptoUtils.encrypt(key, inputFile, encryptedFile);

		} catch (CryptoException ex) {
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		}
	}

	public static void decryptAlgoritham(String pkey, File encryptedFile, File decryptedFile) {
		String key = pkey;

		try {

			CryptoUtils.decrypt(key, encryptedFile, decryptedFile);
		} catch (CryptoException ex) {
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		}
	}
}