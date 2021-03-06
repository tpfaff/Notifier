package view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.example.notifier.NotificationFactory;
import com.example.notifier.NotificationItem;
import com.example.notifier.R;


import controller.ExpandableNotificationAdapter;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ListActivity;
import android.app.NotificationManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.app.AlarmManager;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.ListAdapter;
import android.widget.ListView;

public class MainActivity extends Activity {

	int mId;
	ArrayList<String> listDataHeader;
	HashMap<String, List<String>> listDataChild;
	int numberOfItems=0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		final ExpandableListView v=(ExpandableListView)this.findViewById(R.id.list);
		ViewTreeObserver vto        =   v.getViewTreeObserver(); 
	    vto.addOnGlobalLayoutListener(new OnGlobalLayoutListener() { 
	    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
		@Override 
	    public void onGlobalLayout() { 
	        
	    	//fillChildViewsWithSharedPrefs(v);
	        v.getViewTreeObserver().removeOnGlobalLayoutListener(this); 
	    } 
	}); 
		prepareListData();
		ExpandableNotificationAdapter adapter=new ExpandableNotificationAdapter(this,listDataHeader,listDataChild);
		v.setAdapter(adapter);
		
		mId=1;
		triggerNotification(null);
	}
	
	private void fillChildViewsWithSharedPrefs(View convertView) {
		EditText headerEdit=(EditText)convertView.findViewById(R.id.edit_header_text);
		EditText subtextEdit=(EditText)convertView.findViewById(R.id.edit_subtext);
		if(headerEdit.getText()== null){ //if this field hasn't been filled yet, check if theres shared prefs,if theres not then put the default hint in 
			//if theres sharedprefs, set them here again
			//else
			headerEdit.setText("Change the header text here");
		}
		if(subtextEdit.getText()== null){ //if this field hasn't been filled yet, check if theres shared prefs,if theres not then put the default hint in 
			//if theres sharedprefs, set them here again
			//else
			subtextEdit.setText("Change the subtext here");
		}
		
	}
	private void triggerNotification(String s) {
		NotificationCompat.Builder mBuilder=new NotificationCompat.Builder(this)
		.setSmallIcon(R.drawable.ic_launcher).setContentTitle("Toke up").setContentText("420");
		NotificationManager mNotificationManager=(NotificationManager) getSystemService(this.NOTIFICATION_SERVICE);
		mNotificationManager.notify(mId,mBuilder.build());
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.action_bar_layout, menu);
		return true;
	}
	private void prepareListData() {
		
		NotificationItem n1 =NotificationFactory.newNotification("Sample Notification 1",
				"Take medicine", null);
		NotificationItem n2 = NotificationFactory.newNotification("Sample Notification 2",
				"Pizza is done", null);
        listDataHeader = new ArrayList<String>();
       listDataChild = new HashMap<String, List<String>>();
 
        // Adding child data
        listDataHeader.add("Sample Notification 1");
        listDataHeader.add("Sample Notification 2");
 
        // Adding child data
        List<String> top250 = new ArrayList<String>();
        top250.add("Option");

        List<String> nowShowing = new ArrayList<String>();
      nowShowing.add("Option");

        listDataChild.put(n1.getHeaderText(), top250); // Header, Child data
        listDataChild.put(n2.getHeaderText(), nowShowing);
    }
	
	public void addNotificationToView(View v)
	{
		//to add an item I'm going to need to make a new adapter with the new item and reinit the expandable list view
		final ExpandableListView elv =(ExpandableListView)this.findViewById(R.id.list);	
		
		
		numberOfItems++;
	}
}
