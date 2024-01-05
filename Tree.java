import java.util.*;

public class Tree {
    private int key;
    private int degree;
    private HashMap<Integer, Tree> children;

    public Tree(int n){
        key = n;
        degree = 0;
        children = null;
    }
    public void addTree(int i, Tree temp){
        if(children == null){
            children = new HashMap<Integer, Tree>();
        }
        children.put(i, temp);
        degree++;
    }

    public int getKey() {
        return key;
    }

    public int getDegree() {
        return degree;
    }
    public void print(Tree t){
        System.out.println(t.getKey());
        if(t.getChildren()!=null) {
            Set<Integer> s = t.getChildren().keySet();
            for (int i : s) {
                System.out.println(t.getChildren().get(i).getKey());
                print(t.getChildren().get(i));
            }
        }
    }
    public void print(){
        print(this);
    }

    public HashMap<Integer, Tree> getChildren() {
        return children;
    }
}
