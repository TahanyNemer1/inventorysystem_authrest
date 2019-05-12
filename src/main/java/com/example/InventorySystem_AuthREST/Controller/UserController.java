package com.example.InventorySystem_AuthREST.Controller;

import com.example.InventorySystem_AuthREST.Model.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

@RestController
public class UserController {

    @PostMapping("/auth/authenticate")
    public ResponseEntity authenticate(@RequestBody UserDTO userDTO) throws RemoteException, NotBoundException, MalformedURLException {
        Authenticate authenticate = new Authenticate();
        boolean authenticated = authenticate.Authenticate(userDTO.getUsername(), userDTO.getPassword());

        if (authenticated == false) {
            return new ResponseEntity(HttpStatus.UNAUTHORIZED);
        }

        return new ResponseEntity(HttpStatus.OK);

    }

}


