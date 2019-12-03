package chapter5;

public class TestJava {
    public static void main(String[] args) {
        Greeting greeting = (playerName, numBuildings) -> {
            int currentYear = 2019;

            System.out.println(numBuildings + " 채의 건물이 추가됨");
            return "SimVillage 방문을 환영합니다, " + playerName + "! (copyright " + currentYear + ")";
        };

        System.out.println(greeting.greet("김선달", 6));
    }
}

interface Greeting {
    String greet(String playerName, int numBuildings);
}
