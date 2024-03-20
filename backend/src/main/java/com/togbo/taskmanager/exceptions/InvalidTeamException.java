package com.togbo.taskmanager.exceptions;

public class InvalidTeamException extends Exception{

    public InvalidTeamException(){
        super();
    }
    public InvalidTeamException(String message){
        super(message);
    }
}
