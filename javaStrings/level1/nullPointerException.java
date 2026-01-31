

public class ques4 {
    static void generateException(){
        String text = null;
        System.out.println(text.length());

    }
    static void handleexception(){
        String text = null;
        try{
            System.out.println(text.length());
        }catch(NullPointerException e){
            System.out.println("NullPointerException caught and handled. ");
            System.out.println("Reason: You are trying to access method on a null value and an object. ");
        }
    }
    public static void main(String[] args) {
        System.out.println("Generating NullPointerException: ");
        try{
            generateException();
        }catch(NullPointerException e){
            System.out.println("Exception Occured in generateException()");
        }
        System.out.println("Handling it");
        handleexception();
    }
}
