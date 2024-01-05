
import java.util.*;

public class Binomial_heap {
    private HashMap<Integer, Tree> trees;
    List<Integer>[] level;
    StringBuffer sb = new StringBuffer();

    public Binomial_heap(){
        trees = null;
    }

    public void Insert(int n){
        Tree temp = new Tree(n);
        Binomial_heap h = new Binomial_heap();
        h.addTree(temp);
        Union_Heap(h);
    }
    private void addTree(Tree t){
        trees = new HashMap<Integer, Tree>();
        trees.put(t.getDegree(), t);
    }
    public void Union_Heap(Binomial_heap temp){
        HashMap<Integer, Tree> t = temp.getTrees();
        Set<Integer> s = t.keySet();
        for(int i : s){
            put(i, t.get(i));
        }

    }
    private void put(int i, Tree tree){
        if(trees == null){
            trees = new HashMap<Integer, Tree>();
            trees.put(i, tree);
        }
        else if(!trees.containsKey(i)){
            trees.put(i, tree);
        }
        else{
                if(trees.get(i).getKey() < tree.getKey()){
                    Tree temp_tree = trees.get((i));
                    temp_tree.addTree(i, tree);
                    trees.remove(i);
                    put(i+1,temp_tree);
                }
                else{
                    Tree temp_tree = tree;
                    temp_tree.addTree(i, trees.get(i));
                    trees.remove(i);
                    put(i+1 ,temp_tree);
                }
        }
    }
    public int FindMin(){
        return trees.get(Minkey()).getKey();
    }
    private int Minkey(){
        int key = -1;
        if(trees==null){
            return key;
        }
        Set<Integer> set = trees.keySet();
        int x = 10000000;
        for(int i: set){
            if(trees.get(i).getKey()<x){
                x = trees.get(i).getKey();
                key = i;
            }
        }
        return key;
    }
    public int ExtractMin(){
        int x = Minkey();
        if(x == -1){
            return -1;
        }
        int p = trees.get(x).getKey();
        HashMap<Integer, Tree> temp = trees.get(x).getChildren();
        trees.remove(x);
        if(temp !=null) {
            Set<Integer> set = temp.keySet();
            for (int i : set) {
                Binomial_heap bh = new Binomial_heap();
                bh.addTree(temp.get(i));
                Union_Heap(bh);
            }
        }
        if(trees.isEmpty()){
            trees = null;
        }
        return p;
    }
    public String Print(){
        sb = new StringBuffer();
        if(trees == null){
            sb.append("Empty heap\n");
            return sb.toString();
        }
        Set<Integer> s = trees.keySet();
        sb.append("Printing Binomial Heap...\n");
        for(int i: s){
            sb.append("Binomial Tree, B"+i+"\n");
            level = new List[trees.get(i).getDegree() + 1];
            for(int j=0; j<trees.get(i).getDegree()+1; j++){
                level[j] = new ArrayList<Integer>();
            }
            printtree(0, trees.get(i));
            for(int j =0; j<trees.get(i).getDegree()+1; j++){
                sb.append("Level "+j+" : ");
                for(int k=level[j].size()-1; k>=0; k--){
                    sb.append(level[j].get(k)+" ");
                }
                sb.append("\n");
            }
        }
        return sb.toString();
    }
    public void printtree(int l, Tree t){
        level[l].add(t.getKey());
        if(t.getChildren()!=null) {
            Set<Integer> s = t.getChildren().keySet();
            l++;
            for (int i : s) {
                printtree(l, t.getChildren().get(i));
            }
        }
    }
    public HashMap<Integer, Tree> getTrees() {
        return trees;
    }
    public Binomial_heap Extract_heap(){
        Binomial_heap temp = new Binomial_heap();

        return temp;
    }

}
