package com.example.appamst4;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;

import com.github.mikephil.charting.charts.Chart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.LegendEntry;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.DataSet;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.formatter.IValueFormatter;

import java.util.ArrayList;

public class grafica_lineal extends AppCompatActivity {
    private LineChart lineChart;
    private String [] dias=new String[]{"Lunes", "Martes", "Miercoles", "Jueves", "Viernes"};
    private int[]ventas=new int[]{0,7,5,11,14,10};
    private int[]colores=new int[]{Color.MAGENTA,Color.BLUE,Color.GREEN,Color.RED,Color.YELLOW};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grafica_lineal);

        lineChart=(LineChart) findViewById(R.id.lineChart);

        crearGrafica();
    }
    private Chart getSameChart(Chart chart, String descripcion, int textcolor, int backgroud, int animateY){
        chart.getDescription().setText(descripcion);
        chart.getDescription().setTextSize(15);
        chart.getDescription().setTextAlign(Paint.Align.RIGHT);
        chart.setBackgroundColor(backgroud);
        chart.animateY(animateY);
        legenda(chart);

        return chart;
    }

    private void legenda(Chart chart){
        Legend legenda = chart.getLegend();
        legenda.setForm(Legend.LegendForm.DEFAULT);
        legenda.setHorizontalAlignment(Legend.LegendHorizontalAlignment.CENTER);
        legenda.setTextSize(12);

        ArrayList<LegendEntry> entradas=new ArrayList<>();
        for(int i=0; i<dias.length; i++){
            LegendEntry entry=new LegendEntry();
            entry.formColor = colores[i];
            entry.label = dias[i];
            entradas.add(entry);
        }
        legenda.setCustom(entradas);
    }
    private ArrayList<Entry> getLineEntry(){
        ArrayList<Entry> entradas = new ArrayList<>();
        for(int i=0; i<ventas.length; i++)
            entradas.add(new Entry(i,ventas[i]));
        return entradas;
    }
    private void axisX(XAxis axis){
        axis.setPosition(XAxis.XAxisPosition.BOTTOM);
        axis.setEnabled(false);
    }
    private void axisLeft(YAxis axis){
        axis.setSpaceTop(16);
        axis.setAxisMinimum(0);
    }
    private void axisRigh(YAxis axis){
        axis.setSpaceTop(16);
        axis.setAxisMinimum(0);
    }
    public void crearGrafica(){
        lineChart = (LineChart) getSameChart(lineChart,"Ventas de Nutellas de la semana",Color.BLUE,Color.WHITE,3000);
        lineChart.setDrawMarkers(true);
        lineChart.setData(getLineData());
        lineChart.invalidate();

        axisX(lineChart.getXAxis());
        axisLeft(lineChart.getAxisLeft());
        axisRigh(lineChart.getAxisRight());
    }
    private DataSet getData(DataSet dataset){
        dataset.setColors(colores);
        dataset.setValueTextSize(Color.BLACK);
        dataset.setValueTextSize(15);
        return dataset;
    }
    private LineData getLineData(){
        LineDataSet lineDataSet=(LineDataSet) getData(new LineDataSet(getLineEntry(),""));
        lineDataSet.setLineWidth(10);
        lineDataSet.setCircleColor(Color.BLACK);
        lineDataSet.setCircleRadius(10);

        LineData lineData = new LineData(lineDataSet);
        return lineData;
    }
}