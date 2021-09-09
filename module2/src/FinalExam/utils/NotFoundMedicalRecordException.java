package FinalExam.utils;

public class NotFoundMedicalRecordException extends Exception {
    public NotFoundMedicalRecordException(String string) {
        super(string);
    }

    public NotFoundMedicalRecordException() {
        super("Invalid");
    }
}
