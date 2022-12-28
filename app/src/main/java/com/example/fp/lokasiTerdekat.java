package com.example.fp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.fp.databinding.ActivityLokasiTerdekatBinding;

public class lokasiTerdekat extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityLokasiTerdekatBinding binding;
    private LocationManager lm;
    private LocationListener ll;
    private double latitude, longitude;
    private TextView dikirim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        lm = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
//        ll = new lokacyListener();
//        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
//            // TODO: Consider calling
//            //    ActivityCompat#requestPermissions
//            // here to request the missing permissions, and then overriding
//            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
//            //                                          int[] grantResults)
//            // to handle the case where the user grants the permission. See the documentation
//            // for ActivityCompat#requestPermissions for more details.
//            return;
//        }

        binding = ActivityLokasiTerdekatBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    private class lokacyListener implements LocationListener {

        public double la, li;

        @Override
        public void onLocationChanged(Location location) {

//            latitude = location.getLatitude();
//            longitude = location.getLongitude();
//            la = location.getLatitude();
//            li = location.getLongitude();

            Toast.makeText(getBaseContext(), "GPS capture", Toast.LENGTH_LONG).show();

            LatLng sydney = new LatLng(location.getLatitude(), location.getLongitude());
            LatLng padang1 = new LatLng(-7.28048, 112.78926);
            LatLng padang2 = new LatLng(-7.29042, 112.79573);
            LatLng padang3 = new LatLng(-7.26089, 112.79037);
            Location asal = new Location("asal");
            asal.setLatitude(sydney.latitude);
            asal.setLongitude(sydney.longitude);
            Location tujuan1 = new Location("tujuan1");
            tujuan1.setLatitude(padang1.latitude);
            tujuan1.setLongitude(padang1.longitude);
            Location tujuan2 = new Location("tujuan2");
            tujuan2.setLatitude(padang2.latitude);
            tujuan2.setLongitude(padang2.longitude);
            Location tujuan3 = new Location("tujuan3");
            tujuan3.setLatitude(padang3.latitude);
            tujuan3.setLongitude(padang3.longitude);
            mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in your Location"));
            mMap.addMarker(new MarkerOptions().position(padang1).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)));
            mMap.addMarker(new MarkerOptions().position(padang2).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)));
            mMap.addMarker(new MarkerOptions().position(padang3).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)));
            String[] namaTempat = new String[]{"Uni Ampera 1", "Uni Ampera 2", "Uni Ampera 3"};
            double[] jarak = new double[]{asal.distanceTo(tujuan1), asal.distanceTo(tujuan2), asal.distanceTo(tujuan3)};
            String jarakterdekat = "Uni Ampera";
            double patokan = 1000000;
            for (int i=0;i<3;i++){
                if (jarak[i] < patokan){
                    patokan=jarak[i];
                    jarakterdekat = namaTempat[i];
                }
            }
            Toast.makeText(getBaseContext(), "Tempat terdekat adalah " + jarakterdekat, Toast.LENGTH_LONG).show();
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney, 13));
            tampilInput(jarakterdekat);
        }

        @Override
        public void onFlushComplete(int requestCode) {
            LocationListener.super.onFlushComplete(requestCode);
        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {
            LocationListener.super.onStatusChanged(provider, status, extras);
        }

        @Override
        public void onProviderEnabled(@NonNull String provider) {
            LocationListener.super.onProviderEnabled(provider);
        }

    }

    private void tampilInput(String jarak){
        LayoutInflater li = LayoutInflater.from(this);
        View input = li.inflate(R.layout.konfirmasi, null);
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setView(input);
        dikirim = (TextView) input.findViewById(R.id.namaTerdekat);
        dikirim.setText(jarak);
        dialog.setCancelable(false);
        dialog.setPositiveButton("Ok", oknya);
        dialog.show();
    }

    DialogInterface.OnClickListener oknya = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialogInterface, int i) {
            Toast.makeText(getBaseContext(), "Pesanan anda akan segera dikirim", Toast.LENGTH_LONG).show();
        }
    };

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        ll = new lokacyListener();

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            ActivityCompat.requestPermissions(lokasiTerdekat.this, new String[] {Manifest.permission.ACCESS_FINE_LOCATION}, 100);
            return;
        }
        lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 200, ll);
        // Add a marker in Sydney and move the camera
//        LatLng sydney = new LatLng(10.11, -10.1);
//        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in your Location"));
//        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney, 8));
    }




}