package com.stp.processor;

public class TOprntService {

    public static <T extends Number> T operationChooser(T first, T second, TOprtn operation){

        String currentOperation = operation.getOperation();
        T answer;

        switch (currentOperation){
            case "Add" -> {
                answer = addOperation(first, second);
            }
            case "Sub" -> {
                answer = subOperation(first, second);
            }
            case "Mul" -> {
                answer = mulOpertaion(first, second);
            }
            case "Div" -> {
                answer = divOperation(first, second);
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

    private static <T extends Number> T addOperation(T first, T second){
        double result = first.doubleValue() + second.doubleValue();
        T answer = typeChooser(first, result);
        return answer;
    }

    private static <T extends Number> T subOperation(T first, T second){
        double result = first.doubleValue() - second.doubleValue();
        T answer = typeChooser(first, result);
        return answer;
    }

    private static <T extends Number> T mulOpertaion(T first, T second){
        double result = first.doubleValue() * second.doubleValue();
        T answer = typeChooser(first, result);
        return answer;
    }

    public static <T extends Number> T divOperation(T first, T second){
        double result;
        try{
            result = first.doubleValue() / second.doubleValue();
        }
        catch (ArithmeticException e){
            throw new IllegalArgumentException("Division by zero!!!");
        }
        T answer = typeChooser(first, result);
        return answer;
    }
}
