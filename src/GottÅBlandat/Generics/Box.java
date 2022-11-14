package GottÅBlandat.Generics;

public class Box<T> {
    private T content1;
    public T getContent(){
        return content1;
    }
    public void setContent(T content){
        this.content1 = content;
    }
    public static void main(String[] args) {
        Box <String> stringBox = new Box<>();
        stringBox.setContent("StringBox");

        Box <Integer> integerBox = new Box<>();
        integerBox.setContent(123);

        Box<Box<Integer>> metaBox = new Box<>();
        metaBox.setContent(integerBox);

        System.out.println(stringBox.getContent());
        System.out.println(integerBox.getContent());
        System.out.println(metaBox.getContent().getContent());
    }
}
