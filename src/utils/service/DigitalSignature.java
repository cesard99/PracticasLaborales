package utils.service;


import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

public class DigitalSignature {
    
    public static String signText(String text, PrivateKey privateKey) throws Exception {
        // Crea un objeto Signature para firmar el texto
        Signature signature = Signature.getInstance("SHA256withRSA");
        signature.initSign(privateKey);
        signature.update(text.getBytes());

        // Firma el texto
        byte[] signedBytes = signature.sign();

        // Convierte la firma en una cadena Base64 para su almacenamiento o transmisión
        return Base64.getEncoder().encodeToString(signedBytes);
    }

    public static boolean verifySignature(String text, String signatureBase64, PublicKey publicKey) throws Exception {
        // Decodifica la firma digital de Base64 a bytes
        byte[] signatureBytes = Base64.getDecoder().decode(signatureBase64);

        // Crea un objeto Signature para verificar la firma
        Signature signature = Signature.getInstance("SHA256withRSA");
        signature.initVerify(publicKey);
        signature.update(text.getBytes());

        // Verifica la firma
        return signature.verify(signatureBytes);
    }







}
