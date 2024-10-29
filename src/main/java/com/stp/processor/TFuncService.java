package com.stp.processor;

public class TFuncService {

    public static <T extends Number> T functionChooser(T first, TFunc func){

        String currentOperation = func.getFunction();
        T answer;

        switch (currentOperation){
            case "Rev" -> {
                answer = revFunction(first);
            }
            case "Sqr" -> {
                answer = sqrFunction(first);
            }
            default -> {
                return null;
            }
        }
        return answer;
    }

    private static <T extends Number> T typeChooser(T number, double result){

        if (number instanceof Integer){
            number = (T) Integer.valueOf((int)result);
        } else if (number instanceof Double){
            number = (T) Double.valueOf(result);
        } else if (number instanceof Float){
            number = (T) Float.valueOf((float)result);
        } else if (number instanceof Long){
            number = (T) Long.valueOf((long)result);
        } else if (number instanceof Short){
            number = (T) Short.valueOf((short)result);
        } else if (number instanceof Byte){
            number = (T) Byte.valueOf((byte)result);
        }

        return number;
    }

    private static <T extends Number> T revFunction(T first){
        double result = first.doubleValue() * -1;
        T answer = typeChooser(first, result);
        return answer;
    }

    private static <T extends Number> T sqrFunction(T first){
        double result = Math.sqrt(first.doubleValue());
        T answer = typeChooser(first, result);
        return answer;
    }
}
