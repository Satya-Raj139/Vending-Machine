public class Item
{
    private String name;
    private double price;
    private int stock;

    public Item(String name,double price,int stock)
    {
        this.name=name;
        this.price=price;
        this.stock=stock;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public boolean isOutofStock()
    {
        return stock <=0;
    }

    public void dispense()
    {
        this.stock--;
    }

    public String toString()
    {
        return name + " - $" + price + " (" + stock + " left)";
    }

}
