package com.example.criminalintent;

import java.util.Date;
import java.util.UUID;

public class Crime {

    private UUID mId;
    private String mTitle;
    private Date mDate;
    private boolean mSolved;

    public Crime(){
        // generate the unique identifier
        mId = UUID.randomUUID();
        mDate = new Date();
    }

    //GETTERS
    public UUID getmId(){
        return this.mId;
    }
    public String getmTitle(){
        return  this.mTitle;
    }
    public Date getmDate(){
        return this.mDate;
    }
    public boolean getmSolved(){
        return this.mSolved;
    }

    //SETTERS
    public void setmId(UUID id){
        this.mId = id;
    }
    public void setmTitle(String title){
        this.mTitle = title;
    }
    public void setmDate(Date date){
        this.mDate = date;
    }
    public void setmSolved(boolean solved){
        this.mSolved = solved;
    }
}
