package Conection;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.SecureRandom;


    public class SocketServidor {
        private static int contadorInstancias = 0;
        private ServerSocket serverSocket;
        private Socket clientSocket;
        private PrintWriter out;
        private BufferedReader in;
        private DiffieHellman diffieHellman;
        private int puerto;

        public SocketServidor() throws Exception {
            if (contadorInstancias + Configuracion.PUERTO_INICIAL > Configuracion.PUERTO_FINAL) {
                throw new Exception("Se ha superado el límite de instancias permitidas");
            }
            puerto = Configuracion.PUERTO_INICIAL + contadorInstancias;
            contadorInstancias++;

            serverSocket = new ServerSocket(puerto);
            System.out.println("Servidor iniciado en el puerto " + puerto);

            BigInteger p = new BigInteger("23");  // Deberías usar un número primo grande en la práctica
            BigInteger g = new BigInteger("5");   // Deberías usar una base segura en la práctica
            diffieHellman = new DiffieHellman(p, g);
        }

        public void esperarClientes() throws Exception {
            while (true) {
                esperarCliente();
            }
        }

        public void esperarCliente() throws Exception {
            clientSocket = serverSocket.accept();
            System.out.println("Cliente conectado");

            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            out.println(diffieHellman.getPublicKey());
            BigInteger publicKeyClient = new BigInteger(in.readLine());
            diffieHellman.generateSharedKey(publicKeyClient);
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
            serverSocket.close();
        }
    }
class DiffieHellmans {
    private final static BigInteger one = new BigInteger("1");
    private final static SecureRandom random = new SecureRandom();

    private BigInteger privateKey;
    private BigInteger publicKey;
    private BigInteger sharedKey;
    private BigInteger modulus;   // p
    private BigInteger base;      // g

    public DiffieHellmans(BigInteger modulus, BigInteger base) {
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

