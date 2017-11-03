package org.accenture.buffer2;

public class BufferException extends RuntimeException{

  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  public BufferException(String message) {
    super(message);
    System.out.println("Error : " + message);
  }
}
