package com.codeup.adlister.util;

public class SingletonException extends Exception {

    private String message;

    public SingletonException(){
        super();
    }

    public SingletonException(String message){
        this();
        if(message.equals("")){
            message = null;
        }
        else {
            this.message = message;
        }
    }

    @Override
    public void printStackTrace() {
        if(this.message != null){
            System.out.println(message);
        }
        super.printStackTrace();

    }
}
