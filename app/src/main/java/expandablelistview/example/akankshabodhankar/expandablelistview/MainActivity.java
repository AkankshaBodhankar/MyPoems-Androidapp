package expandablelistview.example.akankshabodhankar.expandablelistview;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends Activity {

    ExpandableListViewAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        expListView = (ExpandableListView) findViewById(R.id.explist);

        prepareListData();

        listAdapter = new ExpandableListViewAdapter(this, listDataHeader, listDataChild);
        expListView.setAdapter(listAdapter);

        expListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {

            @Override
            public boolean onGroupClick(ExpandableListView parent, View v,
                                        int groupPosition, long id) {
                Toast.makeText(getApplicationContext(),
                        "Poem Clicked " + listDataHeader.get(groupPosition),
                        Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }

        private void prepareListData() {

            listDataHeader = new ArrayList<String>();
            listDataChild = new HashMap<String, List<String>>();

            // Adding group data
            listDataHeader.add("I can");
            listDataHeader.add("In Tune With Mother Nature");
            listDataHeader.add("The Lantern Desire");

            // Adding child data
            List<String> iCan = new ArrayList<String>();
            iCan.add(getResources().getString(R.string.PoemICan));

            List<String> inTuneWithMotherNature = new ArrayList<String>();
            inTuneWithMotherNature.add(getResources().getString(R.string.InTuneWithMotherNature));


            List<String> lanternDesire = new ArrayList<String>();
            lanternDesire.add(getResources().getString(R.string.LanternDesire));


            listDataChild.put(listDataHeader.get(0), iCan);
            listDataChild.put(listDataHeader.get(1), inTuneWithMotherNature);
            listDataChild.put(listDataHeader.get(2), lanternDesire);




    }


}
