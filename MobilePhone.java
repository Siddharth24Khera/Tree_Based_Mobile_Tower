
public class MobilePhone
{
    private int number;
    private boolean status;
    public MobilePhone(int num)
    {
        number=num;
        status=true;
    }
    public int number(){
        return number;
    }
    public boolean status(){
        return status;
    }
    public void switchOn(){
        status = true;
    }
    public void switchOff(){
        status = false;
    }
    public Node location() throws IllegalArgumentException
    {
        if(!this.status)
            throw new IllegalArgumentException("Mobile is switched off");
        // write something here
        /* Traverse the tree from root to down searching for it,return the leaf node of it */
            return null;
    }   
}
