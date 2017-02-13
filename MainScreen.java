package com.example.floatingtest;

import android.os.Bundle;
import android.os.StrictMode;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.Object;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class MainScreen extends AppCompatActivity {
    public final static String EXTRA_MESSAGE = "com.example.floatingtest.MESSAGE";
    public final static String EXTRA_2 = "com.example.floatingtest.MESSAGE";

    static Integer[] rxcuis = {313820, 1009145, 197321, 198520, 197636, 314119, 856987, 1603495, 1020477, 198603, 1011482, 998254, 997272};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        setContentView(R.layout.activity_main_screen);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



       // drugList.put("Acetaminophen", 313820);
        //drugList.put("Adderall", 1009145);
        //drugList.put("Alprazolam", 197321);
        //drugList.put("Caffeine", 198520);
        //drugList.put("Marijuana", 197636);
        //drugList.put("Nicotine", 314119);
        //drugList.put("Hydrocodone", 856987);
        //drugList.put("Fentanyl", 1603495);
        //drugList.put("Diphenhydramine", 1020477);
        //drugList.put("Dimenhydrinate", 198603);
        //drugList.put("Cetirizine", 1011482);
        //drugList.put("Psuedoephedrine", 998254);
        //drugList.put("Codeine", 997272);
    }

    public void printDrugInfo(View view) throws Exception
    {
        int rxcui = Integer.parseInt(view.getTag().toString());
        drug d = pullAllInfo(rxcui);
        //drugRelationship dr = pullRelationship(rxcui);
        MessageBox("Drug: " + d.getRXTermProperties().getDisplayName());
    }
    public void MessageBox(String message)
    {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    //public void sendMessage(View view){
      //  Intent intent = new Intent(this, DisplayMessageActivity.class);
        //EditText editText = (EditText) findViewById(R.id.edit_message);
        //String message = editText.getText().toString();
        //intent.putExtra(EXTRA_MESSAGE, message);
        //startActivity(intent);
    //}
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_screen, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public static String getHTML(String urlToRead) throws Exception {
        StringBuilder result = new StringBuilder();
        URL url = new URL(urlToRead);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String line;
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }
        rd.close();
        return result.toString();
    }

    public static Object parseJSON(String JSON, String type)
    {
        Gson g = new GsonBuilder().create();
        Object d = null;
        if(type.equalsIgnoreCase("allInfo"))
        {
            d = g.fromJson(JSON, drug.class);
        }
        else if(type.equalsIgnoreCase("drugRelation"))
        {
            d = g.fromJson(JSON, drugRelationship.class);
        }
        return d;
    }

    public drug pullAllInfo(int rxcui) throws Exception
    {
        return (drug)parseJSON(getHTML("https://rxnav.nlm.nih.gov/REST/RxTerms/rxcui/"+rxcui+"/allinfo.json"), "allInfo");

    }

    public drugRelationship pullRelationship(int rxcui) throws Exception
    {
        drugRelationship d = (drugRelationship)parseJSON(getHTML("https://rxnav.nlm.nih.gov/REST/interaction/interaction.json?rxcui="+rxcui+"&sources=DrugBank"), "drugRelation");
        return d;
    }

    public String[] severitySort(String[] array)
    {

        return null;
    }
    public void sendDrugMessage(View view)throws Exception {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        int rxcui = Integer.parseInt(view.getTag().toString());
        drug d = pullAllInfo(rxcui);
        drugRelationship dr = pullRelationship(rxcui);
        String display;
        interactionTypeGroup[] interactGroup = dr.getTypeGroup();
        interactionType[] interactType = interactGroup[0].getInteractionType();
        interactionPair[] p = interactType[0].getInteractionPair();
        String doseForm = d.getRXTermProperties().getRXNormDoseForm();

        display = "Drug: " + d.getRXTermProperties().getDisplayName() + "\nWay distributed: " + doseForm;
        display+="\nReacts with: ";
        for(int i=0; i<p.length; i++)
        {
            interactionConcept[] c = p[i].getinteractionConcept();
           display += "\n" + c[1].getSourceConceptItem().getName() + ": " +  p[i].getDescription();
        }
        intent.putExtra(EXTRA_MESSAGE, display);
        //intent.putExtra(EXTRA_2, brand);
        //intent.putExtra(EXTRA_MESSAGE, generic);
        startActivity(intent);
    }

}
