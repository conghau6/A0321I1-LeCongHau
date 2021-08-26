package _18_string_regex.thuc_hanh;

public class EmailExampleTest {
    public static final String[] validEmail = new String[] {"a@gmail.com", "ab@yahoo.com", "abc@hotmail.com"};
    public static final String[] invalidEmail = new String[] { "@gmail.com", "ab@gmail.", "@#abc@gmail.com" };

    public static void main(String[] args) {
        EmailExample emailExample = new EmailExample();
        for(String email : validEmail) {
            System.out.println("Email is " + email + " is valid:" + emailExample.validate(email));
        }

        for(String email : invalidEmail) {
            System.out.println("Email is " + email + " is invalid: " + emailExample.validate(email));
        }
    }
}
