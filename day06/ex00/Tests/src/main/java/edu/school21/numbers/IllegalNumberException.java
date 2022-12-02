package edu.school21.numbers;

class IllegalNumberException extends RuntimeException {
    public IllegalNumberException() {
        super("Error: number can't be less than 2");
    }
}