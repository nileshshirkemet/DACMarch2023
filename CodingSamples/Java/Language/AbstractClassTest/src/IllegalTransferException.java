package banking;

//exception whose class extends java.lang.RuntimeException is unchecked
//at compile time and as such a method in which it occurs need not report it
public class IllegalTransferException extends RuntimeException {}

