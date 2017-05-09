package com.example.timer;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

	private TextView time1,time2,time3;
	private Button time1S,time2S,time3S;
	
	private int time_1;
	private int time_2;
	private int time_3;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		time1 = (TextView)findViewById(R.id.time1);
		time2 = (TextView)findViewById(R.id.time2);
		time3 = (TextView)findViewById(R.id.time3);
		
		time1S = (Button)findViewById(R.id.time1S);
		time2S = (Button)findViewById(R.id.time2S);
		time3S = (Button)findViewById(R.id.time3S);
		
		time_1 = 0;
		time_2 = 0;
		time_3 = 0;
		
		//开启定时器：
//		 new Thread(new ThreadShow()).start(); 
//		 timetask = new ThreadShow();
//		 timetask.run();
		
		time1S.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				 new Thread(new ThreadShow1()).start();
				 
			}
		});
		
	time2S.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				 new Thread(new ThreadShow2()).start();

				 
			}
		});
		
	}
	
    // handler类接收数据  
    Handler handler = new Handler() {  
        public void handleMessage(Message msg) { 
        	
            if (msg.what == 1) {  
              
            	String s = "" + time_1; 
            	time1.setText(s);
            }  
            if (msg.what == 2) {  
            	
            	String s = "" + time_2; 
            	time2.setText(s);
            } 
            if (msg.what == 3) {  
                
            } 
        };  
    }; 
    
    
    // 线程类  
    class ThreadShow1 implements Runnable {  
  
        @Override  
        public void run() {  
            // TODO Auto-generated method stub  
            while (true) {  
                try {  
                    Thread.sleep(1000);  
                    time_1++;
                    Message msg = new Message();
                    msg.obj = time_1;
                    msg.what = 1;  
                    handler.sendMessage(msg);  
                } catch (Exception e) {  
                    // TODO Auto-generated catch block  
                    e.printStackTrace();   
                }  
            }  
        }  
    }  
    
    // 线程类  
    class ThreadShow2 implements Runnable {  
  
        @Override  
        public void run() {  
            // TODO Auto-generated method stub  
            while (true) {  
                try {  
                    Thread.sleep(1000);  
                    time_2=time_2+2;
                    Message msg = new Message();
                    msg.obj = time_2;
                    msg.what = 2;  
                    handler.sendMessage(msg);  
                } catch (Exception e) {  
                    // TODO Auto-generated catch block  
                    e.printStackTrace();   
                }  
            }  
        }  
    }  
    
    

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
