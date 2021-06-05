import java.util.*;

class node 
{
	int data;
	node next;
}

public class SinglyLinkedList 
{
	static Scanner sc = new Scanner(System.in);
	static node start = null;
	public static void main(String[] args) 
	{
		// SLL creation with single node
		node link = new node();
		System.out.print("Enter data into first node of the SLL: ");
		link.data = sc.nextInt();
		link.next = null;
		start = link;
		
		// SLL display
		display();
		// count no. of nodes in the SLL
		count();
		
		// insert a node in the beginning of the SLL
		insert_at_begin();
		// SLL display
		display();
		// count no. of nodes in the SLL
		count();
		
		// insert a node in the end of the SLL
		insert_at_end();
		// SLL display
		display();
		// count no. of nodes in the SLL
		count();
		
		// insert a node in the end of the SLL
		insert_any_pos();
		// SLL display
		display();
		// count no. of nodes in the SLL
		count();
		
		// delete the first node of the SLL
		del_at_begin();
		// SLL display
		display();
		// count no. of nodes in the SLL
		count();
		
		// delete the last node of the SLL
		del_at_end();
		// SLL display
		display();
		// count no. of nodes in the SLL
		count();
		
		// insert a node in the end of the SLL
		insert_any_pos();
		// SLL display
		display();
		// count no. of nodes in the SLL
		count();
		
		// delete node at any position
		del_at_any_pos();
		// SLL display
		display();
		// count no. of nodes in the SLL
		count();
		
		// insert a node in the beginning of the SLL
		insert_at_begin();
		// SLL display
		display();
		// count no. of nodes in the SLL
		count();
				
		// insert a node in the end of the SLL
		insert_at_end();
		// SLL display
		display();
		// count no. of nodes in the SLL
		count();
				
		// insert a node in the end of the SLL
		insert_any_pos();
		// SLL display
		display();
		// count no. of nodes in the SLL
		count();
		
		// reversing a SLL
		reverse_SLL();
		// SLL display
		display();
		
		// search a particular node/data/key from the SLL
		search_key_SLL();
		
		// sort the SLL in ascending order
		sortA_SLL();
		System.out.println("In Ascending order:");
		// SLL display
		display();
		
		// sort the SLL in descending order
		sortD_SLL();
		System.out.println("In Descending order:");
		// SLL display
		display();
	}
	static void insert_at_begin()
	{
		node temp = new node();
		System.out.print("Enter data into node to be inserted in the beginning: ");
		temp.data = sc.nextInt();
//		temp.next = null;
		temp.next = start;
		start = temp;
	}
	static void insert_at_end()
	{
		node temp = new node();
		System.out.print("Enter data into node to be inserted in the end: ");
		temp.data = sc.nextInt();
		temp.next = null;
		node trav = start;
		while(trav.next != null)
			trav = trav.next;
		trav.next = temp;
	}
	static void insert_any_pos()
	{
		node temp = new node();
		node trav = start;
		int i = 1;
		System.out.print("Enter the insertion location/postion: ");
		int pos = sc.nextInt();
		if(pos == 1)
			insert_at_begin();
		else {
			System.out.print("Enter data into node to be inserted at position " + pos + ": ");
			temp.data = sc.nextInt();
			while(i < pos-1)
			{
				i++;
				trav = trav.next;
			}
			temp.next = trav.next;
			trav.next = temp;
		}
	}
	static void display()
	{
		node dis = start;
		System.out.print("start -> ");
		while(dis != null)
		{
			System.out.print(dis.data + " -> ");
			dis = dis.next;
		}
		System.out.print("null");
		System.out.println();
	}
	static void count()
	{
		node dis = start;
		int count = 0;
		while(dis != null)
		{
			dis = dis.next;
			count++;
		}
		System.out.println("There ae total " + count + " nodes in the SLL.");
	}
	static void del_at_begin()
	{
		if(start == null)
			System.out.println("LL is empty");
		else {
//			node temp = start;
//			temp.next = start.next;
//			temp.next = null;
//			System.out.println("Deleted node is " + temp.data);
			System.out.println("Deleted node from beginning is " + start.data);
			start = start.next;
		}
	}
	static void del_at_end()
	{
		if(start == null)
			System.out.println("LL is empty");
		else {
			node trav = start, temp = null;
//			node temp = new node();
			while(trav.next != null) {
				temp = trav;
				trav = trav.next;
			}
			temp.next = null;
			System.out.println("Deleted node from end is " + trav.data);
		}
	}
	static void del_at_any_pos()
	{
		if(start == null)
			System.out.println("LL is empty");
		else {
//			node temp = new node();
			node trav = start, temp = null;
			int i = 1;
			System.out.print("Enter the deletion location/postion: ");
			int pos = sc.nextInt();
			if(pos == 1)
				del_at_begin();
			else {
				while(i < pos)
				{
					temp = trav;
					trav = trav.next;
					i++;
				}
				temp.next = trav.next;
				trav.next = null;
				System.out.println("Deleted node at position " + pos + " is " + trav.data);
			}
		}
	}
	static void search_key_SLL()
	{
		System.out.print("Enter the data/key to be searched from the SLL: ");
		int key = sc.nextInt();
		node trav = start;
		int flag = 0, count = 0;
		while(trav != null)
		{
			count++;
			if(trav.data == key) {
				flag = 1;
				break;
			}
			trav = trav.next;
		}
		if(flag == 1)
			System.out.println("Key found successfully at position " + count);
		else
			System.out.println("Key noy found in the SLL.");
	}
	static void sortA_SLL()
	{
		node temp1 = null, temp2 = null;
		for(temp1 = start; temp1.next != null; temp1 = temp1.next)
		{
			for(temp2 = temp1.next; temp2 != null; temp2 = temp2.next)
			{
				if(temp1.data > temp2.data)
				{
					int temp = temp1.data;
					temp1.data = temp2.data;
					temp2.data = temp;
				}
			}
		}
	}
	static void sortD_SLL()
	{
		node temp1 = null, temp2 = null;
		for(temp1 = start; temp1.next != null; temp1 = temp1.next)
		{
			for(temp2 = temp1.next; temp2 != null; temp2 = temp2.next)
			{
				if(temp1.data < temp2.data)
				{
					int temp = temp1.data;
					temp1.data = temp2.data;
					temp2.data = temp;
				}
			}
		}
	}
	static void reverse_SLL()
	{
		if(start == null)
			System.out.println("LL is empty");
		else if(start.next == null)
			System.out.println("Reverse is same as the original.");
		else {
			node trav = start, rev = null, temp = null;
			while(trav != null) {
				temp = trav.next;
				trav.next = rev;
				rev = trav;
				trav = temp;
			}
			start = rev;
		}
	}
}
