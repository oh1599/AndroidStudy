package com.example.mylocationlogger02;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.sqlite.SQLiteDatabase;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import java.util.*;


public class MainActivity extends AppCompatActivity {

    static int numSpinner=0;
    static int storeNum=0;

    Button view,reset,store;
    EditText editText;
    Intent intent;

    ArrayList<MyInfo> myInfo=new ArrayList<MyInfo>();

    GpsDB db = new GpsDB(this) ;
    SQLiteDatabase sqLiteDatabase ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Spinner s = (Spinner)findViewById(R.id.type);
        s.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                numSpinner = position ;//numSpinner=0 or 1 or 2 or 3
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });
        checkDangerousPermissions();
    }

    private class GPSListener implements LocationListener {
        @Override
        public void onLocationChanged(Location location) {
            //위치정보 리스트에 저장
            myInfo.get(storeNum).latitude=location.getLatitude();
            myInfo.get(storeNum).longitude=location.getLongitude();

            String msg = "Latitude: " + myInfo.get(storeNum).latitude + "\nLongitude: " + myInfo.get(storeNum).longitude;
            Log.i("GPSListener", msg);
        }
        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {
        }
        @Override
        public void onProviderEnabled(String provider) {
        }
        @Override
        public void onProviderDisabled(String provider) {
        }
    }
    private void startLocationService(){
        LocationManager manager = (LocationManager)getSystemService(Context.LOCATION_SERVICE);

        GPSListener gpsListener = new GPSListener();


        try{
            manager.requestLocationUpdates(
                    LocationManager.GPS_PROVIDER,
                    0, 0, gpsListener);
            manager.requestLocationUpdates(
                    LocationManager.NETWORK_PROVIDER,
                    0, 0, gpsListener);
        }
        catch (SecurityException ex){
            ex.printStackTrace();
        }

        Toast.makeText(getApplicationContext(), "위치 정보 저장", Toast.LENGTH_SHORT).show();
    }

    void resetData(View view) {
        sqLiteDatabase = db.getWritableDatabase() ;
        db.onUpgrade(sqLiteDatabase,1,2);
        db.close();
    }

    //저장 버튼 클릭 리스너
    public void storeData(View view)
    {
        store=(Button)findViewById(R.id.sub);
        editText=(EditText)findViewById(R.id.write);


        //Myinfo 클래스의 4가지 맴버에 값 저장.
        startLocationService() ;//latitude,longitude 변수에 값 저장. //numSpinner값은 static이므로 따로 저장할 필요없다.
        myInfo.get(storeNum).content=editText.getText().toString();  //content 변수에 값 저장.

        db.insert(myInfo.get(storeNum).latitude, myInfo.get(storeNum).longitude, numSpinner, myInfo.get(storeNum).content);
        editText.setText("");
        //저장횟수 증가
        storeNum++;
    }



    //지도보기 버튼
    void viewMap(View view) {
        intent = new Intent(getApplicationContext(), MapsActivity.class) ;
        startActivity(intent);
    }


    //권한 허용 함수
    private void checkDangerousPermissions() {
        String[] permissions = {
                android.Manifest.permission.ACCESS_FINE_LOCATION,
                android.Manifest.permission.ACCESS_COARSE_LOCATION,
                android.Manifest.permission.READ_EXTERNAL_STORAGE,
                android.Manifest.permission.WRITE_EXTERNAL_STORAGE
        };

        int permissionCheck = PackageManager.PERMISSION_GRANTED;
        for (int i = 0; i < permissions.length; i++) {
            permissionCheck = ContextCompat.checkSelfPermission(this, permissions[i]);
            if (permissionCheck == PackageManager.PERMISSION_DENIED) {
                break;
            }
        }

        if (permissionCheck == PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(this, "권한 있음", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "권한 없음", Toast.LENGTH_LONG).show();

            if (ActivityCompat.shouldShowRequestPermissionRationale(this, permissions[0])) {
                Toast.makeText(this, "권한 설명 필요함.", Toast.LENGTH_LONG).show();
            } else {
                ActivityCompat.requestPermissions(this, permissions, 1);
            }
        }
    }
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        if (requestCode == 1) {
            for (int i = 0; i < permissions.length; i++) {
                if (grantResults[i] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(this, permissions[i] + " 권한이 승인됨.", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(this, permissions[i] + " 권한이 승인되지 않음.", Toast.LENGTH_LONG).show();
                }
            }
        }
    }
}
