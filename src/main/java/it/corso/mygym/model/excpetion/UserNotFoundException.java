package it.corso.mygym.model.excpetion;

public class UserNotFoundException extends RuntimeException{

    public UserNotFoundException(final String msg, final Long userId){
        super(String.format(msg, userId));
    }
}
