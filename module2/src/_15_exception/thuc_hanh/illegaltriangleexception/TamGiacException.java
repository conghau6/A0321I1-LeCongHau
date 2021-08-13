package _15_exception.thuc_hanh.illegaltriangleexception;

public class TamGiacException extends Exception {
    public TamGiacException(String message){
        super(message);
    }
    public TamGiacException(){
        super("Invalid");
    }
}
