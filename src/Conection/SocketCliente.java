package Conection;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.net.Socket;
import java.security.SecureRandom;


    public class SocketCliente {
        private static int contadorInstancias = 0;
        private Socket clientSocket;
        private PrintWriter out;
        private BufferedReader in;
        private DiffieHellman diffieHellman;
        private int puerto;

        public SocketCliente(String host) throws Exception {
            if (contadorInstancias + Configuracion.PUERTO_INICIAL > Configuracion.PUERTO_FINAL) {
                throw new Exception("Se ha superado el límite de instancias permitidas");
            }
            puerto = Configuracion.PUERTO_INICIAL + contadorInstancias;
            contadorInstancias++;

            clientSocket = new Socket(host, puerto);
            System.out.println("Conectado al servidor");

            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            BigInteger p = new BigInteger("23");  // Deberías usar un número primo grande en la práctica
            BigInteger g = new BigInteger("5");   // Deberías usar una base segura en la práctica
            diffieHellman = new DiffieHellman(p, g);

            out.println(diffieHellman.getPublicKey());
            BigInteger publicKeyServer = new BigInteger(in.readLine());
            diffieHellman.generateSharedKey(publicKeyServer);
        }

        public void enviarMensaje(String mensaje) throws Exception {
            String mensajeCifrado = AES.encrypt(mensaje, diffieHellman.getSharedKey().toString());
            out.println(mensajeCifrado);
        }

        public String recibirMensaje() throws Exception {
            String mensajeCifrado = in.readLine();
            return AES.decrypt(mensajeCifrado, diffieHellman.getSharedKey().toString());
        }

        public void cerrarConexion() throws Exception {
            in.close();
            out.close();
            clientSocket.close();
        }
    }


class DiffieHellman {
    private final static BigInteger one = new BigInteger("1");
    private final static SecureRandom random = new SecureRandom();

    private BigInteger privateKey;
    private BigInteger publicKey;
    private BigInteger sharedKey;
    private BigInteger modulus;   // p
    private BigInteger base;      // g

    public DiffieHellman(BigInteger modulus, BigInteger base) {
        this.modulus = modulus;
        this.base = base;
        generateKey();
    }

    private void generateKey() {
        privateKey = new BigInteger(modulus.bitLength() - 1, random);
        publicKey = base.modPow(privateKey, modulus);
    }

    public void generateSharedKey(BigInteger publicKeyOtherParty) {
        sharedKey = publicKeyOtherParty.modPow(privateKey, modulus);
    }

    public BigInteger getPublicKey() {
        return publicKey;
    }

    public BigInteger getSharedKey() {
        return sharedKey;
    }
}
