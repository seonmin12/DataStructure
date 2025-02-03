package que;

import java.util.Scanner;

public class IntArrayQueTester {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 최대 64개를 인큐할 수 있는 큐 생성
        IntArrayQue que = new IntArrayQue(64);
        int x = 0;

        while(true){
            System.out.println("현재 데이터 개수:" + que.size() + "/" + que.capacity());
            System.out.print("(1)인큐 (2)디큐 (3)피크 (4) 덤프 (0) 종료 숫자로 선택하세요");
            int menu = in.nextInt();
            if(menu == 0) break;

            switch(menu){
                case 1:
                    System.out.println("숫자 데이터를 입력하세요");
                    x = in.nextInt();
                    try {
                        que.enque(x);
                    } catch (IntArrayQue.OverflowIntArrayQueException e) {
                        System.out.println("큐가 가득 찼습니다.");
                    }
                    break;

                case 2:
                    try {
                        x = que.deque();
                    } catch (IntArrayQue.EmptyIntArrayQueException e) {
                        System.out.println("큐가 비어 있습니다. 더 이상 디큐할 데이터가 존재하지 않습니다");
                    } break;
                case 3:
                    try {
                        x = que.peek();
                        System.out.println("피크 데이터는 "+ x);
                    } catch (IntArrayQue.EmptyIntArrayQueException e) {
                        System.out.println("큐가 비어 있습니다. 더 이상 피크할 데이터가 존재하지 않습니다");

                    }
                case 4:
                    que.dump();
                    break;

            }
        }
    }
}
