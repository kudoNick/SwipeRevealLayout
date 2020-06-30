package com.example.swipereveallayout;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.chauthai.swipereveallayout.SwipeRevealLayout;
import com.chauthai.swipereveallayout.ViewBinderHelper;

import java.util.List;

class SinhVienAdapter extends BaseAdapter {

    private TextView tvName;
    List<SinhVien> sinhVienList;
    Context context;
    private ViewBinderHelper viewBinderHelper;

    //Đối tượng này giúp bạn lưu và khôi phục trạng thái mở hay là đóng của mỗi chế độ xem
    private SwipeRevealLayout revealLayout;

    public SinhVienAdapter(List<SinhVien> sinhVienList, Context context) {
        this.sinhVienList = sinhVienList;
        this.context = context;
        viewBinderHelper = new ViewBinderHelper();
        //Chỉ muốn mở một hàng tại một thời điểm
        viewBinderHelper.setOpenOnlyOne(true);
    }

    @Override
    public int getCount() {
        return sinhVienList.size();
    }

    @Override
    public Object getItem(int position) {
        return sinhVienList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.sinhvien, parent, false);

        SinhVien sinhVien = (SinhVien) getItem(position);

        tvName = view.findViewById(R.id.tvName);
        tvName.setText(sinhVien.getName());

        revealLayout = view.findViewById(R.id.swipe_layout);

        //Lưu và khôi phục trạng thái mở/đóng
        //Cần cung cấp một Id để xác định đối tượng lưu dữ liệu
        viewBinderHelper.bind(revealLayout,sinhVien.getName());
        return view;
    }
}
