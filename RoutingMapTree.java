import java.util.*;

public class RoutingMapTree
{
    Node root;
    private int count;
    private int size;
    
    public RoutingMapTree() {
        root = new Node(new Exchange(0),null,null,null);
        size=getSize();
    }
    
    public RoutingMapTree(Node n){
        root =n;
        size=getSize();
    }
    
    
    public Node root(){
        return root;
    }
    
    public void incrCount(){
        count++;
    }
    
    public int getSize(){
        count =0;
        makeSize(root);
        return count;
    }
    
    public void makeSize(Node n){
        incrCount();
        int i;
        for(i=0;i<n.numChildren();i++){
            makeSize(n.Ichild(i));
        }
    }
    
    public boolean isEmpty() {return getSize()==0;}
    
    public boolean contains(Node n){
        Node temp=root;
        if(temp==n) return true;
        for(int i=0;i<n.numChildren();i++){
            if(temp.subTree(i).contains(n))
                return true;
        }
        return false;        
    }    
    
    public Node addChild(Node n, Exchange e) throws IllegalStateException
    {
        if(!contains(n)) throw new IllegalStateException("Node not found");
        Node temp =n.getLeft();
        Node child;
        if(temp==null){
            child=new Node(e,n,null,null);
            n.setLeft(child);
            return child;
        }
        while(temp != null){
            temp=temp.getRight();
        }
        child = new Node(e,temp,null,null);
        n.setRight(child);
        return child;
    }
    
    public void switchOn(MobilePhone a,Node b) throws IllegalArgumentException
    {
        if(!contains(b)) throw new IllegalArgumentException("Node not found");
        Node temp=b;
        a.switchOn();
        while(temp != root){
            MobilePhoneSet s= temp.residentSet();
            s.Insert(a);
            temp=temp.parent();
        }        
    }
    
    public void switchOff(MobilePhone a){
        a.switchOff();
        Node temp=a.location();
        while(temp != root){
             MobilePhoneSet s= temp.residentSet();
             s.Delete(a);
             temp=temp.parent();
        }
    }        
    
    public void performAction(String actionMessage) {
        System.out.println(actionMessage);
        StringTokenizer st = new StringTokenizer(actionMessage," ");
        String command;
        int i1,i2;
        command=st.nextToken();
        i1 = Integer.parseInt(st.nextToken());
        try{i2 = Integer.parseInt(st.nextToken());} catch(Exception e){}
        
        if (command.equals(addExchange))
            addExchange(i1,i2);
        if (command.equals(switchOnMobile))
            aswitchOnMobile(i1,i2);
        if (command.equals(switchOffMobile))
            switchOffMobile(i1);
        if (command.equals(queryNthChild))
            queryNthChild(i1,i2);
        if (command.equals(queryMobilePhoneSet))
            queryMobilePhoneSet(i1,i2);            
    }
    
    void addExchange(exIdentifier a,newExIdentifier b)
    {
        
    }
}












