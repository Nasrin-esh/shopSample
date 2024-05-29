package Exceptions;

class InvalidInput extends Exception
{
    InvalidInput(String message)
    {
        super("Invalid Input : " + message);
    }
}
