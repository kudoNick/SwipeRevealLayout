package com.example.swipereveallayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView lvData;
    private List<SinhVien> sinhVienList;
    private SinhVienAdapter sinhVienAdapter;
    private String name[] = {"Tuấn Anh","Thu Phạm","Quỳnh Anh","Dũng Tuấn","Hữu Thắng","Xuân Đức","Đăng Vũ","Huy Phan","Văn Đức","Đoàn Biển",};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvData = findViewById(R.id.lvData);

        sinhVienList = new ArrayList<>();
        for (int i = 0; i < name.length ; i++) {
            SinhVien sinhVien = new SinhVien();
            sinhVien.setName(name[i]);
            sinhVienList.add(sinhVien);
        }
        sinhVienAdapter = new SinhVienAdapter(sinhVienList,this);
        lvData.setAdapter(sinhVienAdapter);
    }
}