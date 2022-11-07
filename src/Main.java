public class Main {
    public static void main(String[] args) {
        String a = "aabbbc";
        String b = "helllllllo";
        String c = "wonderful";
        System.out.println(solution(a));
//        System.out.println(solution(b));
//        System.out.println(solution(c));
    }

    public static String solution (String line) {
        String answer = "";
        String[] lineArr = line.split(""); // [a, a, b, b, b, c]
        String temp = "";
        for(int i = 0; i < lineArr.length; i++) {// a a
            System.out.println("i" + i);
            if(i == 0) {
                answer += lineArr[i];
                temp = lineArr[i];
                continue;
            } else {
                String lastAlp = String.valueOf(answer.charAt(answer.length() - 1));
                if("*".equals(lastAlp)) {
                    if(!temp.equals(lineArr[i])) {
                        answer += lineArr[i];
                    }
                    System.out.println("*if : " + answer);
                    continue;
                } else if(lastAlp.equals(lineArr[i])) {
                    answer += "*";
                    temp = lineArr[i];
                    System.out.println("*elseIf : " + answer);
                    continue;
                } else {
                    answer += lineArr[i];
                    temp = lineArr[i];
                    System.out.println("*else : " + answer);
                }
            }
        }
        return answer;
    }
}