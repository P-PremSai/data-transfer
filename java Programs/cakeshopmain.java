abstract class shop
{
    double bill,price1,price2;
    String cake1,cake2;
    abstract void cal_bill();

    
}

class bill extends shop
{

    bill(String tcake1,double tprice1,String tcake2, double tprice2)
    {
        cake1 =tcake1;
        price1=tprice1;
        cake2 =tcake2;
        price2 =tprice2;
    }
    void cal_bill()
    {
        bill =price1+price2;
        System.out.println("Bill is :"+bill);
    }
}

class cakeshopmain
{
    public static void main(String args[])
    {
        bill b =new bill("Dark_froest",250.1,"Honey_cake",152.9);
        b.cal_bill();
    }
}