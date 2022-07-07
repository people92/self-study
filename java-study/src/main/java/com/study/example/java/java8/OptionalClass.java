package com.study.example.java.java8;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@NoArgsConstructor
@Getter
@Setter
public class OptionalClass {

    private int id;
    private String title;
    private boolean closed;

    public OptionalClass(int id, String title, boolean closed) {
        this.id = id;
        this.title = title;
        this.closed = closed;
    }
    public String getTitle() {
        return title;
    }

    public static void main(String[] args) {

        List<OptionalClass> list = new ArrayList<>();
        OptionalClass optionalClass = new OptionalClass(1,"JPA",true);
        OptionalClass optionalClass2 = new OptionalClass(2,"spring boot",false);
        list.add(optionalClass);
        list.add(optionalClass2);

        Optional<OptionalClass> optional = list.stream()
                .filter(sc -> sc.getTitle().startsWith("spring"))
                .findFirst();

        OptionalClass optionalClassOrElse = optional.orElseGet(OptionalClass::createNewClass);
        System.out.println(optionalClassOrElse.getTitle());
    }

    private static OptionalClass createNewClass() {

        System.out.println("CREATE new CLASS");
        return new OptionalClass(10,"new", false);
    }
}
