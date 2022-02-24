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
    @Query(value = "INSERT INTO tb_token (token,status) VALUES (:tokens,1)",nativeQuery = true)
    @Transactional
    void insertToken(@Param("tokens") String tokens);


    @Query(value = "select  tk.token from  tb_token tk where tk.status=1",nativeQuery = true)
    List<String> gettken();


    @Modifying
    @Query(value = "INSERT INTO tb_token (token,status) VALUES (:token,0)",nativeQuery = true)
    @Transactional
    void DeleteToken(@Param("token")String token);






}
