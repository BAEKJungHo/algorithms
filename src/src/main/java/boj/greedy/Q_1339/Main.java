package boj.greedy.Q_1339;

import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int answer;
    static String[] words;
    static BufferedReader br;
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        input();
        sortByDesc();
        solution();
        writeAndClose();
    }

    static void input() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        words = new String[N];

        // 입력값을 거꾸로 입력받음.
        // 입력값은 큰 자리 수부터인데,
        // 거꾸로 입력받으면 아래 반복문에서 편하게 계산할 수 있음.
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            StringBuilder sb = new StringBuilder(input);
            words[i] = sb.reverse().toString();
        }
    }

    static void sortByDesc(){
        Arrays.sort(words, (s1, s2) -> s2.length() - s1.length());
    }

    static void solution() {
        Map<Character, Integer> map = new HashMap<>(); // key : 알파벳, value : 알파벳에 곱해지는 값.
        int start = words[0].length() - 1; // 가장 큰 자리수.

        for (int i = start; i >= 0; i--) {
            for (int j = 0; j < N; j++) {
                // 현재 자리 수보다 문자열의 길이가 짧은 경우.
                if (i >= words[j].length()) {
                    break;
                }

                char c = words[j].charAt(i);

                if (!map.containsKey(c)) {
                    map.put(c, (int) Math.pow(10, i));
                } else {
                    map.put(c, map.get(c) + (int) Math.pow(10, i));
                }
            }
        }

        List<Integer> list = new ArrayList<>();
        Iterator<Character> it = map.keySet().iterator();

        // list에 map의 value를 담음.
        while (it.hasNext()) {
            char c = it.next();
            list.add(map.get(c));
        }

        // 내림차순 정렬.
        Collections.sort(list, (a, b) -> b - a);

        int num = 9;

        // 곱해지는 값이 가장 큰 알파벳에 큰 수를 할당하는 것이 최선임.
        for (int i = 0; i < list.size(); i++) {
            answer += list.get(i) * num--;
        }
    }

    static void writeAndClose() throws IOException {
        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
