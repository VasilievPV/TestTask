package application;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class StoreEmulation
{
	private LocalDateTime ldt;
	private Timer timer;
	private Store store;
	private Random random;
	
	private TimerTask changeExCharge;
	private TimerTask closeStore;
	
	public StoreEmulation(Store store)
	{
		this.random = new Random();
		this.store = store;
		this.ldt = LocalDateTime.now();
		this.timer = new Timer("TimeThread");
		
	}
	
	public void startEmulation()
	{
		this.changeExCharge  = new TimerTask()
		{			
			@Override
			public void run()
			{
				if(ldt.getHour() < 18)
					store.setExtraCharge(8);
			}
		};
		
		this.closeStore = new TimerTask() {
			
			@Override
			public void run()
			{
				if(ldt.getHour() < 21)
					store.close();
			}
		};
		
		
		if (ldt.getHour() >= 8 && ldt.getHour() < 21)
		{
			store.open();
			setRules();
		}
		else 
		{
			System.out.println("This is not a time to open store");
		}
		
		
		
	}
	
	private void setRules()
	{
		if(ldt.getDayOfWeek()==DayOfWeek.SATURDAY || ldt.getDayOfWeek() == DayOfWeek.SUNDAY)
		{
			this.store.setExtraCharge(15);
		}
		else
			this.store.setExtraCharge(10);
		
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.HOUR_OF_DAY, 18);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		Date time18 = calendar.getTime();
		timer.schedule(this.changeExCharge, time18);
		
		calendar.set(Calendar.HOUR_OF_DAY, 21);
		Date time21 = calendar.getTime();
		timer.schedule(closeStore, time21);
		
		
	}
}
