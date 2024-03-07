package utils.service;
import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;
import java.security.spec.X509EncodedKeySpec;

public class KeyGeneration {

    private static KeyPairGenerator keyPairGenerator;
    private static SecureRandom secureRandom;
    PrivateKey privateKey;
    PublicKey publicKey;

    public KeyGeneration(){
        
     
    }
    /* 
    public static PrivateKey generatePrivateKey() throws NoSuchAlgorithmException, NoSuchProviderException {
        // Genera una clave privada RSA
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(2048, new SecureRandom());
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        PrivateKey privateKey = keyPair.getPrivate();

        return privateKey;
    }

    public static PublicKey generatePublicKey() throws NoSuchAlgorithmException, NoSuchProviderException {
        // Genera un par de claves RSA
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(2048, new SecureRandom());
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        PublicKey publicKey = keyPair.getPublic();

        return publicKey;
    }

    public static String publicKeyToString(PublicKey publicKey) throws Exception {
        // Codifica la clave pública en formato X.509
        X509EncodedKeySpec spec = new X509EncodedKeySpec(publicKey.getEncoded());
        // Convierte la clave pública codificada en una cadena Base64
        return Base64.getEncoder().encodeToString(spec.getEncoded());
    }

    public static String privateKeyToString(PrivateKey privateKey) throws Exception {
        // Codifica la clave privada en formato PKCS#8
        PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(privateKey.getEncoded());
        // Convierte la clave privada codificada en una cadena Base64
        return Base64.getEncoder().encodeToString(spec.getEncoded());
    }

  */
  static {
    try {
        keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        secureRandom = new SecureRandom();
        keyPairGenerator.initialize(2048, secureRandom);
    } catch (NoSuchAlgorithmException e) {
        e.printStackTrace();
    }
}

public static PrivateKey generatePrivateKey2() throws Exception {
    KeyPair keyPair = keyPairGenerator.generateKeyPair();
    return keyPair.getPrivate();
}

public static PublicKey generatePublicKey() throws Exception {
    KeyPair keyPair = keyPairGenerator.generateKeyPair();
    return keyPair.getPublic();
}

public static String privateKeyToString(PrivateKey privateKey) throws Exception {
    PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(privateKey.getEncoded());
    return Base64.getEncoder().encodeToString(spec.getEncoded());
}

public static String publicKeyToString(PublicKey publicKey) throws Exception {
    X509EncodedKeySpec spec = new X509EncodedKeySpec(publicKey.getEncoded());
    return Base64.getEncoder().encodeToString(spec.getEncoded());
}


    
}
