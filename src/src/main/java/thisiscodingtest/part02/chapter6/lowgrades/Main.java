package thisiscodingtest.part02.chapter6.lowgrades;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 성적이 낮은 순서로 학생 출력 -> 성적이 동일하면 자유롭게 출력
// 학생이름과 점수를 입력 데이터를 받는 것을 보고 '객체' 를 만들어서 정렬해야겠다고 생각
class Student implements Comparable<Student> {

    private String name;

    private int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    /**
     * ascending : this.score - o.score;
     * descending : o.score - this.score;
     */
    @Override
    public int compareTo(Student o) {
        return this.score - o.score;
    }
}

public class Main {

    private static int n;
    private static List<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        initializeInputData();
        ascendingSort();
        printData();
    }

    // 입력 데이터 초기화
    private static void initializeInputData() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String name = sc.next();
            int score = sc.nextInt();
            students.add(new Student(name, score));
        }
    }

    // 오름 차순 정렬
    private static void ascendingSort() {
        students.sort(Student::compareTo);
    }

    // 데이터 출력
    private static void printData() {
        for(Student student : students) {
            System.out.print(student.getName() + " ");
        }
    }
}
