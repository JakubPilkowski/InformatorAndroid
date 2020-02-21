package pl.android.informator.helpers;

import android.app.AlertDialog;
import android.content.Context;

import com.android.informator.R;

public class ProgressDialogManager {

    private static ProgressDialogManager INSTANCE;

    public static ProgressDialogManager get() {
        return INSTANCE;
    }

    public static ProgressDialogManager init(Context context){
        return INSTANCE = new ProgressDialogManager(context);
    }
    private Context context;
    private AlertDialog dialog;
//    private BaseActivity activity;

    private ProgressDialogManager(Context context){
        this.context = context;
    }

    public void show() {
        dismiss();
//        if (context == null) return;
        dialog = new AlertDialog.Builder(context,R.style.ProgressDialogTheme)
                .setView(R.layout.progress_dialog)
                .setCancelable(false)
                .show();
    }

    public void dismiss() {
        if (dialog != null && this.dialog.isShowing()) dialog.dismiss();
        dialog = null;

    }
}
