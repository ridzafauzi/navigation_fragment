package com.example.budakgigibesi.ibeacon;

import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout dLayout;
	private RelativeLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
		layout = (RelativeLayout) findViewById(R.id.layout);
        setNavigationDrawer();
		setToolBar(); //for toolbar
    }
	

	//Set the toolbar as the action bar. call setSupportActionBar() and pass the tb object from your layout
	private void setToolBar() {
        Toolbar tb = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(tb);

        ActionBar ab = getSupportActionBar();
		ab.setDisplayHomeAsUpEnabled(true);
        ab.setHomeAsUpIndicator(R.drawable.ic_menu_white_24dp);        
    }
	

	//To handle when user clicks on an item
	private void setNavigationDrawer() {
		dLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		NavigationView navView = (NavigationView) findViewById(R.id.navigation);
		navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
			@Override
			public boolean onNavigationItemSelected(MenuItem menuItem) {

				Fragment frag = null;
				int itemId = menuItem.getItemId();

				if (itemId == R.id.fab) {
					frag = new Fragment1();
				}
				else if (itemId == R.id.star) {
					frag = new Fragment2();
				}

				if (frag != null) {
					FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

					transaction.replace(R.id.frame, frag);
					transaction.commit();
					dLayout.closeDrawers();
					return true;
				}

				return false;
			}
		});
	}
	
	
    @Override
	//simply add a listener to know when one of the menu item is pressed by user and then set the right fragment
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        String btnName = null;

        switch(itemId) {
            // Android home. opening the drawer when user clicks on the home icon
            case android.R.id.home: {
                dLayout.openDrawer(GravityCompat.START);
                return true;
            }
        }

        Snackbar.make(layout, "Button " + btnName, Snackbar.LENGTH_SHORT).show();
        return true;
		
    }
}
	

