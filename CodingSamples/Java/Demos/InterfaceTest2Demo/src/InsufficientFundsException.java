package banking;

//an exception whose class extends java.lang.Exception is checked
//at compile time so that a method in which this exception occurs
//reports it either by catching it (using try block) or by
//declaring it to be thrown (using throws clause)
public class InsufficientFundsException extends Exception {}

