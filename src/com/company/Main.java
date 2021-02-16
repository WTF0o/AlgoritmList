package com.company;

public class Main {

    public static void main(String[] args) {
	MyList list = new MyList();
	list.add(1);
	list.add(2);
	list.add(3);
	list.printAll();

	System.out.println();

	//list.removeByValue(2);

//	list.printAll();
//
//	System.out.println();

//	list.shift(3, false);
//	list.printAll();
//	System.out.println();
	list.shift(3, true);
	list.printAll();


//	System.out.println(list.getByIndex(1));
//	System.out.println(list.length);
    }
}
