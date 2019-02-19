package com.codeup.adlister.util;

public class StringFormatException extends Exception{

    private String message;

    public StringFormatException(){
        super();
        this.message = null;
    }

    public StringFormatException(String message){
        this();
        if(message.equals("")){
            this.message = null;
        }else{
            this.message = message;
        }
    }

    @Override
    public void printStackTrace() {
        if(this.message != null){
            System.out.println(this.message);
        }
        super.printStackTrace();
    }
}
