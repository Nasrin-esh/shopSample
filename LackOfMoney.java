package Exceptions;

class LackOfMoney extends InvalidShopping
{
    LackOfMoney()
    {
        super("your money is not enough to buy this product");
    }
}
