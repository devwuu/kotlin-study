package javaToKotlin.javas;

public class House {

    private String address;
    private LivingRoom livingRoom;

    public House(String address){
        this.address = address;
        this.livingRoom = new LivingRoom(10);
    }

    public class LivingRoom{

        private double area;

        public LivingRoom(double area){
            this.area = area;
        }

        public String getAddress(){
            return House.this.address;
            // 외부 클래스를 직접적으로 참조해서 생기는 문제
            // 1. 내부 클래스는 숨겨진 외부 클래스 정보를 가지고 있어 참조를 해지하지 못하는 경우 메모리 누수가 생길 수 있고 이를 디버깅하기 어렵다
            // 2. 내부 클래스의 직렬화 형태가 명확하게 정의되지 않아 직렬화에 있어 제한이 있다
            // => 따라서 내부 클래스를 사용할 때는 static class로 정의하라 ( 바깥 클래스를 참조하지 못함)
        }

    }

}
