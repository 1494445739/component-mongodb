package com.tzg.component.mongodb;

import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import java.util.List;

public interface MongoDBService< T > {

    void insert( T object, String collectionName ) throws Exception;

    void delete( Query query, T object, String collectionName ) throws Exception;

    void update( Query query, Update update, T object, String collectionName ) throws Exception;

    T selectOne( Query query, T object, String collectionName ) throws Exception;

    List< T > selectList( Query query, T object, String collectionName ) throws Exception;

}
