package androidapp.tonycorp.traffic;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity { // เปิด

    //Explicit
    private ListView trafficListView; //ตัวแปร
    private Button aboutMeButton; //กด shift+ctrl+enter มันจะเติมเต็มให้

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Bind Widget ผูก widget
        bindWidget();

        //Button Controller
        buttonController();

        //Create ListView
        createListView();

    } //Main Method

    private void createListView() {

        //Class MyAdapter will wait input array to set into their listView
        String[] strTitle = new String[20];
        strTitle[0] = "ห้ามเลี้ยวซ้าย";
        strTitle[1] = "ห้ามเลี้ยวขวา";
        strTitle[2] = "ตรงไป";
        strTitle[3] = "เลี้ยวขวา";
        strTitle[4] = "เลี้ยวซ้าย";
        strTitle[5] = "ออก";
        strTitle[6] = "เข้า";
        strTitle[7] = "ออก";
        strTitle[8] = "หยุด";
        strTitle[9] = "จำกัดสูง 2.5ม.";
        strTitle[10] = "ทางแยก";
        strTitle[11] = "ห้ามกลับรถ";
        strTitle[12] = "ห้ามจอด";
        strTitle[13] = "สวนทาง";
        strTitle[14] = "ห้ามแซง";
        strTitle[15] = "เข้า";
        strTitle[16] = "หยุดตรวจ";
        strTitle[17] = "จำกัดเร็ว 50";
        strTitle[18] = "จำกัดกว้าง 2.5ม.";
        strTitle[19] = "จำกัดสูง 5ม.";

        int[] intIcon = {R.drawable.traffic_01, R.drawable.traffic_02,R.drawable.traffic_03,
                R.drawable.traffic_04,R.drawable.traffic_05,R.drawable.traffic_06,R.drawable.traffic_07,
                R.drawable.traffic_08,R.drawable.traffic_09,R.drawable.traffic_10,R.drawable.traffic_11,
                R.drawable.traffic_12,R.drawable.traffic_13,R.drawable.traffic_14,R.drawable.traffic_15,
                R.drawable.traffic_16,R.drawable.traffic_17,R.drawable.traffic_18,R.drawable.traffic_19
                ,R.drawable.traffic_20 };

        MyAdapter objMyAdapter = new MyAdapter(MainActivity.this, intIcon, strTitle);
        trafficListView.setAdapter(objMyAdapter);

        trafficListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            } // event
        });

    } //CreateListView


    protected void bindWidget() {

        trafficListView = (ListView) findViewById(R.id.livTraffic);
        aboutMeButton = (Button) findViewById(R.id.btnAboutMe); //ปิดวงเล็บ กด alt+enter เติม cast ข้างหน้า แล้วค่อยปิด ;

    }

    protected void buttonController() {
        aboutMeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //sound effect
                MediaPlayer buttonMediaPlayer = MediaPlayer.create(getBaseContext(), R.raw.effect_btn_shut);
                buttonMediaPlayer.start();

                //Intent to WebView
                Intent objIntent = new Intent(Intent.ACTION_VIEW);
                objIntent.setData(Uri.parse("https://youtu.be/s4ktJNKP3Kk"));
                startActivity(objIntent);
            }
        });
    }


} //ปิด //Main Class คลาสหลักนะ
