package com.example.caaalculator;

import android.util.Log;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.ScriptableObject;

public class Calculator {
    String curstring = "";
    public Calculator(){

    }
    public String addSymbol(String symbol){
        curstring += symbol;
        return curstring;
    }
    public String calculate(){
        try {
            Context rhino = Context.enter();
            rhino.setOptimizationLevel(-1);
            Scriptable scope = rhino.initStandardObjects();
            Object result = rhino.evaluateString(scope, curstring + ";", "JavaScript", 1, null).toString();
            String stresult = rhino.toString(result);
            curstring = stresult;
        } catch(Throwable e){
            curstring = "Syntax Error";
            Log.e("tag", e.getMessage());
        } finally {
            Context.exit();
        }
        return curstring;
    }
    public String deleteSymbol(){
        curstring = curstring.substring(0, curstring.length() - 1);
        return curstring;
    }
    public String clearString(){
        curstring = "";
        return curstring;
    }
}
