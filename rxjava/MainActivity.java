public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startWorkAndSubscribeWithOperators();
    }

    //OPERATORS----------------------------------------
    private void startWorkAndSubscribeWithOperators() {
        Observable<String> observable = createObservable();
        Observer<Object> observer = createObserver();

        observable
            .observeOn(Schedulers.io())
            .subscribeOn(AndroidSchedulers.mainThread())
            .filter(new Predicate<String>() { //emit only some elements
                @Override
                public boolean test(String s) throws Exception {
                    return s.toLowerCase().startsWith("c");
                }
            })
            .map(new Function<String, Object>() { //modify data
                @Override
                public Object apply(String s) {
                    return s.toUpperCase();
                }
            })
            .subscribe(observer);
    }

    //SCHEDULERS--------------------------
    private void startWorkAndSubscribe() {
        //create Observable and Observer
        Observable<String> observable = createObservable();
        Observer<String> observer = createObserver();

        //subscribe on choosen schedulers
        observable
            .observeOn(Schedulers.io()) //emit data on background thread
            .subscribeOn(AndroidSchedulers.mainThread()) //receive data on UI thread
            .subscribe(observer); //subscribe observer to observable
    }

    //OBSERVER---------------------------------
    private Observer<String> createObserver() {
        Observer<String> observer = new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
                //Observer subscribe to Observable
            }

            @Override
            public void onNext(String s) {
                //Observer received some data stream
            }

            @Override
            public void onError(Throwable e) {
                //Observer received emitted error
            }

            @Override
            public void onComplete() {
                //Observer completed receiving data from Observable
            }
        };
        return observer;
    }

    //OBSERVABLE--------------------------------------
    private Observable<String> createObservableJust() {
        //up to 10 items
        Observable<String> observable = Observable.just("Catan", "Splendor", "7 Wonders", "Codenames", "Taboo");
        return observable;
    }

    private Observable<String> createObservableFrom() {
        //create Observable by one of: fromArray, fromCallable, fromFuture, fromIterable, fromPublisher
        Observable<String> observable = Observable.fromArray("Catan", "Splendor", "7 Wonders", "Codenames", "Taboo");
        return observable;
    }

    private Observable<String> createObservable() {
        final List<String> data = prepareData();
        Observable<String> observable = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> emitter) throws Exception {
                //emit all data one by one
                for(String item : data) {
                    if(!emitter.isDisposed()) {
                        emitter.onNext(item);
                    }
                }
                //emit completed event
                if(!emitter.isDisposed()) {
                    emitter.onComplete();
                }
            }
        });
        return observable;
    }

    private List<String> prepareData() {
        List<String> data = new ArrayList<>();
        data.add("Catan");
        data.add("Splendor");
        data.add("7 Wonders");
        data.add("Codenames");
        data.add("Taboo");
        return data;
    }

}