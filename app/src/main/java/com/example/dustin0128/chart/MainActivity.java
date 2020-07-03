package com.example.dustin0128.chart;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
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
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private LineChart mLineChart;
    private PieChart mPieChart;
    private BarChart mBarChart;
    private Random random;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mLineChart = findViewById(R.id.linechart);
        mPieChart = findViewById(R.id.piechart);
        mBarChart = findViewById(R.id.barchart);

        initLineChart();
        initDataPiechart();
        initBarChart();
    }

    private void initBarChart() {

        ArrayList<BarEntry> yVals = new ArrayList<>();  //Y轴方向第一组数组
        ArrayList<BarEntry> yVals2 = new ArrayList<>(); //Y轴方向第二组数组
        ArrayList<BarEntry> yVals3 = new ArrayList<>(); //Y轴方向第三组数组
        ArrayList<String> xVals = new ArrayList<>();    //X轴数据

        //添加數據
        for(int i=0;i < 12;i++){
            xVals.add((i+1)+"月");
            yVals.add(new BarEntry(random.nextInt(10000),i));
            yVals2.add(new BarEntry(random.nextInt(10000),i));
            yVals3.add(new BarEntry(random.nextInt(10000),i));
        }

        BarDataSet barDataSet = new BarDataSet(yVals,"小1支出");
        barDataSet.setColor(Color.RED); //設定第一組顏色

        BarDataSet barDataSet1 = new BarDataSet(yVals2,"小2支出");
        barDataSet1.setColor(Color.BLUE);   //設定第一組顏色

        BarDataSet barDataSet2 = new BarDataSet(yVals3,"小3支出");
        barDataSet2.setColor(Color.YELLOW); //設定第一組顏色

        ArrayList<IBarDataSet> threebardata = new ArrayList<>();
        threebardata.add(barDataSet);
        threebardata.add(barDataSet1);
        threebardata.add(barDataSet2);
//
//        BarData barData = new BarData(xVals,threebardata);
//        mBarChart.setData(barData);
//        mBarChart.getLegend().setPosition();

    }


    private void initDataPiechart() {

        List<PieEntry> pieEntries = new ArrayList<>();

            pieEntries.add(new PieEntry(11, ""));
            pieEntries.add(new PieEntry(2, ""));
            pieEntries.add(new PieEntry(3, ""));

        PieDataSet iPieDataSet = new PieDataSet(pieEntries, "pie label");

        iPieDataSet.setDrawValues(true);    //设置是否显示数据实体(百分比，true:以下属性才有意义)
        iPieDataSet.setValueTextColor(Color.BLUE);  //设置所有DataSet内数据实体（百分比）的文本颜色
        iPieDataSet.setValueTextSize(18f);          //设置所有DataSet内数据实体（百分比）的文本字体大小
        iPieDataSet.setValueFormatter(new PercentFormatter()); //设置百分比格式化器
        PieData pieData = new PieData(iPieDataSet);
        mPieChart.setData(pieData);
        initPieChart();

        iPieDataSet.setColors(Color.rgb(255, 203, 125), Color.rgb(125, 169, 214), Color.rgb(154, 165, 175));
    }

    public void initPieChart() {
        // 设置 pieChart 图表基本属性
        mPieChart.setUsePercentValues(true); //使用百分比显示
        mPieChart.getDescription().setEnabled(false);
        mPieChart.setRotationAngle(90);                   //设置pieChart图表起始角度
        mPieChart.setRotationEnabled(true);              //设置pieChart图表是否可以手动旋转
        mPieChart.setHighlightPerTapEnabled(true);       //设置piecahrt图表点击Item高亮是否可用
        //        mPieChart.animateY(1400, Easing.EasingOption.EaseInOutQuad);// 设置pieChart图表展示动画效果
        mPieChart.setTouchEnabled(true);

        // 设置 pieChart 内部圆环属性
        mPieChart.setDrawHoleEnabled(false);              //是否显示PieChart内部圆环(true:下面属性才有意义)
        mPieChart.setHoleRadius(70f);                    //设置PieChart内部圆的半径(这里设置28.0f)
        mPieChart.setTransparentCircleRadius(30f);       //设置PieChart内部透明圆的半径(这里设置31.0f)
        mPieChart.setTransparentCircleColor(Color.BLACK);//设置PieChart内部透明圆与内部圆间距(31f-28f)填充颜色
        mPieChart.setTransparentCircleAlpha(50);         //设置PieChart内部透明圆与内部圆间距(31f-28f)透明度[0~255]数值越小越透明
        mPieChart.setHoleColor(Color.WHITE);             //设置PieChart内部圆的颜色

//        mPieChart.setDrawCenterText(false);               //是否绘制PieChart内部中心文本（true：下面属性才有意义）
//        mPieChart.setCenterText("");                 //设置PieChart内部圆文字的内容
//        mPieChart.setCenterTextSize(22f);                //设置PieChart内部圆文字的大小
//        mPieChart.setCenterTextColor(Color.rgb(0, 0, 0));         //设置PieChart内部圆文字的颜色

        mPieChart.getLegend().setEnabled(false); //是否启用图列（true：下面属性才有意义）
//        mPieChart.getLegend().setFormSize(10);                    //设置图例的大小
//        mPieChart.getLegend().setFormToTextSpace(10f);            //设置每个图例实体中标签和形状之间的间距

    }

    private void initLineChart() {
        //設置數據
        List<Entry> entries = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            entries.add(new Entry(i, (float) (Math.random()) * 80));
        }
        //一個lineDataSet就是一條線
        LineDataSet lineDataSet = new LineDataSet(entries, "溫度");
        LineData data = new LineData(lineDataSet);
        mLineChart.setData(data);

        lineDataSet.setValueTextSize(14f);  //設定數據字體大小
        lineDataSet.setLineWidth(2f);   //設定line寬度
        lineDataSet.setColor(Color.RED); //設定line顏色
        lineDataSet.setDrawCircleHole(true);   //顯示圓的空心/實心
        lineDataSet.setCircleColor(Color.CYAN);   //圓的顏色
        lineDataSet.setCircleRadius(4f);  //顯示圓形大小

        mLineChart.moveViewToX(entries.size());

        mLineChart.fitScreen();
        mLineChart.setScaleEnabled(true);
        mLineChart.setScaleXEnabled(false);
