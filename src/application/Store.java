package application;

public class Store
{
	private boolean Is_Open;
	private double cashBox;
	
	public Store ()
	{
		this.Is_Open = false;
		this.cashBox = 0;
	}
	
	
	
	public void open ()
	{
		this.Is_Open = true;
	}
	
	public void close()
	{
		this.Is_Open = false;
	}

}
