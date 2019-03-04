public class MultipleObserversActivity extends AppCompatActivity {

    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiple_observers);
		
        Observable<String> observable = createObservable();
        DisposableObserver<String> observerGames = createDisposableObserver();
        DisposableObserver<String> observerFilteredGames = createDisposableObserver();

        compositeDisposable.add(observable
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(observerGames));

        compositeDisposable.add(observable
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .filter(new Predicate<String>() {
                @Override
                public boolean test(String s) throws Exception {
                    return s.toLowerCase().startsWith("c");
                }
            })
            .subscribeWith(observerFilteredGames));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        compositeDisposable.clear(); //clear all disposable
    }
	
    private Observable<String> createObservableJust() {
        Observable<String> observable = Observable.just("Catan", "Splendor", "7 Wonders", "Codenames", "Taboo");
        return observable;
    }

    private DisposableObserver<String> createDisposableObserver() {
        DisposableObserver<String> observer = new DisposableObserver<String>() {
            @Override
            public void onNext(String s) { }
            @Override
            public void onError(Throwable e) { }
            @Override
            public void onComplete() { }
        };
        return observer;
    }	
}