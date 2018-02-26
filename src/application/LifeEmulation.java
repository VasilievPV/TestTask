package application;

import java.time.LocalDateTime;
import java.util.Timer;

public class LifeEmulation
{
	private LocalDateTime ldt;
	private Timer timer;
	
	public LifeEmulation(Store store)
	{
		this.ldt = LocalDateTime.now();
		if (ldt.getHour()>=8 && ldt.getHour() <= 21)
		{
			store.open();
		}
		
	}
	
	
}
