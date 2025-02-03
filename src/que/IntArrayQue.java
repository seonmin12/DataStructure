package que;

public class IntArrayQue {

    //멤버(필드)
    private int[] que; //큐의 데이터 저장소
    private int capacity; // 큐의 용량
    private int num; // 현재 데이터 개수

    //생성자

    public IntArrayQue(int capacity) {
        //생성자는 객체의 필드의 초기화
        this.num = 0; //힙에 생성되는 영역이 아니라 직접 초기화
        this.capacity = capacity;
        try{
            que = new int[this.capacity];  //큐 배열을 생성
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }


    //기능(메소드)
    public class EmptyIntArrayQueException extends RuntimeException{
        public EmptyIntArrayQueException(){}
    }

    public class OverflowIntArrayQueException extends RuntimeException{
        public OverflowIntArrayQueException(){}
    }

    public int enque(int x) throws OverflowIntArrayQueException{
        if(this.num >= this.capacity) //큐가 가득 참
            throw new OverflowIntArrayQueException();
        que[num++] = x; //값을 할당 먼저 하고 num값 증가
        return x;
    }

    public int deque()throws EmptyIntArrayQueException{
        if(num <= 0) throw new OverflowIntArrayQueException();
        int x = que[0];
        for(int i = 0; i < num -1 ; i++)
            que[i] = que[i+1]; //옮겨줌
            num--;
            return x;
    }

    //peek(): 큐에서 데이터를 피크(맨앞 데이터를 들여다 본다)
    public int peek() throws EmptyIntArrayQueException{
        if(num <= 0) throw new EmptyIntArrayQueException();
        return que[num-1];
    }

    // 큐를 비웁니다
    public void clear(){
        num = 0;
    }

    //큐에서 x를 검색하여 발견하지 못하면 -1을 반환하는 indexOf() 기능 구현
    public int indexOf(int x){
        for(int i=0; i<num;i++){
            if(que[i] == x)
                return i;// 검색 성공 시 해당 인덱스 전달
        }
        return -1; // 검색 실패
    }
    //큐의 용량을 반환하는 capacity()
    public int capacity(){
        return this.capacity;
    }

    //큐가 비어있는지 확인 boolean isEmpty()
    public boolean isEmpty(){
        return num <= 0;
    }

    //큐안의 모든 데이터를 맨앞->맨끝 순서로 void dump()
    public void dump(){
        if(num <= 0) System.out.println("Empty");
        else{
            for(int data : que) System.out.print(data + " ");
            System.out.println();
        }
    }

    //큐에 쌓여 있는 데이터수를 반환 int size()
    public int size(){
        return num;
    }

    //큐가 가득 차있는가?
    public boolean isFull(){
        return num >= capacity;
    }

}
