package com.eventapplication.eventapplication.common;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.HashMap;

/**
 * configuration response builder class for return  response
 */
public class ResponseBuilder {
    @JsonProperty("message")
    private String message;
    @JsonProperty("status")
    private int status;
    @JsonProperty("data")
    private Object  data=new HashMap<>();
    @JsonProperty("metaData")
    private Object metaData=new HashMap<>();
    public ResponseBuilder(){

    }

    private ResponseBuilder(String message,int status, Object data,Object metaData){
        this.message=message;
        this.status=status;
        this.data=data;
        this.metaData=metaData;
    }

    public  ResponseBuilder setMassage(String message){
        this.message=message;
        return this;
    }
    public ResponseBuilder setStatus (int status){
        this.status=status;
        return  this;
    }
    public ResponseBuilder setData(Object data){
        this.data=data;
        return this;
    }
    public ResponseBuilder setMetaData(Object metaData){
        this.metaData=metaData;
        return this;
    }
    public ResponseBuilder build(){
        return new ResponseBuilder(message,status,data,metaData);
    }

}
