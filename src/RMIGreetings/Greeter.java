package RMIGreetings;

import java.rmi.*;
import java.rmi.server.*;

public class Greeter extends UnicastRemoteObject implements IGreeter {

    public Greeter() throws RemoteException {
        super();
    }

    @Override
    public void Greet(String Name) throws RemoteException {
        System.out.println("Hello " + Name + "!\nHope You're Having a Nice Day!");
    }
}
