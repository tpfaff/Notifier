package view;

import java.util.ArrayList;

import com.example.notifier.R;
import android.app.Activity;
import android.app.ListActivity;
import android.app.NotificationManager;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.app.AlarmManager;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ExpandableListView;
import android.widget.ListAdapter;
import android.widget.ListView;

public class MainActivity extends Activity {

	int mId;
	ArrayList<String> list=new ArrayList<String>();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		list.add("Notificiation 1");
		list.add("Notificiation 2");
		setContentView(R.layout.activity_main);
		ExpandableListView v=(ExpandableListView)this.findViewById(R.id.list);
		ExpandableListAdapter<> adapter=new ExpandableListAdapter<>();
		ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,list);
		v.setAdapter(adapter);
		mId=1;
		triggerNotification(null);
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

}
