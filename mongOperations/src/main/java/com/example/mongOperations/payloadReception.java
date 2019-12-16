package com.example.mongOperations;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class payloadReception {

    @Id
    private String id;
//    @Indexed(unique = true)
    private String payloadName;
    private String payload;

    payloadReception(String payloadName, String payload){
        this.payloadName = payloadName;
        this.payload = payload;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPayloadName() {
        return payloadName;
    }

    public void setPayloadName(String payloadName) {
        this.payloadName = payloadName;
    }

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }

    @Override
    public String toString() {
        return "{" +
                "id='" + id + '\'' +
                ", payloadName='" + payloadName + '\'' +
                ", payload='" + payload + '\'' +
                '}';
    }
}
