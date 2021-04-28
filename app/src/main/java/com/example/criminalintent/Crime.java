package com.example.criminalintent;

import java.util.UUID;

public class Crime {

    private UUID mId;
    private String mTitle;

    public Crime(){
        // generate the unique identifier
        mId = UUID.randomUUID();
    }

    //GETTERS
    public UUID getmId(){
        return this.mId;
    }
    public String getmTitle(){
        return  this.mTitle;
    }

    //SETTERS
    public void setmId(UUID id){
        this.mId = id;
    }
    public void setmTitle(String title){
        this.mTitle = title;
    }
}
