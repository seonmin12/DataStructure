package stack;
// int형 고정 길이 스택이다.

public class IntStack {
    // 자료 저장공간: 스택용배열
    private int[] stk;
    // 스택포인터 : 해당 스택의 자료의 개수와 위치를 파악가능
    private int ptr;
    //스택의 용량
    private int capacity;

    public IntStack() {
    }

    public IntStack(int maxlength) {
        //생성자를 이용하여 초기화
        this.ptr = 0; //새로운 데이터를 삽입할때 인덱스를 저장 변수 ==> 스택의 인덱스를 가리킨다.
        this.capacity = maxlength;
        try {
            stk = new int[capacity]; //스택 본체용 배열을 생성 stk[0],stk[1]...stk[capacity-1]
        } catch (OutOfMemoryError e) {//생성할 수 없을때의 예외 처리

            capacity = 0;
        }

    }


    //실행시 예외: 스택이 비어있다.
    class EmptyIntStackException extends RuntimeException {
        public EmptyIntStackException() {

        }

    }

    //실행시 예외: 스택이 가득 찼을때
    class OverflowIntStackException extends RuntimeException {
        public OverflowIntStackException() {

        }
    }
        //데이터를 삽입: push() /throws는 위임함 throw는 발생시킴 강제로 인스턴스 시킴
        public int push(int num) throws OverflowIntStackException {
            if (ptr >= capacity) throw new OverflowIntStackException();

            return stk[ptr++] = num;
        }


        //데이터를 꺼내기: pop()
        public int pop() throws EmptyIntStackException {
            if (ptr < 0) throw new EmptyIntStackException();
            return stk[--ptr];
        }

        //스택의 꼭대기에 있는 데이터를 들여다 보는 메서드: 스택이 비어있으면 예외:EmptyIntStackException
        public int peek() throws EmptyIntStackException {
            if (ptr <= 0) throw new EmptyIntStackException();

            return stk[ptr - 1]; // 스택이 비어있지 않다면 꼭대기에 있는 stk[ptr-1]의 값을 반환시킨다
        }

        public int getCapacity() {
            return capacity;

        }


        //스택에 쌓여 있는 데이터의 개수를 반환 메소드: size()
        public int size() {

            return ptr;
        }





    //스택안의 모든데이터를 바닥부터 꼭대기까지 순서대로 출력기능:dump()
    public void dump() {
        if (ptr <= 0) {
            System.out.println("스택이 비어있습니다");
        } else {
            for (int i = 0; i < ptr; i++) {
                System.out.printf("stk[%d] = %d = ", i, stk[i]);
                System.out.println();
            }
        }
    }
}
