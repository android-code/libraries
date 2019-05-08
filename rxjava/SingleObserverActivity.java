public class SingleObserverActivity extends AppCompatActivity {
    
    private Disposable disposable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_observer);

        Observable<String> observable = createObservableWithDispose();
        Observer<String> observer = createObserver();

        observable
            .observeOn(Schedulers.io())
            .subscribeOn(AndroidSchedulers.mainThread())
            .subscribe(observer);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        disposable.dispose(); //don't send event anymore
    }


    private Observer<String> createObserverWithDispose() {
        Observer<String> observer = new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
                //assign subscription to dispoable
                disposable = d;
            }
            @Override
            public void onNext(String s) { }
            @Override
            public void onError(Throwable e) { }
            @Override
            public void onComplete() { }
        };
        return observer;
    }
	
    private Observable<String> createObservableJust() {
        Observable<String> observable = Observable.just("Catan", "Splendor", "7 Wonders", "Codenames", "Taboo");
        return observable;
    }
}