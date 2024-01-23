package application;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class Security {
    private static final String algo = "AES";
    public static String crypt(String value, String key) {
        try {
            SecretKeySpec keySpec = new SecretKeySpec(key.getBytes(), algo);
            Cipher cipher = Cipher.getInstance(algo);
            cipher.init(Cipher.ENCRYPT_MODE, keySpec);
            byte[] encryptedValue = cipher.doFinal(value.getBytes());
            return Base64.getEncoder().encodeToString(encryptedValue);
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | IllegalBlockSizeException | BadPaddingException |
                 InvalidKeyException e) {throw new RuntimeException(e);}
    }
    public static String crypt(String value) {
        return  crypt(value, Env.getEncryptionKey());
    }
    public static String decrypt(String encryptedValue, String key) {
        try {
            SecretKeySpec keySpec = new SecretKeySpec(key.getBytes(), algo);
            Cipher cipher = Cipher.getInstance(algo);
            cipher.init(Cipher.DECRYPT_MODE, keySpec);
            byte[] decryptedValue = cipher.doFinal(Base64.getDecoder().decode(encryptedValue));
            return new String(decryptedValue);
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | IllegalBlockSizeException | BadPaddingException | InvalidKeyException e) {throw new RuntimeException(e);}
    }
    public static String decrypt(String value) {
        return  decrypt(value, Env.getEncryptionKey());
    }

    public static String hash(String input) {
        try {
            byte[] hashedBytes = MessageDigest.getInstance("SHA-256").digest(input.getBytes());
            StringBuilder hexStringBuilder = new StringBuilder();
            for (byte b : hashedBytes) {
                hexStringBuilder.append(String.format("%02x", b));
            }
            return hexStringBuilder.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Erreur lors de la création du hachage", e);
        }
    }
}
