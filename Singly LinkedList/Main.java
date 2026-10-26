import java.util.Scanner;
class Node
{
    int data;
    Node next;
    Node()
    {
        data=0;
        next=null;
    }
    Node(int data)
    {
        this.data=data;
        next=null;
    }
}
class LinkedList{
    Node head;
    int count;
    LinkedList()
    {
        head=null;
        count=0;
    }
    Scanner sc=new Scanner(System.in);
    void create(int n)
    {
        int value;
        for(int i=0;i<n;i++)
        {
            System.out.println("Enter value");
            value=sc.nextInt();
            Node nd=new Node(value);
            if(head==null)
            {
                head=nd;
            }
            else
            {
                Node t=head;
                while(t.next!=null)
                {
                    t=t.next;
                }
                t.next=nd;   
            }
            count++;
        }
    }
    void addbegin(int value){ 
    Node nd=new Node(value);
    if(head==null)
        {
            head=nd;
        }
    else
    {
        nd.next=head;
        head=nd;
    }
    count++;
    }
    void addLast(int value)
    {
        Node nd=new Node(value);
        if(head==null)
        {
               head=nd;
        }
        else{
            Node t=head;
            while(t.next!=null)
            {
                t=t.next;
            }
            t.next=nd;
        }
        count++;
    }
    void addBetween(int value,int pos)
    {
              if(pos>count||count<2)
              {
                System.out.println("Invalid position");
              }
              else{
                Node nd=new Node(value);
                Node t=head;
                for(int i=1;i<pos-1;i++)
                {
                    t=t.next;
                }
                nd.next=t.next;
                t.next=nd;
              }
              count++;
    }
    void search(int x)
    {
        if(head==null)
        {
            System.out.println("List is empty");
        }
        else
        {  Node t=head;
            boolean flag=false;int index=1;
            while(t!=null)
            {
                if(t.data==x)
                {
                       flag=true;
                       break;
                }
                t=t.next;
                index++;
            }
        if(flag==false)
            System.out.println("Not fount");
        else
            System.out.println("Found at position:"+index);
        }
    }   
    void deletefirst()
    {
        if(head==null)
        {
            System.out.println("List is already empty");
        }
        else
        {
            head=head.next;
            count--;
        }
    }
    void deleteLast()
    {
        if(head==null)
        {
            System.out.println("List is already empty");
        }
        else{
            Node t=head;
            while(t.next.next!=null)
            {
                t=t.next;
            }
            t.next=null;
            count--;
        }
    }
    void deleteBetween(int pos)
    {
        if(pos>count||pos<2)
        {
            System.out.println("Invalid position");
        }
        else
        {
            Node t=head;
            for(int i=1;i<pos-1;i++)
            {
                t=t.next;
            }
            t.next=t.next.next;
            count--;
        }
    }
    void deletebyValue(int value)
    {
        if(head==null)
        {
            System.out.println("list is already empty");
        }
        else
        {
            Node t=head,r=null;
            while(t!=null)
            {
                if(t.data==value)
                {
                        if(head.data==value)
                        {
                            head=head.next;
                            break;
                        }
                        else
                        {
                            r.next=t.next;
                            count--;
                            break;
                        }
                }
        else
                {
                    r=t;
                    t=t.next;
                }
                
                }
            }
        }
    void reverse()
    {
        
            Node t=head,curr=null,prev=null;
            while(t!=null)
            {
                prev=curr;
                curr=t;
                t=t.next;
                curr.next=prev;
            }
            head=curr;
        
    }
    Node recuReverse(Node t)
    {
        if(t==null||t.next==null)
            return t;
        Node newHead=recuReverse(t.next);
        t.next.next=t;
        t.next=null;
        return newHead;
        
    }
    void display()
    { Node t;
        if(head==null)
        {
            System.out.println("list is empyty");
        }
    t=head;
    System.out.println("----------------------------");
        while(t!=null)
        {
            System.out.println(t.data);
            t=t.next;
        }
    }
    
    
}
public class Main {
    public static void main(String[] args) {
        LinkedList l=new LinkedList();
        l.create(5);
        l.display();
        System.out.println("Add Begin");
        l.addbegin(3);
        l.display();
        System.out.println("Add Last");
        l.addLast(15);
        l.display();
        System.out.println("Add between");
        l.addBetween(11, 3);
        l.display();
        System.out.println("Searching");
        l.search(12);
        System.out.println("delete begin");
        l.deletefirst();
        l.display();
        System.out.println("delete last");
        l.deleteLast();
        l.display();
        System.out.println("delete between");
        l.deleteBetween(2);
        l.display();
        System.out.println("delete by value");
        l.deletebyValue(14);
        l.display();
        l.reverse();
        l.display();
        System.out.println("Reverse thorugh recursion");
        l.head=l.recuReverse(l.head);
        l.display();
        
    }
}