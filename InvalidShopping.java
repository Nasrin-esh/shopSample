package Exceptions;

class InvalidShopping extends Exception
{
    InvalidShopping(String message)
    {
        super("Invalid Shopping : " + message);
    }
}
