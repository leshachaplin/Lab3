import java.io.BufferedReader;
import java.io.FileReader;

public class Lab3 {

    public static String[](String nameOfFile){
        try (FileReader fr = new FileReader(nameOfFile)) {
            BufferedReader isr = new BufferedReader(fr);
        }

    }

    public static void main(String[] args){

    }
}
