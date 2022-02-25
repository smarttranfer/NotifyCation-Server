package com.pushnotify.pushnotify.Respontory;

import com.pushnotify.pushnotify.Entity.TokenEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
@Repository
public interface Token extends CrudRepository<TokenEntity,Integer> {
    @Modifying
    @Query(value = "INSERT INTO tb_token (token,status,user) VALUES (:tokens,1,:user)",nativeQuery = true)
    @Transactional
    void insertToken(@Param("tokens") String tokens,@Param("user") String user);


    @Query(value = "select  tk.token from  tb_token tk where tk.status=1 and tk.user = :user",nativeQuery = true)
    List<String> gettken(@Param("user")String user);


    @Modifying
    @Query(value = "INSERT INTO tb_token (token,status,user) VALUES (:token,0,:user)",nativeQuery = true)
    @Transactional
    void DeleteToken(@Param("token")String token,@Param("user")String user);

//    @Modifying
//    @Query(value = "update tb_token N set N.status = 0 where N.token = ?1",nativeQuery = true)
//    void DeleteToken(String Dtoken);




}
