package com.example.day16;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntSupplier;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import org.w3c.dom.ls.LSOutput;

public class RamdaExam3 {
    public static void main(String[] args) {
        // Predicate
        // 조건을 테스트하는데 사용. boolean값 반환
        Predicate<Integer> isPositive = x -> x>0;
        System.out.println(isPositive.test(10));
        System.out.println(isPositive.test(-10));

        // Consumer
        // 입력을 받고 반환값이 없는 연산을 수행
        Consumer<String> printer = s -> System.out.println(s);
        printer.accept("hello carami!!!");

        // Function
        // 입력을 받아서 출력을 반환하는...
        Function<String, Integer> lengthFunc = s -> s.length();
        System.out.println(lengthFunc.apply("hello caafasdf"));

        // Supplier
        // 입력 없이 값을 반환
        Supplier<Double> randomSupplier = () -> Math.random();
        System.out.println(randomSupplier.get());

        IntSupplier intSupplier = () -> (int) (Math.random()*6)+1;
        System.out.println(intSupplier.getAsInt());

        // UnaryOperator
        // 입력과 출력이 같은 타입의 값일 때 사용.
        UnaryOperator<Integer> square = x -> x * x;

        System.out.println(square.apply(5));

        // Bifunction
        // 두 개의 입력을 받고 하나의 결과를 반환
        BiFunction<Integer, Integer, Integer> add = (a,b) -> a+b;
        System.out.println(add.apply(5,6));

        // Consumer의 andThen 메소드 활용
        Consumer<String> conA = s -> System.out.println(s+"aaaa");
        Consumer<String> conB = s -> System.out.println(s+"bbbb");
        conA.accept("heoo");
        conB.accept("heoo");

        Consumer<String> conAB =  conA.andThen(conB);
        conAB.accept("fkfkfkfk");
    }
}
