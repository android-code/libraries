//some Android component class
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    //register in proper place of lifecycle
    public override fun onStart() {
        super.onStart()
        EventBus.getDefault().register(this)
    }

    //unregister to avoid leak memory
    public override fun onStop() {
        super.onStop()
        EventBus.getDefault().unregister(this)
    }

    //post event on some action like click listener
    private fun postEvent() {
        EventBus.getDefault().post(MessageEvent(100, "text"))
    }

    private fun postStickyEvent() {
        EventBus.getDefault().postSticky(Custom2Event("Johnnie"))
    }

    //choose one of POSTING, MAIN, BACKGROUND, MAIN_ORDERED, ASYNC
    @Subscribe(threadMode = ThreadMode.MAIN) //ThreadMode.POSTING is by default
    fun onMessageEvent(event: MessageEvent) {
        //do something with received event on the main UI thread
    }

    //priority 0 is default
    @Subscribe
    fun onMessageEvent(event: Custom1Event) {
        //do something with received event on the background thread
        
        //on some conditions
        //prevent delivery to other subscribers with lower priority
        EventBus.getDefault().cancelEventDelivery(event)
    }

    @Subscribe(priority = 1) 
    fun onMessageEventExtra(event: Custom1Event) {
        //do something with received event on the background thread
    }

    //received value only from events posted by postSticky
    @Subscribe(sticky = true)
    fun onMessageEvent(event: Custom2Event) {
        //receive previously posted sticky event immediately
        //listen for new event
    }
}