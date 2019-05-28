public class RxBindingActivity extends AppCompatActivity {

    private Button button, buttonBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rxbinding);
        
        button = findViewById(R.id.button);
        buttonBinding = findViewById(R.id.buttonBinding);
        
        //provide click actions
        setButtonClickByListener();
        setButtonClickByRxBinding();
    }

    //standard callback way
    private void setButtonClickByListener() {
        button.setOnClickListener(v -> {
            //perform job, for reactive programming emmit stream for Observer
            Observable.just(true).subscribe(aVoid -> {
                //action form Observer
            });
        });
    }

    //RxBinding way
    private void setButtonClickByRxBinding() {
        RxView.clicks(buttonBinding).subscribe(aVoid -> {
            //action form Observer
        });
    }
    
    //provide RxBinding for other widgets
}