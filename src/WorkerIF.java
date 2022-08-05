import java.rmi.Remote;
import java.rmi.RemoteException;

public interface WorkerIF extends Remote {

    <T> T execute(Task<T> t) throws RemoteException;

    String getID() throws RemoteException;

}
