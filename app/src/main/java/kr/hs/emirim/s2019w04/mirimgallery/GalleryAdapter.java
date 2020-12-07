package kr.hs.emirim.s2019w04.mirimgallery;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class GalleryAdapter extends BaseAdapter {
    int[] imgRes = {R.drawable.a,R.drawable.b,R.drawable.c,R.drawable.d,R.drawable.e,
            R.drawable.f,R.drawable.g,R.drawable.h,R.drawable.i,R.drawable.j,
            R.drawable.k,R.drawable.l,R.drawable.m,R.drawable.n,R.drawable.o,R.drawable.p
    };
    String[] imgTitles = {"최현석", "박지훈", "요시", "김준규", "마시호", "윤재혁", "아사히", "방예담",
            "김도영", "하루토", "박정우", "소정환", "D-4", "D-3", "D-1", "TREASURE"};
    Context context;
    ImageView imgvMain;
    TextView textToast;
    View toastView;

    public GalleryAdapter(Context context, ImageView imgvMain) {
        this.context = context;
        this.imgvMain = imgvMain;
    }

    @Override
    public int getCount() {
        return imgRes.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imgv = new ImageView(context);
        imgv.setLayoutParams(new Gallery.LayoutParams(200, 300));
        imgv.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imgv.setPadding(5, 5, 5, 5);
        imgv.setImageResource(imgRes[position]);

        final int pos = position;
        imgv.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                imgvMain.setScaleType(ImageView.ScaleType.FIT_CENTER);
                imgvMain.setImageResource(imgRes[pos]);
                Toast toast = new Toast(context);
                toastView = View.inflate(context, R.layout.toast, null);
                textToast = toastView.findViewById(R.id.text_toast);
                textToast.setText(imgTitles[pos]);
                toast.setView(toastView);
                toast.show();
                return false;
            }
        });
        return imgv;
    }
}