import java.util.*;

public class MySet<E>
{
    public LinkedList <E> ll;
    private int size;
    
    public MySet()
    {
        ll = new LinkedList<E>();
        size=0;
    }
    
    public boolean IsEmpty()
    {
        return size==0;
    }
    
    public boolean IsMember(E o)
    {
        int t = ll.indexOf(o);
        if(t==-1)
            return false;
        return true;
    }
   
    public void Insert(E o)
    {
        if(!IsMember(o)){
            ll.addFirst(o); 
            size++;
        }
    }
    
    public int getSize(){
        return size;
    }
    
    public void Delete(E o) throws IllegalArgumentException
    {
        int t = ll.indexOf(o);
        if(t==-1)
            throw new IllegalArgumentException("Object not present");        
        ll.remove(t);
        size--;
    }
    
    public MySet<E> Intersection(MySet<E> a)
    {
        Iterator<E> x = ll.listIterator(0);
        E temp;
        MySet<E> inter = new MySet<E>();
        while(x.hasNext()){
            temp=x.next();
            if(a.IsMember(temp)){
                inter.Insert(temp);
            }              
        }  
        return inter;        
    }   
    
    public MySet<E> Union(MySet<E> a)
    {
        Iterator<E> x = ll.listIterator(0);
        E temp;
        MySet<E> union = new MySet<E>();
        while(x.hasNext()){
            temp=x.next();
            union.Insert(temp);                
        }       
        Iterator<E> y = a.ll.listIterator(0);
        while(y.hasNext()){
            temp=y.next();
            if(!union.IsMember(temp))
                union.Insert(temp);
        }  
        return union;
    }   
}
