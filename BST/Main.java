public class Main {
    public static void main(String[] args) {
        BST b = new BST();
        for (int i : new int[]{50,70,60,20,90,10,40,100}) {
            b.insert(i);
        }
        b.traverse();
    }
}
