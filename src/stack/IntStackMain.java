package stack;

import java.util.Scanner;

public class IntStackMain {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        IntStack stack = new IntStack(64);

        while(true){
            System.out.println();
            System.out.printf("현재 데이터 수 : %d / %d%n",stack.size(),stack.getCapacity());
            System.out.print("1. 푸시, 2. 팝, 3. 피크, 4. 덤프, 0. 종료");

            int menu = input.nextInt();
            if(menu==0)break;

            int number;
            switch(menu){
                case 1:
                    System.out.print("데이터: ");
                    number = input.nextInt();
                    try {
                        stack.push(number);
                    } catch (Exception e) {
                        System.out.println("스택이 가득차 있어 더 이상 데이터 푸시 불가");
                    }
                    break;
            }
        }
    }
}
