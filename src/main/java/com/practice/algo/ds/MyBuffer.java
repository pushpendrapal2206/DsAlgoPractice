package com.practice.algo.ds;

/*


Implement a circular buffer that implement two functions
  - read
  - write
When I initialise the buffer, I should be able to specify the size of the buffer.

I can push strings to the buffer using the write function.

write("hello");
write("world");
read(); -> hello
read(); -> world
read(); -> Exception(nothing to read)
write("hello world");
read(); -> hello world

If the size of the input exceeds buffer size, throw a buffer overflow exception

10 -> ["h", "e", "l", "l", "o", "w", "o", "r", "l", "d"]
write("hi") -> Exception(buffer overflow)

*/


// package whatever; // don't place package name!

import java.util.ArrayDeque;
import java.util.Queue;


abstract class CircularBuffer {

    public char[] array;

    abstract String read();

    abstract boolean write(String toEnter);

}

public class MyBuffer extends CircularBuffer {

    private int start = -1;
    private int end = -1;
    private Queue<Integer> wordLength;

    public MyBuffer(int size) {
        this.array = new char[size];
        this.wordLength = new ArrayDeque<>();
    }


    public boolean write(String toEnter) {
        if ((this.start == 0 && this.end == this.array.length - 1) ||
                this.end == this.start - 1) {
            throw new RuntimeException("buffer overflow");
        }
        try {
            for (char c : toEnter.toCharArray()) {
                this.end++;
                if (this.end >= this.array.length && this.start != 0) {
                    this.end = 0;
                } else if (this.start == 0) {
                    throw new RuntimeException("buffer overflow");
                }
                array[this.end] = c;
            }
        } catch (ArrayIndexOutOfBoundsException ex) {
            throw new RuntimeException("buffer overflow");
        }
        this.wordLength.add(toEnter.length());
        return true;
    }

    public String read() {
        String output = "";
        if (wordLength.isEmpty()) {
            throw new RuntimeException("nothing to read");
        }
        int j = this.start + wordLength.poll();
        while (this.start < j) {
            this.start++;
            output = output + this.array[this.start];

        }
        return output;
    }


}

class MyCode {
    public static void main(String[] args) {
        MyBuffer myBuffer = new MyBuffer(10);
        myBuffer.write("hello");
        System.out.println(myBuffer.read());
        myBuffer.write("world");
        System.out.println(myBuffer.read());
        myBuffer.write("love");
        myBuffer.write("mybar");
        System.out.println(myBuffer.read());
        myBuffer.write("something");
        System.out.println(myBuffer.read());

    }
}

