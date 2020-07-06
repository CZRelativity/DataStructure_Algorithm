package Easy_Test;

import Easy.is_valid;

public class test_is_valid {

    public static void main(String[] args) {

        is_valid t = new is_valid();
//        System.out.println(t.isValid_Original("()"));
//        System.out.println(t.isValid_Original("()[]{}"));
//        System.out.println(t.isValid_Original("(]"));
//        System.out.println(t.isValid_Original("([)]"));
//        System.out.println(t.isValid_Original("{[]}"));
//        System.out.println("\n");
//        System.out.println(t.isValid_Specific(""));
//        System.out.println(t.isValid_Specific("["));
//        System.out.println(t.isValid_Specific("}]"));
//        System.out.println(t.isValid_Specific("([)"));
//        System.out.println(t.isValid_Specific("{{)}"));
//        System.out.println(t.isValid_Specific("(([]){})"));
//        System.out.println(t.isValid_SubString("(([]){})"));
//        System.out.println(t.isValid_SubString("}]"));
//        System.out.println(t.isValid_SubString("{{)}"));
//        System.out.println(t.isValid_SubString("(){}[]"));
//        System.out.println(t.isValid_SubString("(]"));
//        System.out.println(t.isValid_SubString("([)]"));
//        System.out.println(t.isValid_SubString("{[]}"));
//        System.out.println(t.isValid_Specific("()"));
//        System.out.println(t.isValid_Specific("()[]{}"));
//        System.out.println(t.isValid_Specific("(]"));
//        System.out.println(t.isValid_Specific("([)]"));
//        System.out.println(t.isValid_Specific("{[]}"));
        System.out.println(t.isValid_Stack(""));
        System.out.println(t.isValid_Stack("([)"));
        System.out.println(t.isValid_Stack("(([]){})"));
    }
}
