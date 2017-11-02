package org.accenture.buffer2;

public class BufferException extends Exception{

  public BufferException(String message) {
    super(message);
    System.out.println("Error : " + message);
  }
}
