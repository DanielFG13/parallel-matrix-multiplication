import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Worker extends UnicastRemoteObject implements WorkerIF {
    private static final long serialVersionUID = 1L;
    private String ID;

    public Worker() throws RemoteException {
        super();
        ID = IPFinder.getIP().substring(1);
    }

    @Override
    public <T> T execute(Task<T> task) throws RemoteException {
        return task.execute();
    }

    @Override
    public String getID() throws RemoteException {
        return this.ID;
    }

    public static void main(String[] args) {
        String host = "192.168.3.3";
        short port_register = 2080;
        String ip = IPFinder.getIP().substring(1); 

        try {
            // Conexion al objeto remoto
            System.setProperty("java.rmi.server.hostname", ip);
            WorkerIF worker = new Worker();
            Registry registry_register = LocateRegistry.getRegistry(host, port_register);
            Register register = (Register) registry_register.lookup("register");
            register.register(worker);
            System.out.println("ID de Worker: " + worker.getID());

            // Monitorea la conexion al servidor
            while (true) {
                try {
                    register.checkConnection();
                    Thread.sleep(2000);
                } catch (RemoteException e) {
                    System.out.println("Disconnected by PC side");
                    System.err.println(e.getMessage());
                    System.exit(1);
                } catch (InterruptedException e) {
                    System.err.println(e.getMessage());
                    System.exit(1);
                }

            }
        } catch (RemoteException e) {
            System.err.println(e.getMessage());
            System.exit(1);
        } catch (NotBoundException e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }
    }

}