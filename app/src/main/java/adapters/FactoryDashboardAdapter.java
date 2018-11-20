package adapters;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;

import com.firebase.client.Firebase;

import java.util.ArrayList;
import java.util.List;

import Pojo.Industry;
import Presenter.IClearedDB;
import config.Endpoint;
import example.com.industrialautomation.R;
import models.FactoryDashboard;

/**
 * Created by kumardev on 2/3/2017.
 */

public class FactoryDashboardAdapter extends RecyclerView.Adapter<FactoryDashboardAdapter.FactoryViewHolder>  {

    private LinearLayout layoutOne,layoutTwo;

    public IClearedDB iClearedDB;

    ArrayList<Industry> industryList;

    Firebase ref,ref_switch;

    List<FactoryDashboard> factoryDashboards;
    public FactoryDashboardAdapter(List<FactoryDashboard> factoryDashboards) {
        this.factoryDashboards=factoryDashboards;
        //industryList=lstIndustry;
    }

//    public FactoryDashboardAdapter(ArrayList<Industry> lstIndustry) {
//        this.factoryDashboards=factoryDashboards;
//        industryList=lstIndustry;
//    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }


    @Override
    public FactoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.factory_card, parent, false);
        FactoryViewHolder factoryView = new FactoryViewHolder(v);
        Firebase.setAndroidContext(parent.getContext());
        ref=new Firebase(Endpoint.FIREBASE_BASE_URL);
        ref_switch=new Firebase(Endpoint.FIREBASE_SWITCH_URL);
        return factoryView;

    }

    @Override
    public void onBindViewHolder(final FactoryViewHolder holder, int position) {
        holder.factory.setText(factoryDashboards.get(position).getFactory());
        holder.power_consumption.setText(factoryDashboards.get(position).getPower_consumption());

//        holder.power_consumption.setText(industryList.get(0).getPower_consumption());

        holder.temp.setText(factoryDashboards.get(position).getTemp());

//        holder.temp.setText(industryList.get(0).getTemp().getValue());

        holder.humidity.setText(factoryDashboards.get(position).getHumidity());

//        holder.humidity.setText(industryList.get(0).getHumidity().getValue());

        layoutOne=holder.linearDetail;
        layoutTwo=holder.linearRealDevices;
//        if(industryList.get(0).getF1_bulbs()[0].getStatus().equals(true)){
//            holder.image1.setImageResource(R.drawable.light_bulb);
//        }else{
//            holder.image1.setImageResource(R.drawable.bulb1);
//        }
//
//        if(industryList.get(0).getAssembly_cooling_fan().getStatus().equals(true)){
//            holder.image2.setImageResource(R.drawable.assembly_line);
//        }else{
//            holder.image2.setImageResource(R.drawable.conveyor_dev);
//        }
//
//        if(industryList.get(0).getGeneric_fan().getStatus().equals(true)){
//            holder.image3.setImageResource(R.drawable.fan);
//        }else{e(R.drawable.fannn);
//        }
//
//        if(industryList.get(0).getAssembly_cooling_fan().getStatus().equals(true)){
//            holder.image4.setImageResource(R.drawable.cooling);
//        }else{
//            holder.image4.setImageResource(R.drawable.cooler);
//        }


        ArrayList<Integer> images=factoryDashboards.get(position).getImages();
        holder.image1.setImageResource(images.get(0));
        holder.image2.setImageResource(images.get(1));
        holder.image3.setImageResource(images.get(2));
        if(3<images.size()) {
            holder.image4.setImageResource(images.get(3));
        }

        ArrayList<String> imagesText=factoryDashboards.get(position).getImages_text();
        holder.textView1.setText(imagesText.get(0));
        holder.textView2.setText(imagesText.get(1));
        holder.textView3.setText(imagesText.get(2));
        holder.textView4.setText(imagesText.get(3));

//            holder.image3.setImageResourc

        holder.factorySwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(true){

                }else{

                }
            }
        });



    }



    @Override
    public int getItemCount() {
            return factoryDashboards.size();
    }

    public static class FactoryViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView status,power_consumption,temp,humidity,factory,textView1,textView2,textView3,textView4;
        ImageView image1,image2,image3,image4;
        LinearLayout linearDetail,linearRealDevices;
        Switch factorySwitch;

        FactoryViewHolder(View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.factoryCard);
            factory=(TextView)itemView.findViewById(R.id.cardFactory);
            factorySwitch=(Switch) itemView.findViewById(R.id.switch_factory);
            power_consumption = (TextView)itemView.findViewById(R.id.tvPowerConsumption);
            temp = (TextView)itemView.findViewById(R.id.tvTemp);
            humidity = (TextView)itemView.findViewById(R.id.tvHumidity);
            image1=(ImageView)itemView.findViewById(R.id.image1);
            image2=(ImageView)itemView.findViewById(R.id.image2);
            image3=(ImageView)itemView.findViewById(R.id.image3);
            image4=(ImageView)itemView.findViewById(R.id.image4);
            textView1=(TextView)itemView.findViewById(R.id.textView1);
            textView2=(TextView)itemView.findViewById(R.id.textView2);
            textView3=(TextView)itemView.findViewById(R.id.textView3);
            textView4=(TextView)itemView.findViewById(R.id.textView4);
        }
    }
}
