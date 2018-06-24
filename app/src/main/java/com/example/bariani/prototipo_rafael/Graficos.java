package com.example.bariani.prototipo_rafael;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

public class Graficos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graficos);

        int x = -2500, y = -2500;

        GraphView graph = (GraphView) findViewById(R.id.graph);
        LineGraphSeries<DataPoint> series = new LineGraphSeries<>(new DataPoint[] {
                new DataPoint(++x, ++y),

                new DataPoint(x+1000, y+1000),
        });


        graph.getViewport().setMaxY(2500);
        graph.getViewport().setMaxX(2500);
        graph.getViewport().setMinY(-2500);
        graph.getViewport().setMinX(-2500);



        graph.getViewport().setYAxisBoundsManual(true);
        graph.getViewport().setXAxisBoundsManual(true);
        graph.addSeries(series);

    }
}
