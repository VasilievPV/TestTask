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
	private TimerTask buyersComing;
	private TimerTask purchaseOnStoreClosing;
	
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
		
		this.buyersComing = new TimerTask() {
			
			@Override
			public void run() 
			{
				store.cellProducts();
			}
		};
		
		this.purchaseOnStoreClosing = new TimerTask() {
			
			@Override
			public void run()
			{
				for(Drink d : store.getProductRange().values())
				{
					if(d.getAmount() < 10)
						d.addAmount(150);
				}
			}
		};
		
		if (ldt.getHour() >= 8 && ldt.getHour() < 21)
		{
			store.open();
			setRules();
		}
		else 
		{
			this.store.printReport("This is not a time to open store");
		}
		
		
		
	}
	
	private void setRules()
	{
		//set extra charge depending on day of week
		if(this.ldt.getDayOfWeek()==DayOfWeek.SATURDAY || this.ldt.getDayOfWeek() == DayOfWeek.SUNDAY)
		{
			this.store.setExtraCharge(15);
		}
		else
			this.store.setExtraCharge(10);
		
		//Change extra charge after 18 pm
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.HOUR_OF_DAY, 18);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		Date time18 = calendar.getTime();
		this.timer.schedule(this.changeExCharge, time18);
		
		//Close store at the end of a day
		calendar.set(Calendar.HOUR_OF_DAY, 21);
		Date time21 = calendar.getTime();
		this.timer.schedule(closeStore, time21);
		this.timer.schedule(purchaseOnStoreClosing, time21);
		
		//schedule visits of buyers
		int buyersCount = 20 - this.ldt.getHour();
		if(buyersCount > 0)
		{
			Date[] visitDates = new Date[buyersCount];
			for(int i = 0; i < buyersCount; i ++)
			{
				calendar.set(Calendar.HOUR_OF_DAY, ldt.getHour() + 1 + i);
				visitDates[i] = calendar.getTime();
				this.timer.schedule(this.buyersComing, visitDates[i]);
			}
		}
		
		
	}

}
