package practisewiththis;

public class ThisKeywordCloneExample implements Cloneable {
    private Long id;
    private String name;
    private boolean isClone;

    @Override
    protected ThisKeywordCloneExample clone() throws CloneNotSupportedException{
        ThisKeywordCloneExample clonedObject = new ThisKeywordCloneExample();
        clonedObject.setId(this.getId());
        clonedObject.setName(this.getName());
        clonedObject.setClone(true);
        return clonedObject;
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public boolean isClone(){
        return isClone;
    }

    public void setClone(boolean isClone){
        this.isClone = isClone;
    }

    @Override
    public String toString(){
        return "[id: "+ id +" name: "+ name +" isClone: "+ isClone +"]";
    }

    public static void main(String[] args) {
        ThisKeywordCloneExample object1 = new ThisKeywordCloneExample();
        object1.setId(123L);
        object1.setName("foo");
        System.out.println("Original object: " + object1.toString());

        try {
            ThisKeywordCloneExample clonedObject = object1.clone();
            System.out.println("Cloned object = " + clonedObject.toString());
        } catch (CloneNotSupportedException e){
            e.printStackTrace();
        }
    }
}
