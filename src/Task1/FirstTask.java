package Task1;

public class FirstTask {
    public static void main(String[] args){
        TriObjects<Long> firstObj = new TriObjects<>(10L, 20L, 30L);
        TriObjects<Long> secondObj = new TriObjects<>(5L, 25L, 35L);

        System.out.println("Objects1 : " + firstObj);
        System.out.println("Objects2 : " + secondObj);

        int res = firstObj.compareTo(secondObj);
        System.out.println(res);
        if (res > 0) {
            System.out.println("Objects1 більше за Objects2");
        } else if (res < 0) {
            System.out.println("Objects1  менше за Objects2");
        } else {
            System.out.println("Objects1  дорівнює Objects2");
        }
    }

}
class TriObjects<T extends Comparable<T>> implements Comparable<TriObjects<T>> {
    private final T firstObject;
    private final T secondObject;
    private final T thirdObject;

    public TriObjects(T firstObject, T secondObject, T thirdObject) {
        this.firstObject = firstObject;
        this.secondObject = secondObject;
        this.thirdObject = thirdObject;
    }
    @Override
    public int compareTo(TriObjects<T> other) {
        // +1 = obj.compareTo(other.obj) --> obj  > other.obj
        //  0 = obj.compareTo(other.obj) --> obj == other.obj
        // -1 = obj.compareTo(other.obj) --> obj  < other.obj
        int flag1 = firstObject.compareTo(other.firstObject);
        System.out.println("flag1: " + flag1);
        int flag2 = secondObject.compareTo(other.secondObject);
        System.out.println("flag2: " + flag2);
        int flag3 = thirdObject.compareTo(other.thirdObject);
        System.out.println("flag3: " + flag3);
        int result = 0;
        float floatResult = (flag1 + flag2 + flag3) / 3F;
        System.out.println("floatResult: " + floatResult);
        if (floatResult < 0) {
            result = -1;
        }
        else if (floatResult > 0) {
            result = 1;
        }
        return result;
    }

    @Override
    public String toString() {
        return "{"+firstObject+", "+secondObject+", "+thirdObject+"}";

    }
}