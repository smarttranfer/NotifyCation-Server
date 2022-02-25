package com.pushnotify.pushnotify.service;



import com.pushnotify.pushnotify.Respontory.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceToken {

    @Autowired
    private Token Tokennode;

    public boolean Settoken(String token_client,String user){
        try{
            Tokennode.insertToken(token_client,user);
            return true;
        }catch (Exception e){
            System.out.println(e);
            return false;
        }

    }

    public List<String> getoken_client(String user){
            return Tokennode.gettken(user);

    }

    public boolean deteleToken(String Dtoken,String user){
        try {
           Tokennode.DeleteToken(Dtoken,user);
            return true;
        }catch (Exception e){
            System.out.println(e);
            return false;
        }

    }




}
