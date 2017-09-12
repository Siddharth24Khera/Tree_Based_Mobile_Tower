public class Exchange
{
    private int id;
    public MobilePhoneSet mset;
    public Exchange(int num){
        id=num;
        mset = new MobilePhoneSet();
    }    
}

class Node
{ 
    private Exchange element;
    private Node above;
    private Node left;
    private Node right;
    
    public Node(Exchange e,Node abovee,Node leftc,Node rightc)
    {
        element = e;
        above = abovee;
        left = leftc;
        right = rightc;
    }
    
    public int numChildren(){
        int count=0;
        Node temp = getLeft();
        while(temp.getRight() != null){
            count++;
            temp = temp.getRight();
        }
        return count+1;
    }
    
    public Node parent() throws IllegalArgumentException
    {
        Node temp = this;
        if(temp.getAbove()== null) throw new IllegalArgumentException("Parent of root does'nt exist");
         while(temp.getAbove().getLeft() != temp){
           temp = temp.getAbove();           
        }
        return temp.getAbove();
    }
    
    public Node Ichild(int i){
        Node temp=getLeft();
        int j;
        for(j=1;j<i;j++){
            temp=temp.getRight();
        }
        return temp;        
    }
    
    public RoutingMapTree subTree(int i){
        Node root = Ichild(i);
        RoutingMapTree sub = new RoutingMapTree(root);
        return sub;
    } 
    
    public boolean isInternal() {return numChildren()>0;}
    public boolean isExternal() {return numChildren()==0;}
    public boolean isRoot(){
        try{parent();} catch(IllegalArgumentException e) {return true;}
        return false;
    }
    
    public MobilePhoneSet residentSet() { return element.mset; }
    public Node getAbove() { return above; }
    public Node getLeft() { return left; }
    public Node getRight() { return right; }
    
    public void setElement(Exchange e) { element = e; }
    public void setAbove(Node abovee) { above = abovee; }
    public void setLeft(Node leftC) { left = leftC; }
    public void setRight(Node rightC) { right = rightC;}
}