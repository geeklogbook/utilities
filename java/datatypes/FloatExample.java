package datatypes;

public class FloatExample {

    public static void main(String[] args) {
        float a = 10.25F;
        float b = 23.22F;

        Float aF = new Float(a);
        Float bF = new Float(b);

        System.out.println("af.compareTo(bF) : " + aF.compareTo(bF));

        System.out.println("doubleValue(bF) :" + aF.doubleValue());
        System.out.println("equals(Object)  :" + aF.equals(bF));
        System.out.println("af.floatValue   :" + aF.floatValue());
        System.out.println("bF.intValue     :" + bF.intValue());
        System.out.println("bF.isNan()      :" + bF.isNaN());
        System.out.println("bF.longValue    :" + bF.longValue());
        System.out.println("parseFloat      :" + Float.parseFloat("57.86"));

    }
}
