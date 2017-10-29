package com.example.administrator.model;

import com.example.administrator.utils.Uuid;

/**
 * Created by zzc on 2017/10/29.
 */

public class Header {
    private String responseId;
    private String conversationId;
    public Header(){
        responseId= Uuid.getUUID();
        conversationId=Uuid.getUUID();
    }
}
