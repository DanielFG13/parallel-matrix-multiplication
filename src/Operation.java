import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Operation extends Remote {
    int[][] mul(int[][] arg0, int[][] arg1) throws RemoteException;
}
