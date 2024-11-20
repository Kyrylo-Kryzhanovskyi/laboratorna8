package Task3;


public class ThirdTask {
    public static void main(String[] args) {
        MyStack2<Number> stN = new MyStack2<>();
        MyStack2<Integer> stI = new MyStack2<>();
        MyStack2<Double> stD = new MyStack2<>();

        for(int i = 0; i < 3; i++) {
            stI.push( i);
            stD.push((double) (i + 3));
        }
//        for(int i = 0; i < 3; i++) {
//            stI.push( new Integer( i ) );
//            stD.push( new Double( i + 3 ) );
//        }

        System.out.println( "Integer stack: " + stI );
        System.out.println( "Double stack: " + stD );

        stN.addAll(stI);
        stD.moveElementsTo( stN );

        System.out.println( "Number stack: " + stN );
    }

}

