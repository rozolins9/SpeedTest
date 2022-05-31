import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    private Socket socket;
    private DataInputStream input;
    private DataOutputStream out;

    public Client(String address, int port) {
        try {
            socket = new Socket(address, port);
            System.out.println("Connected");

            input = new DataInputStream(System.in);

            out = new DataOutputStream(socket.getOutputStream());
        } catch (UnknownHostException u) {
            System.out.println(u);
        } catch (IOException i) {
            System.out.println(i);
        }
        String line = "";

        while (!line.equals("Over")) {
            try {
                line = input.readLine();
                out.writeUTF(line);
            } catch (IOException i) {
                System.out.println(i);
            }
        }

    }
    public static void main(String[] args) {
        Client client = new Client("192.168.0.100", 5050);
    }


//    public class SimpleClient {
//
//        public static void main(String[] args) throws Exception {
//            Socket socket = new Socket("192.168.0.100", 5050);
//            DataInputStream input = socket.getInputStream();
//            long total = 0;
//            long start = System.currentTimeMillis();
//
//            byte[] bytes = new byte[10240]; // 10K
//            while (true) {
//                int read = input.read(bytes);
//                total += read;
//                long cost = System.currentTimeMillis() - start;
//                if (cost > 0 && System.currentTimeMillis() % 10 == 0) {
//                    System.out.println("Read " + total + " bytes, speed: " + total / cost + "KB/s");
//                }
//            }
//        }
//
//    }
}

