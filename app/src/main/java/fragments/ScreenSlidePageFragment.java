package fragments;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import example.com.industrialautomation.R;

import java.util.ArrayList;




public class ScreenSlidePageFragment extends Fragment {
    BarChart barChart;
    LineChart lineChart;
    PieChart pieChart ;
    LineChart predLineChart ;
    View view;
    int factoryValue ;

    public static ScreenSlidePageFragment init (int value) {
        ScreenSlidePageFragment screenSlidePageFragment = new ScreenSlidePageFragment();
        Bundle args = new Bundle();
        args.putInt("val", value);
        screenSlidePageFragment.setArguments(args);
        return screenSlidePageFragment;

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getArguments()!= null){
           factoryValue = getArguments().getInt("val");
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
         view = (ViewGroup) inflater.inflate(R.layout.fragment_screen_slide_page, container, false);

        barChart = (BarChart)view.findViewById(R.id.costChart);
        lineChart = (LineChart)view.findViewById(R.id.lineChart);
        pieChart = (PieChart) view.findViewById(R.id.piChart);
        predLineChart = (LineChart)view.findViewById(R.id.predictAnalysisChart);

        barChartInit(factoryValue);
        lineChartInit(factoryValue);
        pieChartInit(factoryValue);
        predLineChartInit(factoryValue);

        return view;

    }

    private void pieChartInit(int factoryValue) {
        ArrayList<Entry> entries = new ArrayList<>();
        ArrayList<String> labels = new ArrayList<String>();



        if(factoryValue == 0){
            entries.add(new Entry(20, 0));
            entries.add(new Entry(40, 1));
            entries.add(new Entry(15, 2));
            entries.add(new Entry(25, 3));


            labels.add("Quarter 1");
            labels.add("Quarter 2");
            labels.add("Quarter 3");
            labels.add("Quarter 4");

        }else{
            entries.add(new Entry(10, 0));
            entries.add(new Entry(35, 1));
            entries.add(new Entry(30, 2));
            entries.add(new Entry(25, 3));


            labels.add("Quarter 1");
            labels.add("Quarter 2");
            labels.add("Quarter 3");
            labels.add("Quarter 4");
        }

        PieDataSet dataset = new PieDataSet(entries, "");
        PieData data = new PieData(labels, dataset);

        pieChart.setUsePercentValues(true);
        pieChart.setData(data);

        pieChart.setDescription(" Quarterly Revenue (%)");
        dataset.setColors(ColorTemplate.COLORFUL_COLORS);
        pieChart.animateY(5000);

    }

    private void lineChartInit(int factoryValue) {

        ArrayList<Entry> entries = new ArrayList<>();
        ArrayList<String> labels = new ArrayList<String>();
        if(factoryValue == 0){
            entries.add(new Entry(4f, 0));
            entries.add(new Entry(8f, 1));
            entries.add(new Entry(6f, 2));
            entries.add(new Entry(2f, 3));
            entries.add(new Entry(18f, 4));

            labels.add("1");
            labels.add("2");
            labels.add("3");
            labels.add("4");
            labels.add("5");

        }else {

            entries.add(new Entry(2f, 0));
            entries.add(new Entry(5f, 1));
            entries.add(new Entry(15f, 2));
            entries.add(new Entry(4f, 3));
            entries.add(new Entry(12f, 4));

            labels.add("1");
            labels.add("2");
            labels.add("3");
            labels.add("4");
            labels.add("5");

        }
        LineDataSet dataset = new LineDataSet(entries,"Days in a month");
        LineData data = new LineData(labels, dataset);
        lineChart.setData(data); // set the data and list of lables into chart
        lineChart.setDescription("Machine Downtime");
        dataset.setDrawFilled(true); // to fill the below area of line in graph
       // dataset.setColors(ColorTemplate.COLORFUL_COLORS); // to change the color scheme

    }


    private void predLineChartInit(int factoryValue) {
        ArrayList<Entry> entries = new ArrayList<>();
        ArrayList<String> labels = new ArrayList<String>();

        if(factoryValue == 0){
            entries.add(new Entry(5f, 0));
            entries.add(new Entry(15f, 1));
            entries.add(new Entry(10f, 2));
            entries.add(new Entry(12f, 3));
            entries.add(new Entry(30f, 4));

            labels.add("1");
            labels.add("2");
            labels.add("3");
            labels.add("4");
            labels.add("5");

        }else {
            entries.add(new Entry(25f, 0));
            entries.add(new Entry(10f, 1));
            entries.add(new Entry(15f, 2));
            entries.add(new Entry(10f, 3));
            entries.add(new Entry(30f, 4));

            labels.add("1");
            labels.add("2");
            labels.add("3");
            labels.add("4");
            labels.add("5");
        }



        LineDataSet dataset = new LineDataSet(entries,"Predictive Analysis");

        LineData data = new LineData(labels, dataset);
        predLineChart.setData(data); // set the data and list of lables into chart
        predLineChart.setDescription("Analysis");
        dataset.setDrawFilled(true); // to fill the below area of line in graph
        // dataset.setColors(ColorTemplate.COLORFUL_COLORS); // to change the color scheme

    }

    public void barChartInit(int factoryValue){

       // String[] xAxisLabels={"Assembly Line","Fan","Load","Cooling System"};
        BarData data = new BarData(getXAxisValues(), getDataSet(factoryValue));
        barChart.setData(data);
        barChart.setDescription("Overall Performance");
        barChart.animateXY(2000, 2000);
        barChart.invalidate();

    }

    private ArrayList<BarDataSet> getDataSet(int factoryValue) {
        ArrayList<BarDataSet> dataSets = null;

        ArrayList<BarEntry> valueSet1 = new ArrayList<>();
        if(factoryValue == 0){

            BarEntry v1e1 = new BarEntry(110.000f,0); // Assembly Line
            valueSet1.add(v1e1);
            BarEntry v1e2 = new BarEntry(40.000f, 1); // Fan
            valueSet1.add(v1e2);
            BarEntry v1e3 = new BarEntry(60.000f, 2); // Load
            valueSet1.add(v1e3);
            BarEntry v1e4 = new BarEntry(30.000f, 3); // Cooling System
            valueSet1.add(v1e4);
        }else {
            BarEntry v1e1 = new BarEntry(80.000f, 0); // Assembly Line
            valueSet1.add(v1e1);
            BarEntry v1e2 = new BarEntry(40.000f, 1); // Fan
            valueSet1.add(v1e2);
            BarEntry v1e3 = new BarEntry(30.000f, 2); // Load
            valueSet1.add(v1e3);
            BarEntry v1e4 = new BarEntry(50.000f, 3); // Cooling System
            valueSet1.add(v1e4);
        }



        BarDataSet barDataSet1 = new BarDataSet(valueSet1, "Values in kW");
        barDataSet1.setColors(ColorTemplate.COLORFUL_COLORS);

        dataSets = new ArrayList<>();
        dataSets.add(barDataSet1);

        return dataSets;
    }

    private ArrayList<String> getXAxisValues() {
        ArrayList<String> xAxis = new ArrayList<>();
        xAxis.add("Assembly Line");
        xAxis.add("Fan");
        xAxis.add("Load");
        xAxis.add("Cooling System");

        return xAxis;
    }



    }

