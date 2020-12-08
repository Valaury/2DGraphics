package RMIGreetings;

import RMIGreetings.IGreeter;
import RMIGreetings.Greeter;
import java.net.MalformedURLException;
import java.rmi.*;
import java.rmi.registry.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main_Greeter {

    static String RMIUrl = "rmi://localhost:4000/Greeter";

    static Greeter svGreeter;
    static IGreeter iGreeter;

    public static void main(String args[]) {
        RegisterGreeterOnLocalhost();
        LocateGreeterOnLocalhost();
        GreetUser();
        System.exit(0);
    }

    private static void RegisterGreeterOnLocalhost() {
        try {
            svGreeter = new Greeter();
            LocateRegistry.createRegistry(4000);
            Naming.rebind(RMIUrl, svGreeter);
            System.out.println("Greeter Running on " + RMIUrl);
        } catch (RemoteException | MalformedURLException ex) {
            Logger.getLogger(Main_Greeter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void LocateGreeterOnLocalhost() {
        System.out.println("Locating Greeter...");
        try {
            iGreeter = (IGreeter) Naming.lookup(RMIUrl);
        } catch (NotBoundException | MalformedURLException | RemoteException ex) {
            Logger.getLogger(Main_Greeter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void GreetUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Whats Your Name?");
        String userName = scanner.nextLine();
        try {
            iGreeter.Greet(userName);
        } catch (RemoteException ex) {
            Logger.getLogger(Main_Greeter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
