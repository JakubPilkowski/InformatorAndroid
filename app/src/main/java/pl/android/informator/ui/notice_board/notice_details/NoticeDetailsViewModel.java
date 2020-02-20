package pl.android.informator.ui.notice_board.notice_details;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.provider.Telephony;
import android.view.View;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.databinding.ObservableField;
import androidx.viewpager.widget.ViewPager;

import com.android.informator.databinding.NoticeDetailsFragmentBinding;

import pl.android.informator.activities.MainActivity;
import pl.android.informator.adapters.notice_board.ViewPagerAdapter;
import pl.android.informator.base.BaseViewModel;
import pl.android.informator.helpers.AlertDialogManager;
import pl.android.informator.models.Notice;

public class NoticeDetailsViewModel extends BaseViewModel {

    public ObservableField<String> title = new ObservableField<>();
    public ObservableField<String> price = new ObservableField<>();
    public ObservableField<String> desc = new ObservableField<>();
    public ObservableField<ViewPager> viewPager = new ObservableField<>();
    private String phoneNumber;

    public void init(Notice notice) {
        title.set(notice.getTitle());
        ViewPager viewPager = ((NoticeDetailsFragmentBinding)getBinding()).noticeDetailsViewpager;
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(viewPager.getContext(), notice.getImgUrls());
        viewPager.setAdapter(viewPagerAdapter);
        viewPager.setPageMargin(0);
        phoneNumber = String.valueOf(notice.getPhoneNumber());
        price.set(notice.getPrice());
        desc.set(notice.getDescription());
        this.viewPager.set(viewPager);
    }

    public void onEditClick() {
        AlertDialogManager.get().showEditDialog("Podaj email","Email",showCodeDialog(), AlertDialogManager.get().getCancelClick());
    }
    private View.OnClickListener showCodeDialog(){
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialogManager.get().showEditDialog("Podaj kod ogłoszenia", "Kod ogłoszenia",openEditingNotice(),AlertDialogManager.get().getCancelClick());
            }
        };
    }

    private View.OnClickListener openEditingNotice(){
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity().getApplicationContext(),"Otworzono edycje ogłoszenia",Toast.LENGTH_SHORT).show();
                AlertDialogManager.get().dismiss();
            }
        };
    }
    public void onPhoneClick(){
        if(ContextCompat.checkSelfPermission(getActivity().getApplicationContext(), Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(getActivity(),new String[]{Manifest.permission.CALL_PHONE}, MainActivity.REQUEST_CALL);
        }
        else {
            String dial="tel:"+phoneNumber;
            getActivity().startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
        }
    }
    public void onMessageClick(){
        if(ContextCompat.checkSelfPermission(getActivity().getApplicationContext(), Manifest.permission.SEND_SMS)!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(getActivity(),new String[]{Manifest.permission.SEND_SMS}, MainActivity.REQUEST_SMS);
        }
        else {
            String dial="sms:"+phoneNumber;
            Intent smsIntent = new Intent(Intent.ACTION_VIEW);

            String defaultSmsPackageName = Telephony.Sms.getDefaultSmsPackage(getActivity().getApplicationContext());
            if(defaultSmsPackageName!=null){
                smsIntent.setPackage(defaultSmsPackageName);
            }
            smsIntent.setData(Uri.parse(dial));
            getActivity().startActivity(smsIntent);
        }
    }
}
