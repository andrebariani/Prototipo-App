package com.example.bariani.prototipo_rafael;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.bariani.prototipo_rafael.modelo.Parametros;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import java.util.ArrayList;
import java.util.List;

public class GraficosMP extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graficos_mp);

        Intent intent = getIntent();
        Parametros parametros = (Parametros) intent.getSerializableExtra("parametros");

        LineChart lineChart = (LineChart) findViewById(R.id.chart);// Activity

        List <Entry> sinEntries = new ArrayList<>(); // List to store data-points of sine curve
        List <Entry> cosEntries = new ArrayList<>(); // List to store data-points of cosine curve
        List <Entry> cosEntries2 = new ArrayList<>();
        List <Entry> cosEntries3 = new ArrayList<>();
        List <Entry> cosEntries4 = new ArrayList<>();
        List <Entry> cosEntries5 = new ArrayList<>();
        List <Entry> cosEntries6 = new ArrayList<>();
        List <Entry> cosEntries7 = new ArrayList<>();

        // Obtaining data points by using Math.sin and Math.cos functions
        for( float i = -500; i < 1000f; i += 50f ) {
            sinEntries.add(new Entry(i,parametros.getPam1() + (float)Math.sin(i)));
            cosEntries.add(new Entry(i,(float)Math.cos(i)));
            cosEntries2.add(new Entry(i,parametros.getPam2() + (float)Math.cos(i)));
            cosEntries3.add(new Entry(parametros.getPam3(),1f + (float)Math.cos(i)));
            cosEntries4.add(new Entry(i,1.5f + (float)Math.cos(i)));
            cosEntries5.add(new Entry(i,2 + (float)Math.cos(i)));
            cosEntries6.add(new Entry(i,2.5f + (float)Math.cos(i)));
            cosEntries7.add(new Entry(i,3 +(float)Math.cos(i)));
        }

        List<ILineDataSet> dataSets = new ArrayList<>(); // for adding multiple plots

        LineDataSet sinSet = new LineDataSet(sinEntries,"corrente de inrush");
        LineDataSet cosSet = new LineDataSet(cosEntries,"quinto");
        LineDataSet cosSet2 = new LineDataSet(cosEntries2,"offset");
        LineDataSet cosSet3 = new LineDataSet(cosEntries3,"fundamental");
        LineDataSet cosSet4 = new LineDataSet(cosEntries4,"segundo");
        LineDataSet cosSet5 = new LineDataSet(cosEntries5,"terceiro");
        LineDataSet cosSet6 = new LineDataSet(cosEntries6,"quarto");
        LineDataSet cosSet7 = new LineDataSet(cosEntries7,"sexto");

        // Adding colors to different plots
        cosSet.setColor(android.graphics.Color.GREEN);
        cosSet2.setColor(android.graphics.Color.RED);
        cosSet3.setColor(Color.BLACK);
        cosSet4.setColor(Color.CYAN);
        cosSet5.setColor(Color.YELLOW);
        cosSet6.setColor(Color.RED);
        cosSet7.setColor(Color.MAGENTA);
        cosSet7.setLineWidth(5f);
        cosSet.setCircleColor(android.graphics.Color.GREEN);
        sinSet.setColor(Color.GRAY);
        sinSet.setLineWidth(1f);
        sinSet.setCircleColor(Color.RED);

        sinSet.setCircleRadius(0f);
        cosSet.setCircleRadius(0f);

        sinSet.setDrawCircles(false);
        cosSet.setDrawCircles(false);
        cosSet2.setDrawCircles(false);
        cosSet3.setDrawCircles(false);
        cosSet4.setDrawCircles(false);
        cosSet5.setDrawCircles(false);
        cosSet6.setDrawCircles(false);
        cosSet7.setDrawCircles(false);

        XAxis xAxis = lineChart.getXAxis();
        YAxis yAxisL = lineChart.getAxisLeft();
        YAxis yAxisR = lineChart.getAxisRight();

        xAxis.setAxisMaximum(1200f);
        xAxis.setAxisMinimum(-500f);

        yAxisL.setAxisMinimum(-5f);
        yAxisL.setAxisMaximum(5f);
        yAxisR.setAxisMinimum(-5f);
        yAxisR.setAxisMaximum(5f);

        // Adding each plot data to a List
        dataSets.add(sinSet);
        dataSets.add(cosSet);
        dataSets.add(cosSet2);
        dataSets.add(cosSet3);
        dataSets.add(cosSet4);
        dataSets.add(cosSet5);
        dataSets.add(cosSet6);
        dataSets.add(cosSet7);

        // Setting datapoints and invalidating chart to update with data points
        lineChart.setData(new LineData(dataSets));
        lineChart.invalidate();

    }
}
