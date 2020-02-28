package pl.android.informator.ui.timetable.set_route.set_route;

import android.app.Activity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.TypedValue;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableField;
import androidx.recyclerview.widget.RecyclerView;

import com.android.informator.R;
import com.android.informator.databinding.SetRouteFragmentBinding;

import java.util.ArrayList;

import io.reactivex.rxjava3.disposables.CompositeDisposable;
import pl.android.informator.activities.MainActivity;
import pl.android.informator.adapters.search.SearchAdapter;
import pl.android.informator.base.BaseViewModel;
import pl.android.informator.helpers.TextHelper;
import pl.android.informator.models.SearchResult;

public class SetRouteViewModel extends BaseViewModel {

    private CompositeDisposable disposables = new CompositeDisposable();
    private long timeSinceLastRequest;
    private SearchAdapter searchAdapter;
    public ObservableField<SearchAdapter> adapter = new ObservableField<>();
    public ObservableField<RecyclerView.OnScrollListener> listener = new ObservableField<>();
    private ArrayList<SearchResult> searchResults;
    public RelativeLayout nextButton;
    public RelativeLayout doneButton;
    public EditText search1;
    public EditText search2;
    public RecyclerView recyclerView;
    public int state;
    public final int STATE_SEARCHING = 1;
    public final int STATE_DEFAULT = 0;


    public void init() {
        state = STATE_DEFAULT;
        search1 = ((SetRouteFragmentBinding) getBinding()).searchView1;
        search2 = ((SetRouteFragmentBinding) getBinding()).searchView2;
        nextButton = ((SetRouteFragmentBinding) getBinding()).setRouteNextButton;
        recyclerView = ((SetRouteFragmentBinding)getBinding()).setRouteRecyclerView;
        searchResults = new ArrayList<>();
        ArrayList<String> availableLines = new ArrayList<>();
        availableLines.add("103");
        availableLines.add("104");
        availableLines.add("105");
        availableLines.add("106");
        availableLines.add("107");
        searchResults.add(new SearchResult("Kubusia Puchatka", availableLines));
        searchResults.add(new SearchResult("Kołobrzeska", availableLines));
        searchResults.add(new SearchResult("Kościuszki", availableLines));
        searchResults.add(new SearchResult("Dworzec Główny", availableLines));
        searchResults.add(new SearchResult("Kubusia Puchatka", availableLines));
        searchResults.add(new SearchResult("Kołobrzeska", availableLines));
        searchResults.add(new SearchResult("Kościuszki", availableLines));
        searchResults.add(new SearchResult("Dworzec Główny", availableLines));
        searchResults.add(new SearchResult("Kubusia Puchatka", availableLines));
        searchResults.add(new SearchResult("Kołobrzeska", availableLines));
        searchResults.add(new SearchResult("Kościuszki", availableLines));
        searchResults.add(new SearchResult("Dworzec Główny", availableLines));
        searchAdapter = new SearchAdapter(searchResults);
        adapter.set(searchAdapter);
        searchAdapter.setRouteViewModel(this);
        listener.set(scrollListener);
        search1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                searchAdapter.getFilter().filter(s);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        search1.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    search1.setBackground(search1.getResources().getDrawable(R.drawable.gradient_gray_bottom_border));
                } else {
                    search2.setVisibility(View.VISIBLE);
                    search1.setBackgroundResource(R.color.colorBlackLight);
                }
            }
        });
        search2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                searchAdapter.getFilter().filter(s);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        search2.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    search2.setBackground(search2.getResources().getDrawable(R.drawable.gradient_gray_bottom_border));
                } else {
                    search1.setVisibility(View.VISIBLE);
                    search2.setBackgroundResource(R.color.colorBlackLight);
                }
            }
        });


//        timeSinceLastRequest = System.currentTimeMillis();
//        Observable<String> observableQueryText = Observable
//                .create(new ObservableOnSubscribe<String>() {
//                    @Override
//                    public void subscribe(final ObservableEmitter<String> emitter) throws Exception {
//
//                        search1.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
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
    public void onBackPressed(){
        state = STATE_DEFAULT;
        nextButton.setVisibility(View.VISIBLE);
        searchAdapter = new SearchAdapter(searchResults);
        adapter.set(searchAdapter);
        searchAdapter.setRouteViewModel(this);
        recyclerView.setVisibility(View.INVISIBLE);
        search1.setVisibility(View.VISIBLE);
        search2.setVisibility(View.VISIBLE);
        ((MainActivity)getActivity()).viewModel.title.set(getFragment().getToolbarName());
        ((MainActivity)getActivity()).viewModel.textSize.set(TextHelper.getPixels(TypedValue.COMPLEX_UNIT_DIP,getFragment().getToolbarFontSize()));
        search1.clearFocus();
        search2.clearFocus();
    }
    public void onDoneClick() {
        state = STATE_DEFAULT;
        nextButton.setVisibility(View.VISIBLE);
//        doneButton.setVisibility(View.GONE);
        searchAdapter = new SearchAdapter(searchResults);
        adapter.set(searchAdapter);
        searchAdapter.setRouteViewModel(this);
        recyclerView.setVisibility(View.INVISIBLE);
        search1.setVisibility(View.VISIBLE);
        search2.setVisibility(View.VISIBLE);
        ((MainActivity)getActivity()).viewModel.title.set(getFragment().getToolbarName());
        ((MainActivity)getActivity()).viewModel.textSize.set(TextHelper.getPixels(TypedValue.COMPLEX_UNIT_DIP,getFragment().getToolbarFontSize()));
        if(search1.hasFocus()){
            search1.clearFocus();
            if(search2.getText().toString().length()==0)
                search2.requestFocus();
            return;
        }
        if(search2.hasFocus()){
            search2.clearFocus();
        }
    }

    public void onChangeDestClick() {

    }

    public void onDepartureTimeClick() {

    }

    private RecyclerView.OnScrollListener scrollListener = new RecyclerView.OnScrollListener() {
        @Override
        public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
            hideKeyboard(getActivity());
            super.onScrollStateChanged(recyclerView, newState);
        }

        @Override
        public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);
        }
    };

    public void hideKeyboard(Activity activity) {
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        //Find the currently focused view, so we can grab the correct window token from it.
        View view = activity.getCurrentFocus();
        //If no view currently has focus, create a new one, just so we can grab a window token from it
        if (view == null) {
            view = new View(activity);
        }
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}
