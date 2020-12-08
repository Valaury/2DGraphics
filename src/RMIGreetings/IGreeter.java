package RMIGreetings;

import java.rmi.*;

public interface IGreeter extends Remote {
    public void Greet(String Name) throws RemoteException;
}