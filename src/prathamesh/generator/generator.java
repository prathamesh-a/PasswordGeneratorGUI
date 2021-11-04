package prathamesh.generator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class generator {
    private final input input;
    private final StringBuilder str = new StringBuilder();
    private final StringBuilder password = new StringBuilder();

    public generator(input input){
        this.input = input;
        generateString();
        setPassword();
    }

    private void generateString(){
        if (input.includeSymbols)str.append("~!@#$%^&*()=+/<>?{}[]");
        if (input.includeNumbers)str.append("0123456789");
        if (input.includeUppercase)str.append("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
        if (input.includeLowercase)str.append("abcdefghijklmnopqrstuvwxyz");
        if (str.length() < input.length){
            for (int i=0; i<input.length; i++){
                str.append(str.charAt(i));
            }
        }
    }

    private void setPassword(){
        List<Character> list = new ArrayList<>();
        char[] charArr = str.toString().toCharArray();
        for (char c : charArr){list.add(c);}
        Collections.shuffle(list);
        for (int i=0; i<input.length; i++){
            this.password.append(list.get(i));
        }
    }

    public String getPassword(){
        return this.password.toString();
    }
}
