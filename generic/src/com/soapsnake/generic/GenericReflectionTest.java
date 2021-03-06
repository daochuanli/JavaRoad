package com.soapsnake.generic;

import java.util.Arrays;
import java.util.Scanner;

public class GenericReflectionTest {

    public static void main(String[] args) {
        String name;
        if (args.length > 0) name = args[0];
        else {
            try (Scanner in = new Scanner(System.in)) {
                System.out.println("Enter class name(e.g.java.util.Collections())");
                name = in.next();
            }

            try {
                Class<?> cl = Class.forName(name);  //获取用户输入的类的class
                printClass(cl);   //打印该class
                for (Method method : cl.getDeclaredMethods())
                    printMethod(method);  //获取class的所有方法
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public static void printClass(Class<?> cl) {   //打印class信息
        System.out.println(cl);
        printTypes(cl.getTypeParameters(), "<", ",", ">", true);
        Type sc = cl.getGenericSuperclass();
        if (sc != null) {
            System.out.println(" extends ");
            printType(sc, false);
        }
        printTypes(cl.getGenericInterfaces(), " implements ", ",", "", false);
        System.out.println();
    }

    public static void printMethod(Method m) {
        String name = m.getName();
        System.out.println(Modifier.toString(m.getModifiers()));
        System.out.println(" ");
        printTypes(m.getTypeParameters(), "<", ",", ">", true);
        System.out.println(" ");
        System.out.println(name);
        System.out.println("(");
        printTypes(m.getGenericParameterTypes(), ",", ",", "", false);
        System.out.println(")");
    }

    public static void printTypes(Type[] types, String pre, String sep, String suf, boolean isDefinition) {
        if (pre.equals(" extends ") && Arrays.equals(types, new Type[]{Object.class})) return;
        if (types.length > 0) System.out.println(pre);
        for (int i = 0; i < types.length; i++) {
            if (i > 0) System.out.println(sep);
            printType(types[i], isDefinition);
        }
        if (types.length > 0) System.out.println(suf);
    }

    public static void printType(Type type, boolean isDefinition) {
        if (type instanceof Class) {
            Class<?> t = (Class<?>) type;
            System.out.println(t.getName());
        } else if (type instanceof TypeVariable) {
            TypeVariable<?> t = (TypeVariable<?>) type;
            System.out.println(t.getName());
            if (isDefinition)
                printTypes(t.getBounds(), "extends", "&", "", false);
        } else if (type instanceof WildcardType) {
            WildcardType t = (WildcardType) type;
            System.out.println("?");
            printTypes(t.getUpperBounds(), "extends", "&", "", false);
            printTypes(t.getLowerBounds(), "super", "&", "", false);
        } else if (type instanceof ParameterizedType) {
            ParameterizedType t = (ParameterizedType) type;
            Type owner = t.getOwnerType();
            if (owner != null) {
                printType(owner, false);
                System.out.println(".");
            }
            printType(((ParameterizedType) type).getRawType(), false);
            printTypes(t.getActualTypeArguments(), "<", ",", ">", false);
        } else if (type instanceof GenericArrayType) {
            GenericArrayType t = (GenericArrayType) type;
            System.out.println("");
            printType(((GenericArrayType) type).getGenericComponentType(), isDefinition);
            System.out.println("[]");
        }
    }
}
		
		
		
		
		
		
		
		
