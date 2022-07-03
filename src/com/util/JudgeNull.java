package com.util;

public class JudgeNull {
    public boolean isEmpty(String str) {
        if (str.equals("") && str == null) {
            return true;
        }
        else {
            return false;
        }
    }
}
