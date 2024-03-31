package vip.openpark.jvm.codec;

import java.nio.charset.StandardCharsets;

/**
 * @author anthony
 * @since 2024/3/31 18:52
 */
public class CodecApplication {
	private static final String PLAINTEXT = "hello world"; // 明文
	private static final byte ENCRYPT_FACTOR = (byte) 0x01; // 加密因子，注意：这里使用 0x01
	
	public static void main(String[] args) {
		String encrypt = encrypt(PLAINTEXT, ENCRYPT_FACTOR);
		decrypt(encrypt, ENCRYPT_FACTOR);
	}
	
	/**
	 * 加密
	 *
	 * @param plaintext     明文
	 * @param encryptFactor 加密因子
	 */
	private static String encrypt(String plaintext, byte encryptFactor) {
		// 明文——>密文
		byte[] originalBytes = plaintext.getBytes(StandardCharsets.UTF_8);
		
		byte[] encryptBytes = new byte[originalBytes.length];
		for (int i = 0; i < originalBytes.length; i++) {
			// 异或加密
			encryptBytes[i] = (byte) (originalBytes[i] ^ encryptFactor);
		}
		// 密文
		String ciphertext = new String(encryptBytes, StandardCharsets.UTF_8);
		System.out.println(ciphertext);
		return ciphertext;
	}
	
	/**
	 * 解密
	 *
	 * @param ciphertext    密文
	 * @param encryptFactor 加密因子
	 */
	private static String decrypt(String ciphertext, byte encryptFactor) {
		// 密文——>明文
		byte[] ciphertextBytes = ciphertext.getBytes(StandardCharsets.UTF_8);
		
		byte[] plaintextBytes = new byte[ciphertextBytes.length];
		for (int i = 0; i < ciphertextBytes.length; i++) {
			// 异或解密
			plaintextBytes[i] = (byte) (ciphertextBytes[i] ^ encryptFactor);
		}
		String plaintext = new String(plaintextBytes, StandardCharsets.UTF_8);
		System.out.println(plaintext);
		return plaintext;
	}
}