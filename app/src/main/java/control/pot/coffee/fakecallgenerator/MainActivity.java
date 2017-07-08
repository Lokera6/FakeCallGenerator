package control.pot.coffee.fakecallgenerator;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity implements
        ContactsListFragment.ContactsListFragmentInterface {

    private FrameLayout fragmentContainer;
    private EditText searchEditText;

    private static final String STATE_EMPTY = "empty";
    private static final String STATE_LIST = "list";
    private static final String STATE_DISPLAY = "display";
    private String fragState = STATE_EMPTY;
    //0 = No frag
    //1 = list frag
    //2 = display frag


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        searchEditText = (EditText)findViewById(R.id.search_field);
    }

    //called when contact is pressed in ContactsListFragment
    public void onContactClicked(String lookupKey)  {
        //TODO code method
        /*
        replace fragments
        create contact
        load contact
         */
    }

    //Called when search button is pressed
    public void searchContacts(View view) {
        String searchString = searchEditText.getText().toString().trim();
        ContactsListFragment fragmentList = ContactsListFragment.newInstance(searchString);
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        switch (fragState) {
            case STATE_LIST:
            case STATE_DISPLAY:
                //fragmentTransaction.replace(R.id.result_layout, fragmentList);
                break;
            case STATE_EMPTY:
            default:
                //fragmentTransaction.add(R.id.result_layout, fragmentList);
                break;
        }
        fragmentTransaction.commit();
    }

    //Called when call button is pressed
    public void placeCall(View view) {
    }
}