//        mLineChart.setScaleX(1.5f);
//        mLineChart.getViewPortHandler().getMatrixTouch().postScale(3f, 1f);

        mLineChart.setDrawBorders(false);//顯示邊界
        mLineChart.setDragEnabled(true);  //可拖拽

        //圖例：Legend
        Legend legend = mLineChart.getLegend();
        legend.setForm(Legend.LegendForm.LINE);
        legend.setTextColor(Color.BLUE); //設置Legend 颜色
        legend.setTextSize(15f);
        legend.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
        legend.setHorizontalAlignment(Legend.LegendHorizontalAlignment.RIGHT);
        legend.setOrientation(Legend.LegendOrientation.HORIZONTAL);

        //得到X軸
        XAxis xAxis = mLineChart.getXAxis();
        mLineChart.setVisibleXRange(0, 5);//X軸顯示的座標範圍
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setTextSize(15f);
        xAxis.setGranularity(1f);//座標之間最小間隔
        //xAxis.setLabelCount(12, true);
        xAxis.setDrawGridLines(false);  //開啟關閉格線
        xAxis.setAxisLineColor(Color.BLACK);
        xAxis.setAxisLineWidth(2f);

        //得到Y軸
        YAxis leftYAxis = mLineChart.getAxisLeft();
        YAxis rightYAxis = mLineChart.getAxisRight();
        //設定Y軸
        leftYAxis.setAxisMinimum(0f);
        leftYAxis.setAxisMaximum(100f);
        rightYAxis.setAxisMinimum(0f);
        rightYAxis.setAxisMaximum(100f);
        leftYAxis.setGranularity(1f);
        leftYAxis.setTextSize(15f);
        rightYAxis.setEnabled(false); //右測Y軸不顯示
        leftYAxis.setAxisLineColor(Color.BLACK);
        leftYAxis.setAxisLineWidth(1f);

        //Description設置描述
        Description description = new Description();
        description.setEnabled(false);
        mLineChart.setDescription(description);
    }

}
