package org.codeComposer;

import org.codeComposer.parser.Code;

public class Util {

    public static boolean parse(String input) {
        Code code = new Code();
        return code.parse(input);
    }

    public static boolean check(String input) {
        Code code = new Code();
        return code.parse(input) && code.check();
    }

    public static boolean everything(String input) {
        Code code = new Code();
        return code.parse(input) && code.check(); // todo more
    }
}
