package fragments;


import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import Pojo.Assembly_cooling_fan;
import Pojo.Assembly_line;
import Pojo.Generic_fan;
import Pojo.Humidity;
import Pojo.Industry;
import Pojo.IndustryResponse;
import Pojo.Power_consumption;
import Pojo.Temp;
import Presenter.ConnectionTask;
import Presenter.IClearedDB;
import adapters.FactoryDashboardAdapter;
import config.Endpoint;
import example.com.industrialautomation.R;
import models.FactoryDashboard;


/**
 * A simple {@link Fragment} subclass.
 */
public class Dashboard extends Fragment implements IClearedDB {

    private RecyclerView recyclerView;
    private List<FactoryDashboard> factoryDashboards;
    LinearLayout linearDetail,linearRealDevices;
    RecyclerView.LayoutManager recyclerViewLayoutManager;

    private View v;

    IndustryResponse industryResponse;
    JSONObject jsonObject;
    String tempObj="";
    String powerObj="";
    String humidityObj="";
    String assemblyCoolingFanObj="";
    String assemblyLineObj="";
    String genericFanObj="";

    Temp temp;
    Power_consumption power_consumption;
    Humidity humidity;
    Assembly_cooling_fan assembly_cooling_fan;
    Assembly_line assembly_line;
    Generic_fan generic_fan;

    Gson gson=new Gson();

    ProgressDialog progressDialog;

    private OnAssemblySwitchChanged onAssemblySwitchChanged;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    public Dashboard() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v= inflater.inflate(R.layout.fragment_dashboard, container, false);
//        linearDetail= (LinearLayout) v.findViewById(R.id.linearDetails);
//        linearRealDevices= (LinearLayout) v.findViewById(R.id.linearRealDevices);
        recyclerView= (RecyclerView) v.findViewById(R.id.recycler_factory1);
        recyclerView.setHasFixedSize(true);
        recyclerViewLayoutManager=new GridLayoutManager(getActivity(),2);
        recyclerView.setLayoutManager(recyclerViewLayoutManager);
//        new ConnectionTask(this,this).execute();
//        initializeData();

//        FactoryDashboardAdapter factoryDashboardAdapter=new FactoryDashboardAdapter(factoryDashboards);
//        recyclerView.setAdapter(factoryDashboardAdapter);

        progressDialog=new ProgressDialog(getActivity(),ProgressDialog.STYLE_HORIZONTAL);
        sharedPreferences=getActivity().getPreferences(Context.MODE_PRIVATE);
        editor=sharedPreferences.edit();



        return v;
    }


        private void initializeData(){
            factoryDashboards = new ArrayList<>();

            ArrayList<Integer> factory1Images=new ArrayList<Integer>();
            ArrayList<String > factory1ImagesText=new ArrayList<>();




//            factory1Images.add(R.drawable.assembly_line);
//            factory1Images.add(R.drawable.fan);
//            factory1Images.add(R.drawable.light_bulb);
//            factory1Images.add(R.drawable.cooling);


            if(assembly_line.getStatus().equals("true")){
                factory1Images.add(R.drawable.assembly_line);
                editor.putBoolean("assembly_line",true);

            }else{
                factory1Images.add(R.drawable.conveyor_dev);
                editor.putBoolean("assembly_line",false);



            }

            editor.commit();

            if(generic_fan.getStatus().equals("true")){
                factory1Images.add(R.drawable.fan);
            }else{
                factory1Images.add(R.drawable.fannn_black);
            }

            factory1Images.add(R.drawable.wheel);

            if(assembly_cooling_fan.getStatus().equals("true")){
                factory1Images.add(R.drawable.cooling);
            }else{
                factory1Images.add(R.drawable.cooler_black);
            }



            factory1ImagesText.add("Assembly Line");
            factory1ImagesText.add("Fan");
            factory1ImagesText.add("Load");
            factory1ImagesText.add("Cooling System");

            ArrayList<Integer> factory2Images=new ArrayList<Integer>();
            ArrayList<String> factory2ImagesText=new ArrayList<>();

            factory2Images.add(R.drawable.cooling);
            factory2Images.add(R.drawable.alarm);
            factory2Images.add(R.drawable.light_bulb);
            factory2Images.add(R.drawable.assembly_line);

            factory2ImagesText.add("Cooling System");
            factory2ImagesText.add("Alarm");
            factory2ImagesText.add("Load");
            factory2ImagesText.add("Assembly Line");




//            factoryDashboards.add(new FactoryDashboard("Factory 1", "150", "22","23",factory1Images,factory1ImagesText));
            factoryDashboards.add(new FactoryDashboard("Factory 1", powerObj, temp.getValue(),humidity.getValue(),factory1Images,factory1ImagesText));
            factoryDashboards.add(new FactoryDashboard("Factory 2", "100", "22","23",factory2Images,factory2ImagesText));





        }


    public interface OnAssemblySwitchChanged {
        public void onAssemblySwitch(boolean status);
    }

    @Override
    public void onResume() {
        super.onResume();
        progressDialog.setMessage("Loading factories...");
        progressDialog.show();

        Firebase.setAndroidContext(getActivity());
        Firebase ref=new Firebase(Endpoint.FIREBASE_BASE_URL);

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String s=dataSnapshot.getValue().toString();

                try {
                    jsonObject=new JSONObject(s);
                } catch (JSONException e) {
                    e.printStackTrace();
                }


                try {
                    tempObj=jsonObject.getString("temp");
                    powerObj=jsonObject.getString("power_consumption");
                    humidityObj=jsonObject.getString("humidity");
                    assemblyCoolingFanObj=jsonObject.getString("assembly_cooling_fan");
                    assemblyLineObj=jsonObject.getString("assembly_line");
                    genericFanObj=jsonObject.getString("generic_fan");
                } catch (JSONException e) {
                    e.printStackTrace();
                }

               temp= gson.fromJson(tempObj,Temp.class);
//               power_consumption= gson.fromJson(powerObj,Power_consumption.class);
               humidity= gson.fromJson(humidityObj,Humidity.class);
               assembly_cooling_fan= gson.fromJson(assemblyCoolingFanObj,Assembly_cooling_fan.class);
               assembly_line= gson.fromJson(assemblyLineObj,Assembly_line.class);
               generic_fan= gson.fromJson(genericFanObj,Generic_fan.class);



                System.out.print("");
                updateUI();
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
    }

    private void updateUI() {

        if(progressDialog.isShowing())
            progressDialog.dismiss();
        initializeData();

        FactoryDashboardAdapter factoryDashboardAdapter=new FactoryDashboardAdapter(factoryDashboards);
        recyclerView.setAdapter(factoryDashboardAdapter);

    }

    @Override
    public void AutomatedData(ArrayList<Industry> lstIndustry) {
        if(lstIndustry !=null && lstIndustry.size() > 0){

            //initializeData();

            FactoryDashboardAdapter factoryDashboardAdapter=new FactoryDashboardAdapter(factoryDashboards);
//            FactoryDashboardAdapter factoryDashboardAdapter=new FactoryDashboardAdapter(lstIndustry);
            recyclerView.setAdapter(factoryDashboardAdapter);


        }
    }
}
