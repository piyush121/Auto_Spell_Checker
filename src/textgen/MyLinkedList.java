package textgen;

import java.util.AbstractList;


/** A class that implements a doubly linked list
 * 
 * @author UC San Diego Intermediate Programming MOOC team
 *
 * @param <E> The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E> {
	LLNode<E> head;
	LLNode<E> tail;
	int size;

	/** Create a new empty LinkedList */
	public MyLinkedList() {
		// TODO: Implement this method
		this.head=null;
		this.tail=null;
		this.size=0;
	}

	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 */
	public boolean add(E element ) 
	{
		// TODO: Implement this method
		LLNode<E> mynode=new LLNode<E>(element);
		if(this.size==0)
			{head=tail=mynode;
				this.size++;}
		else
		{	tail.next=mynode;
			mynode.prev=tail;
			mynode.next=null;
			tail=mynode;
			this.size++;
		}
			
		return false;
	}

	/** Get the element at position index 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	public E get(int index) throws IndexOutOfBoundsException 
	{
		// TODO: Implement this method.
		LLNode<E> ptr=head;
		if(index>size-1 | index<0)
			throw new IndexOutOfBoundsException("out of bound exception");
		int counter=0;
		while(ptr.next!=null)
		{
			if(counter<index)
				{
				counter++;
				ptr=ptr.next;
				}
			else
				return ptr.data;
		}
		return ptr.data;
	}

	/**
	 * Add an element to the list at the specified index
	 * @param The index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element ) 
	{
		// TODO: Implement this method
		LLNode<E> mynode=new LLNode<E>(element);
		int counter=0;
		LLNode<E> ptr=head;
		
	if(index < 0 | index > size)
			throw new IndexOutOfBoundsException();
	if(index==0)
		{	if(size==0)
			{
				head=tail=mynode;
				size++;
			}
		else {
			head.next=mynode.next;
			head.next.prev=mynode;
			head=mynode;
			this.size++;
		}
			
		}
	else if(index==size-1)
	{
		mynode.next=tail;
		mynode.prev=tail.prev;
		tail.prev.next=mynode;
		tail.prev=mynode;
		this.size++;	
	}
	else
		{
		while(ptr.next!=null)
		
		{
			if(counter<index)
				{
				counter++;
				ptr=ptr.next;
				}
			else break;
		}
			mynode.next=ptr;
			mynode.prev=ptr.prev;
			ptr.prev.next=mynode;
			ptr.prev=mynode;
			size++;
		}
	}


	/** Return the size of the list */
	public int size() 
	{
		// TODO: Implement this method
		return this.size;
	}

	/** Remove a node at the specified index and return its data element.
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
	 * 
	 */
	public E remove(int index) 
	{
		// TODO: Implement this method
		LLNode<E> ptr=head;
		int counter=0;
		if(index<0 | index >= size)
			throw new IndexOutOfBoundsException();
		else
			while(ptr.next!=null)
			{
				if(counter<index)
					{
					counter++;
					ptr=ptr.next;
					}
				else break;
			}
		E old=ptr.data;
		if(index==0)
		{	if(size==1)
				{
					head=tail=null;
					size--;
				}
		else
			{
			head=head.next;
			ptr.next=null;
			size--;
			}
			
		}
		else if(index==size-1)
		{
			tail=tail.prev;
			tail.next=null;
			size--;
		}
		else
		{
		ptr.prev.next=ptr.next;
		ptr.next.prev=ptr.prev;
		ptr.next=ptr.prev=null;
		size--;
		}
			
		return old;
	}

	/**
	 * Set an index position in the list to a new element
	 * @param index The index of the element to change
	 * @param element The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	public E set(int index, E element) 
	{
		// TODO: Implement this method
		LLNode<E> ptr=head;
		int counter=0;
		if(index<0 | index >= size)
			throw new IndexOutOfBoundsException();
		if(element==null)
			throw new NullPointerException();
		else
			while(ptr.next!=null)
			{
				if(counter<index)
					{
					counter++;
					ptr=ptr.next;
					}
				else break;
			}
		E old=ptr.data;
		ptr.data=element;
			
		return old;
	}
	
	public static void main(String[] args)
	{
		MyLinkedList<String> shortList;
		shortList = new MyLinkedList<String>();
		shortList.add(0,"A");
		System.out.println(shortList.remove(0));
		shortList.add(0,"B");
		
		//shortList.add("C");
		
		
		LLNode<String> ptr=shortList.head;
		while(ptr!= null)
		{System.out.println(ptr.data);
		ptr=ptr.next;}
	}
}

class LLNode<E> 
{
	LLNode<E> prev;
	LLNode<E> next;
	E data;

	// TODO: Add any other methods you think are useful here
	// E.g. you might want to add another constructor

	public LLNode(E e) 
	{
		this.data = e;
		this.prev = null;
		this.next = null;
	}
	
	

}
