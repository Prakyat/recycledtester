package sapphire.recycledtester;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<CityEvent> list;
    String taskName = "";

    String response = "[\n" +
            "  [\n" +
            "      {\n" +
            "        \"taskname\" : \"type on keyboard\",\n" +
            "        \"projectname\" : \"mind tree\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"taskname\" : \"jump\",\n" +
            "        \"projectname\" : \"mind tree\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"taskname\" : \"eat food\",\n" +
            "        \"projectname\" : \"mind tree\"\n" +
            "      }\n" +
            "  ],\n" +
            "  [\n" +
            "      {\n" +
            "        \"taskname\" : \"run and jump\",\n" +
            "        \"projectname\" : \"infosys\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"taskname\" : \"go to gym\",\n" +
            "        \"projectname\" : \"infosys\"\n" +
            "      }\n" +
            "  ],\n" +
            "  [\n" +
            "    {\n" +
            "      \"taskname\" : \"program\",\n" +
            "        \"projectname\" : \"aol\"\n" +
            "    }\n" +
            "  ]\n" +
            "]";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
        list = new ArrayList<>();
        try {

            JSONArray jsonRootArray = new JSONArray(response);
            for(int j=0;j<jsonRootArray.length();j++) {


                JSONArray root2 = jsonRootArray.getJSONArray(j);
                for (int i = 0; i < root2.length(); i++) {
                    CityEvent dm = new CityEvent();
                    JSONObject jobj1 = root2.getJSONObject(i);

                    if(taskName.equals(""))
                    {
                        taskName = jobj1.getString("projectname");

                        list.add(new CityEvent(taskName, null, CityEvent.CITY_TYPE));
                    }
                    else if(!taskName.equals(jobj1.getString("projectname")))
                    {
                        taskName = jobj1.getString("projectname");
                        list.add(new CityEvent(taskName, null, CityEvent.CITY_TYPE));

                    }
//                    else
//                    {
//                        list.add(new CityEvent(taskName, null, CityEvent.CITY_TYPE));
//                    }
                    ArrayList<String> singleItem = new ArrayList<>();


                    singleItem.add(jobj1.getString("taskname"));

                    list.add(new CityEvent(jobj1.getString("taskname"), "Droidcon in London", CityEvent.EVENT_TYPE));







                }


            }

            DifferentRowAdapter adapter = new DifferentRowAdapter(list);

            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, OrientationHelper.VERTICAL, false);
            RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
            mRecyclerView.setLayoutManager(linearLayoutManager);
            mRecyclerView.setItemAnimator(new DefaultItemAnimator());
            mRecyclerView.setAdapter(adapter);



        } catch (JSONException e) {
            e.printStackTrace();
        }



    }
}
