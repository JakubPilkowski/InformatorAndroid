package pl.android.informator.helpers;

import android.content.Context;
import android.view.View;

import androidx.databinding.ObservableField;

import com.android.informator.R;

public class AlertDialogViewModel {
    public ObservableField<String>message = new ObservableField<>();
    public ObservableField<String>hint = new ObservableField<>();
    public ObservableField<String>positiveButtonText = new ObservableField<>();
    public ObservableField<String>negativeButtonText = new ObservableField<>();
    public ObservableField<View.OnClickListener> positiveButtonListener = new ObservableField<>();
    public ObservableField<View.OnClickListener> negativeButtonListener = new ObservableField<>();

    void initEditDialog(Context context, String message, String hint, View.OnClickListener positiveButtonListener,
                        View.OnClickListener negativeButtonListener)
    {
        this.message.set(message);
        this.hint.set(hint);
        this.positiveButtonText.set(context.getString(R.string.next));
        this.negativeButtonText.set(context.getString(R.string.cancel));
        this.positiveButtonListener.set(positiveButtonListener);
        this.negativeButtonListener.set(negativeButtonListener);
    }

    void initInfoDialog(Context context, String message, View.OnClickListener positiveButtonListener){
        this.message.set(message);
        this.positiveButtonText.set(context.getString(R.string.ok));
        this.positiveButtonListener.set(positiveButtonListener);
    }

    void initAcceptDialog(Context context, String message, View.OnClickListener positiveButtonListener,
                          View.OnClickListener negativeButtonListener)
    {
        this.message.set(message);
        this.positiveButtonText.set(context.getString(R.string.yes));
        this.positiveButtonListener.set(positiveButtonListener);
        this.negativeButtonText.set(context.getString(R.string.no));
        this.negativeButtonListener.set(negativeButtonListener);
    }
}
