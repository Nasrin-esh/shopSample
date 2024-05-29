package Exceptions;

class LackOfInventory extends InvalidShopping
{
    LackOfInventory()
    {
        super("this product is not available now");
    }
}
