import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Objects;


public class Server extends UnicastRemoteObject implements Operation, Register {

    private static final long serialVersionUID = 1L;
    private static ArrayList<WorkerIF> Workers;

    protected Server() throws RemoteException {
        super();
        Workers = new ArrayList<>();
    }

    public static void main(String[] args) {

        String ip = Objects.requireNonNull(IPFinder.getIP()).substring(1); 
        short port_register = 2080;
        short port_operation = 2081;

        try {
            // Inicia el registry
            System.setProperty("java.rmi.server.hostname", ip);
            Register register = new Server();
            Operation operation = new Server();
            Registry registry_register = LocateRegistry.createRegistry(port_register);
            Registry registry_operation = LocateRegistry.createRegistry(port_operation);
            registry_operation.rebind("operation", operation);
            registry_register.rebind("register", register);

            // Monitorea las conexiones hechas al servidor
            for (;;) {
                int i;
                boolean flag = false;
                System.out.printf("\r%60s\r", "");
                System.out.print("Connected IP : ");
                for (i = 0; i < Workers.size(); i++) {
                    try {
                        String ID = Workers.get(i).getID();
                        System.out.print(ID + " ");
                    } catch (RemoteException e) {
                        flag = true;
                        break;
                    }
                }
                if (flag) {
                    Workers.remove(i);
                }
                try {
                    Thread.sleep(1000);

                } catch (InterruptedException e) {
                }
            }
        } catch (RemoteException e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }
    }

    @Override
    public boolean register(WorkerIF worker) throws RemoteException {
        System.out.println(worker.getID());
        return Workers.add(worker);
    }

    @Override
    public void checkConnection() throws RemoteException {

    }

    @Override
    public int[][] mul(int[][] a, int[][] b) throws RemoteException {

        //Se asigna la carga de trabajo a cada thread.
        int workerSize = Workers.size();
        MulWorkload[] mulWorkload = new MulWorkload[workerSize];
        Thread thread[] = new Thread[workerSize];

        for (int i = 0; i < workerSize; i++) {
            mulWorkload[i] = new MulWorkload(a, b, i, Workers.get(i), workerSize);
            thread[i] = new Thread(mulWorkload[i]);
        }

        for (int i = 0; i < workerSize; i++) {
            thread[i].start();
            System.out.println("\nLa multiplicacion del Thread " + i + " ha comenzado..");
        }

        // Combina el resultado en la matriz C
        int[][] c = new int[a.length][a.length];
        for (int w = 0; w < workerSize; w++) {
            try {
                thread[w].join();
                for (int w_i = 0, i = w * c.length / workerSize; i < (w + 1) * c.length / workerSize; w_i++, i++) {
                    for (int j = 0; j < c.length; j++) {
                        c[i][j] = mulWorkload[w].c[w_i][j];
                    }
                }
                System.out.println("\nLa multiplicacion del Thread " + w + "ha finalizado..");
            } catch (InterruptedException e) {
                System.err.println("Error: " + e.getMessage());
            }
        }
        return c;
    }

}

