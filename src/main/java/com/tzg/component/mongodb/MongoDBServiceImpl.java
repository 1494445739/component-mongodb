package com.tzg.component.mongodb;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MongoDBServiceImpl< T > implements MongoDBService< T > {

    @Resource
    private MongoTemplate mongoTemplate;

    @Override
    public void insert( T object, String collectionName ) throws Exception {
        mongoTemplate.insert( object, collectionName );
    }

    @Override
    public void delete( Query query, T object, String collectionName ) throws Exception {
        mongoTemplate.remove( query, object.getClass(), collectionName );
    }

    @Override
    public void update( Query query, Update update, T object, String collectionName ) throws Exception {
        mongoTemplate.upsert( query, update, object.getClass(), collectionName );
    }

    @Override
    @SuppressWarnings( "unchecked" )
    public T selectOne( Query query, T object, String collectionName ) throws Exception {
        return ( T ) mongoTemplate.findOne( query, object.getClass(), collectionName );
    }

    @Override
    @SuppressWarnings( "unchecked" )
    public List< T > selectList( Query query, T object, String collectionName ) throws Exception {
        return ( List< T > ) mongoTemplate.find( query, object.getClass(), collectionName );
    }

}
