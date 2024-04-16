package com.example.day11.exam2;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class PopulationManager {
    //알맞게 구현해 주세요.
    private final Map<String, Integer> populationMap;

    public PopulationManager() {
        populationMap = new HashMap<>();
    }

    private void displayAll() {
        for (Entry<String, Integer> s : populationMap.entrySet()) {
            System.out.println(s.getKey() + ": " + s.getValue());
        }
    }

    private void displayPopulation(String city) {
        if (populationMap.containsKey(city)) {
            System.out.println(populationMap.get(city));
        } else {
            System.out.println("해당 도시를 찾을 수 없습니다.");
        }
    }

    private void removeCity(String city) {
        if (populationMap.containsKey(city)) {
            System.out.println(city + " 정보가 삭제되었습니다.");
            populationMap.remove(city);
        } else {
            System.out.println("해당 도시를 찾을 수 없습니다.");
        }
    }

    private void addOrUpdateCity(String city, int population) {
        System.out.println("도시 인구 정보가 추가되었습니다.");
        populationMap.put(city, population);
    }

    public static void main(String[] args) {
        final int EXIT = 5;
        final int ADD_OR_UPDATE = 1;
        final int REMOVE = 2;
        final int DISPLAY = 3;
        final int DISPLAY_ALL = 4;
        PopulationManager manager = new PopulationManager();
        Scanner scanner = new Scanner(System.in);

        manager.addOrUpdateCity("서울", 10000000);
        manager.addOrUpdateCity("부산", 3500000);

        while (true) {
            System.out.println("명령을 입력하세요 (1: 추가/수정, 2: 삭제, 3: 조회, 4: 전체 조회, 5: 종료): ");
            int command = scanner.nextInt(); // 사용자가 명령을 숫자로 입력
            if (command == EXIT) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }

            String city;
            switch (command) {
                case ADD_OR_UPDATE:
                    System.out.print("도시 이름을 입력하세요: ");
                    city = scanner.next();
                    System.out.print("인구를 입력하세요: ");
                    int population = scanner.nextInt();
                    manager.addOrUpdateCity(city, population);
                    break;
                case REMOVE:
                    System.out.print("도시 이름을 입력하세요: ");
                    city = scanner.next();
                    manager.removeCity(city);
                    break;
                case DISPLAY:
                    System.out.print("도시 이름을 입력하세요: ");
                    city = scanner.next();
                    manager.displayPopulation(city);
                    break;
                case DISPLAY_ALL:
                    manager.displayAll();
                    break;
                default:
                    System.out.println("알 수 없는 명령입니다.");
            }
        }
        scanner.close();    }
}
