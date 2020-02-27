package pl.android.informator.ui.timetable.set_route.set_route;

import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.widget.SearchView;

import com.android.informator.R;
import com.android.informator.databinding.SetRouteFragmentBinding;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Predicate;
import io.reactivex.rxjava3.schedulers.Schedulers;
import pl.android.informator.adapters.search.SearchAdapter;
import pl.android.informator.base.BaseViewModel;
import pl.android.informator.models.SearchResult;

public class SetRouteViewModel extends BaseViewModel {

    private CompositeDisposable disposables = new CompositeDisposable();
    private long timeSinceLastRequest;
    private ArrayAdapter searchAdapter;
    private ArrayList<SearchResult> searchResults;
    private ListView listView;
    public void init() {
        final SearchView searchView1 = ((SetRouteFragmentBinding) getBinding()).searchView1;
        final SearchView searchView2 = ((SetRouteFragmentBinding) getBinding()).searchView2;
        listView = ((SetRouteFragmentBinding)getBinding()).searchResults;

        searchResults = new ArrayList<>();
        ArrayList<String> availableLines = new ArrayList<>();
        availableLines.add("103");
        availableLines.add("104");
        availableLines.add("105");
        availableLines.add("106");
        availableLines.add("107");
        searchResults.add(new SearchResult("Kubusia Puchatka",availableLines));
        searchResults.add(new SearchResult("Kołobrzeska",availableLines));
        searchResults.add(new SearchResult("Kościuszki",availableLines));
        searchResults.add(new SearchResult("Dworzec Główny",availableLines));
        searchAdapter = new SearchAdapter(listView.getContext(),R.layout.search_default_item,searchResults);
        listView.setAdapter(searchAdapter);
        searchView1.setOnQueryTextFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    searchView1.setBackground(searchView1.getResources().getDrawable(R.drawable.gradient_gray_bottom_border));
                }
                else searchView1.setBackgroundResource(R.color.colorBlackLight);
            }
        });
        searchView2.setOnQueryTextFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus)
                    searchView2.setBackground(searchView2.getResources().getDrawable(R.drawable.gradient_gray_bottom_border));
                else searchView2.setBackgroundResource(R.color.colorBlackLight);
            }
        });

        searchView1.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                            @Override
                            public boolean onQueryTextSubmit(String query) {
                                Log.d("halo", "onQueryTextSubmit:");
                                return false;
                            }

                            @Override
                            public boolean onQueryTextChange(final String newText) {
//                                if(searchResults.contains(newText))
//                                {
                                    Log.d("halo", "onQueryTextChange:");
                                    searchAdapter.getFilter().filter(newText);
//                                    listView.setVisibility(View.VISIBLE);
//                                }
                                return false;
                            }
                        });


//        timeSinceLastRequest = System.currentTimeMillis();
//        Observable<String> observableQueryText = Observable
//                .create(new ObservableOnSubscribe<String>() {
//                    @Override
//                    public void subscribe(final ObservableEmitter<String> emitter) throws Exception {
//
//                        searchView1.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//                            @Override
//                            public boolean onQueryTextSubmit(String query) {
//                                return false;
//                            }
//
//                            @Override
//                            public boolean onQueryTextChange(final String newText) {
//                                if(!emitter.isDisposed()){
//                                    emitter.onNext(newText);
//                                }
//                                return false;
//                            }
//                        });
//                    }
//                })
//                .debounce(300, TimeUnit.MILLISECONDS) // Apply Debounce() operator to limit requests
//                .filter(new Predicate<String>() {
//                    @Override
//                    public boolean test(String text) throws Throwable {
//                        return !text.trim().isEmpty();
//                    }
//                })
//                .distinctUntilChanged()
//                .switchMap(new Function<String, ObservableSource<String>>() {
//                    @Override
//                    public ObservableSource<String> apply(String s) throws Throwable {
//                        return ;
//                    }
//                })
//                .subscribeOn(Schedulers.io());
//        observableQueryText.subscribe(new Observer<String>() {
//            @Override
//            public void onSubscribe(@NonNull Disposable d) {
//                disposables.add(d);
//            }
//
//            @Override
//            public void onNext(@NonNull String s) {
//                Log.d("halo", "onNext: time  since last request: " + (System.currentTimeMillis() - timeSinceLastRequest));
//                Log.d("halo", "onNext: search query: " + s);
//                timeSinceLastRequest = System.currentTimeMillis();
//            }
//
//            @Override
//            public void onError(@NonNull Throwable e) {
//
//            }
//
//            @Override
//            public void onComplete() {
//
//            }
//        });
    }

    public void onNextClick() {

    }

    public void onChangeDestClick() {

    }

    public void onDepartureTimeClick() {

    }
}
