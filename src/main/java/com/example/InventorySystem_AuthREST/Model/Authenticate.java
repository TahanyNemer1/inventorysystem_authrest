package com.example.InventorySystem_AuthREST.Model;

import brugerautorisation.data.Bruger;
import brugerautorisation.transport.rmi.Brugeradmin;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class Authenticate {
    private String Username;
    private String Password;

    public boolean Authenticate(String Username, String Password) throws NotBoundException, MalformedURLException, RemoteException {
        Brugeradmin brugeradmin = (Brugeradmin) Naming.lookup("rmi://javabog.dk/brugeradmin"); //("rmi://localhost/brugeradmin");
        try{
            Bruger bruger = brugeradmin.hentBruger(Username, Password);
            this.Username = Username;
            this.Password = Password;
        }catch(IllegalArgumentException e){
            return false;
        }
        return true;
    }
}
