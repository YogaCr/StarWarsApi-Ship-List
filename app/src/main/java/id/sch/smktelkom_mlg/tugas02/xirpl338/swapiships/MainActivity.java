package id.sch.smktelkom_mlg.tugas02.xirpl338.swapiships;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    String url = "https://swapi.co/api/starships/?format=json";
    RecyclerView recyclerView;
    List<ShipClass> shipList;
    RecyclerView.Adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.rv_ships);
        recyclerView.setAdapter(adapter);
        shipList = new ArrayList<>();

        getVolley();
    }

    public void getVolley() {
        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                getJSON(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        RequestQueue queue = Volley.newRequestQueue(this);
        queue.add(request);
    }

    public void getJSON(String response) {
        try {
            JSONObject object = new JSONObject(response);

            JSONArray jArray = object.getJSONArray("results");
            for (int x = 0; x < jArray.length(); x++) {
                JSONObject jsonShip = jArray.getJSONObject(x);

                ShipClass ship = new ShipClass(jsonShip.getString("name"),
                        jsonShip.getString("model"),
                        jsonShip.getString("manufacturer"),
                        jsonShip.getString("starship_class"),
                        jsonShip.getString("passengers"));
                shipList.add(ship);

                adapter = new SwapiAdapter(shipList);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
                adapter.notifyDataSetChanged();
                recyclerView.setLayoutManager(linearLayoutManager);
                recyclerView.setAdapter(adapter);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
