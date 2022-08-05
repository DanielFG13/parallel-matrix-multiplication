import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Register extends Remote {
    boolean register(WorkerIF worker) throws RemoteException;
    void checkConnection() throws RemoteException;
}
