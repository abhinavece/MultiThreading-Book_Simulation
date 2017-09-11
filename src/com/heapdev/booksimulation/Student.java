package com.heapdev.booksimulation;

import java.util.Random;

public class Student implements Runnable {

	private int id;
	private String name;
	private int roll;
	private Book[] books;

	public Student(int id, String name, int roll, Book[] books) {
		this.id = id;
		this.name = name;
		this.roll = roll;
		this.books = books;
	}

	@Override
	public void run() {

		Random random = new Random();

		while (true) {

			int bookID = random.nextInt(Constants.NUMBER_OF_BOOKS);

			try {
				books[bookID].read(this);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public String toString() {
		return "Student " + id;
	}

}
