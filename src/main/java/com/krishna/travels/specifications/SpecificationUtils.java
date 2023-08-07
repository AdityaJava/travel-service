package com.krishna.travels.specifications;

public class SpecificationUtils {

    public static Object castToRequiredType(Class fieldType, String value) {
        if (fieldType.isAssignableFrom(Double.class)) {
           return Double.valueOf(value);
        } else if (fieldType.isAssignableFrom(Integer.class)) {
           return Integer.valueOf(value);
        } else if (fieldType.isAssignableFrom(Long.class)) {
            return Long.valueOf(value);
        }else if (fieldType.isAssignableFrom(Enum.class)) {
           return Enum.valueOf(fieldType, value);
        } else if (fieldType.isAssignableFrom(String.class)) {
            return String.valueOf(value);
        }
        return null;
    }



}
