package americo.mytoast;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MyToast {

    public static final int TAG_OK = 1;
    public static final int TAG_ERROR = 2;
    public static final int TAG_INFO = 3;

    public static void show(Context context, String text, int type, boolean isLong) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View layout = inflater.inflate(R.layout.toast_layout, null);

        LinearLayout llBackground = (LinearLayout) layout.findViewById(R.id.llBackground);
        ImageView ivImagem = (ImageView) layout.findViewById(R.id.toast_image);
        TextView tvDescricao = (TextView) layout.findViewById(R.id.toast_text);

        switch (type){
            case TAG_OK:
                llBackground.setBackgroundResource(R.drawable.toast_border_green);
                ivImagem.setImageResource(R.mipmap.ic_ok);
                tvDescricao.setText(text);
                break;
            case TAG_ERROR:
                llBackground.setBackgroundResource(R.drawable.toast_border_red);
                ivImagem.setImageResource(R.mipmap.ic_cancel);
                tvDescricao.setText(text);
                break;
            case TAG_INFO:
                llBackground.setBackgroundResource(R.drawable.toast_border_yellow);
                ivImagem.setImageResource(R.mipmap.ic_info);
                tvDescricao.setText(text);
                break;
        }

        Toast toast = new Toast(context);
        //toast.setGravity(Gravity.CENTER, 0, 0);
        toast.setDuration((isLong) ? Toast.LENGTH_LONG : Toast.LENGTH_SHORT);
        toast.setView(layout);
        toast.show();
    }
}
