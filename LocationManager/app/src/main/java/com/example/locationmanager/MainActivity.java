package com.example.locationmanager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements LocationListener{

    private TextView textView;

    private long x = 0;
    private float y = 0;
    private Location location;
    private double latitude = 0;
    private double longitude;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);

        obterLocalizacao();

    }

    private void obterLocalizacao() {

        try {

            LocationManager locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);

            boolean gpsAtivo = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
            boolean redeAtiva = locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);

            if (!gpsAtivo && !redeAtiva) {

                Toast.makeText(this, "nao foi possivel obter a localizacao", Toast.LENGTH_SHORT).show();

            } else {

                if (redeAtiva) {

                    if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                        && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

                        System.out.println("teste");
                        locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, x, y, this);

                    }

                    if (locationManager != null) {

                        Location location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
                        if (location != null) {

                            latitude = location.getLatitude();
                            longitude = location.getLongitude();

                        }

                    }
                }

                if (gpsAtivo) {

                    if (location == null) {

                        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, x, y, this);
                        if(locationManager != null) {

                            location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                            if(location != null) {

                                latitude = location.getLatitude();
                                longitude = location.getLongitude();

                            }

                        }

                    }

                }

            }

            textView.setText("Latitude --> " + latitude + "\nLongitude --> " + longitude);

        } catch (Exception e) {

            e.printStackTrace();

        }

    }


    @Override
    public void onLocationChanged(Location location) {

        obterLocalizacao();

    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

        obterLocalizacao();

    }

    @Override
    public void onProviderEnabled(String provider) {

        obterLocalizacao();

    }

    @Override
    public void onProviderDisabled(String provider) {

        obterLocalizacao();

    }
}
