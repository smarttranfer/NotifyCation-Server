package com.pushnotify.pushnotify.service;



import com.pushnotify.pushnotify.Respontory.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceToken {

    @Autowired
    private Token Tokennode;

    public boolean Settoken(String token_client){
        try{
            Tokennode.insertToken(token_client);
            return true;
        }catch (Exception e){
            System.out.println(e);
            return false;
        }

    }

    public List<String> getoken_client(){
            return Tokennode.gettken();

    }

    public boolean deteleToken(String Dtoken){
        try {
           Tokennode.DeleteToken(Dtoken);
            return true;
        }catch (Exception e){
            System.out.println(e);
            return false;
        }

    }




}
