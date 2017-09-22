package Problem1;

import org.junit.Test;

import junit.framework.Assert;

public class LinkedList {

	private Node head;

	private static class Node {
		public int value;
		public Node next;

		public Node(int value) {
			this.value = value;

		}
	}

	public void addToTheLast(Node node) {

		if (head == null) {
			head = node;
		} else {
			Node temp = head;
			while (temp.next != null)
				temp = temp.next;

			temp.next = node;
		}
	}

	public void printList(Node head) {
		Node temp = head;
		while (temp != null) {
			System.out.format("%d ", temp.value);
			temp = temp.next;
		}
		System.out.println();
	}

	public static Node reverseLinkedList(Node currentNode) {

		Node previousNode = null;
		Node nextNode;
		while (currentNode != null) {
			nextNode = currentNode.next;

			currentNode.next = previousNode;

			previousNode = currentNode;
			currentNode = nextNode;
		}
		return previousNode;
	}

	@SuppressWarnings("deprecation")
	@Test
	public void Test() {
		LinkedList list = new LinkedList();
		Node head = new Node(7);
		list.addToTheLast(head);
		list.addToTheLast(new Node(8));
		list.addToTheLast(new Node(9));
		list.addToTheLast(new Node(10));
		list.addToTheLast(new Node(11));

		list.printList(head);

		Node reverseHead = reverseLinkedList(head);
		System.out.println("After reversing");
		list.printList(reverseHead);
		LinkedList expectedReverse = new LinkedList();
		Node headExpected = new Node(11);
		expectedReverse.addToTheLast(headExpected);
		expectedReverse.addToTheLast(new Node(10));
		expectedReverse.addToTheLast(new Node(9));
		expectedReverse.addToTheLast(new Node(8));
		expectedReverse.addToTheLast(new Node(7));
		//list.printList(headExpected);
		assertThat(reverseHead, headExpected);

		// Assert.assertEquals(list.printList(headExpected),
		// list.printList(reverseHead));( , );
	}

	private void assertThat(Node reverseHead, Node headExpected) {
		// TODO Auto-generated method stub

	}

}