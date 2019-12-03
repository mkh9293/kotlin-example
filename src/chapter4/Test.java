package chapter4;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        Lists lists = new Lists();
    }
}

class Lists<T> {

    public List<? extends Object> wildMethod1() {
        return new ArrayList<Long>();
    }

    public <E> List<? extends String> wildMethod12 (E t) {
        return new ArrayList<String>();
    }

    public List<?> method3() {
        return new ArrayList<>();
    }
}