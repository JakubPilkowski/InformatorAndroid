package pl.android.informator.helpers;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.android.informator.R;
import com.android.informator.databinding.CustomAcceptAlertDialogBinding;
import com.android.informator.databinding.CustomEditAlertDialogBinding;
import com.android.informator.databinding.CustomInfoAlertDialogBinding;

import pl.android.informator.base.BaseActivity;

public class AlertDialogManager {

    private static AlertDialogManager INSTANCE;
    private AlertDialog dialog;
    private BaseActivity activity;
    private Context context;

    private AlertDialogManager(Context context, BaseActivity activity) {
        this.activity = activity;
        this.context = context;
    }

    public static AlertDialogManager get() {
        return INSTANCE;
    }

    public static AlertDialogManager init(Context context, BaseActivity activity) {
        return INSTANCE = new AlertDialogManager(context, activity);
    }

    public void showEditDialog(String message, String hint, View.OnClickListener positiveListener, View.OnClickListener negativeListener) {
        dismiss();

        if (context == null || message == null || message.length() == 0) return;

        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(context);
        LinearLayout dialogTheme = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.custom_edit_alert_dialog, null);
        CustomEditAlertDialogBinding binding = CustomEditAlertDialogBinding.bind(dialogTheme);
        AlertDialogViewModel viewModel = new AlertDialogViewModel();
        binding.setViewModel(viewModel);
        viewModel.initEditDialog(context, message, hint, positiveListener, negativeListener);

        dialog = dialogBuilder
                .setView(binding.getRoot())
                .setCancelable(false)
                .show();
    }

    public void showInfoDialog(String message, View.OnClickListener listener) {
        dismiss();
        if (context == null || message == null || message.length() == 0) return;

        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(context);
        LinearLayout dialogTheme = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.custom_info_alert_dialog, null);
        CustomInfoAlertDialogBinding binding = CustomInfoAlertDialogBinding.bind(dialogTheme);
        AlertDialogViewModel viewModel = new AlertDialogViewModel();
        binding.setViewModel(viewModel);
        viewModel.initInfoDialog(context, message, listener);

        dialog = dialogBuilder
                .setView(binding.getRoot())
                .setCancelable(false)
                .show();

    }

    public void showAcceptDialog(String message, View.OnClickListener clickListener, View.OnClickListener cancelClick) {

        dismiss();
        if (context == null || message == null || message.length() == 0) return;

        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(context);
        LinearLayout dialogTheme = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.custom_accept_alert_dialog, null);
        CustomAcceptAlertDialogBinding binding = CustomAcceptAlertDialogBinding.bind(dialogTheme);
        AlertDialogViewModel viewModel = new AlertDialogViewModel();
        binding.setViewModel(viewModel);
        viewModel.initAcceptDialog(context, message, clickListener,cancelClick);

        dialog = dialogBuilder
                .setView(binding.getRoot())
                .setCancelable(false)
                .show();

    }

    public void showDialogNetworkDefaultError() {
        dismiss();
        if (context == null) return;
    }

    public View.OnClickListener getCancelClick() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        };
    }

    public void dismiss() {
        if (dialog != null && this.dialog.isShowing()) dialog.dismiss();

        dialog = null;

    }

}
