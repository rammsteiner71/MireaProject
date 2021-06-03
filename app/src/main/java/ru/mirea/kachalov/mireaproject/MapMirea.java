package ru.mirea.kachalov.mireaproject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapMirea extends Fragment {

    private static final int REQUEST_CODE_PERMISSION_LOCATION = 100;
    private boolean isWork = false;
    private GoogleMap mMap;
    private String[] PERMISSION = {Manifest.permission.ACCESS_FINE_LOCATION};

    private OnMapReadyCallback callback = new OnMapReadyCallback() {

        @Override
        public void onMapReady(GoogleMap googleMap) {
            mMap = googleMap;
            LatLng kbsp = new LatLng(55.7935328, 37.7012789);
            CameraPosition cameraPosition = new CameraPosition.Builder().target(kbsp).zoom(12).build();
            mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
            googleMap.addMarker(new MarkerOptions().position(kbsp).title("Преображенская Площадь").snippet("Стромынка 20, тел. 8 (499) 215-65-65"));
            LatLng vernadka = new LatLng(55.7121106, 37.552051);
            googleMap.addMarker(new MarkerOptions().position(vernadka).title("Юго-Западная").snippet("Вернадского 78, тел. 8 (499) 215-65-65"));
            LatLng frynza = new LatLng(55.7316875, 37.5746875);
            googleMap.addMarker(new MarkerOptions().position(frynza).title("Фрунзенская").snippet("Малая Пироговская 1с5, тел. 8 (499) 215-65-65"));

            if (ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                return;
            }
            // добавление кнопки определения местоположения
            mMap.setMyLocationEnabled(true);
            // добавление кнопок изменнеия масштаба
            mMap.getUiSettings().setZoomControlsEnabled(true);
            // отображение слоя загруженности дорог
            mMap.setTrafficEnabled(true);
        }
    };

    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_CODE_PERMISSION_LOCATION) {
            // permission granted
            isWork = grantResults.length > 0
                    && grantResults[0] == PackageManager.PERMISSION_GRANTED;
        }
    }

    public static boolean hasPermissions(Context context, String... permissions) {
        if (context != null && permissions != null) {
            for (String permission : permissions) {
                if (ActivityCompat.checkSelfPermission(context, permission) != PackageManager.PERMISSION_GRANTED) {
                    return false;
                }
            }
        }
        return true;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_map_mirea, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SupportMapFragment mapFragment =
                (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        if (mapFragment != null) {
            mapFragment.getMapAsync(callback);
        }
    }
}