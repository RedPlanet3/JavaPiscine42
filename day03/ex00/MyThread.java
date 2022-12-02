public class MyThread extends Thread{
    private String name;
    private int count;
    MyThread(String name, int count){
        this.name = name;
        this.count = count;
    }
    public void run()
    {
        for (int i = 0; i < this.count; i++)
        {
            System.out.println(this.name);
        }
    }

}
