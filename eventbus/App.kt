class App : Application() {

    override fun onCreate() {
        super.onCreate()
        //customize default EventBus instance must be called before first subscriber called
        EventBus.builder()
            .logNoSubscriberMessages(false) //do not log when no subscriber exists
            .sendNoSubscriberEvent(false) //do not send SubscriberEvent if no subscriber exists
            .throwSubscriberException(BuildConfig.DEBUG) //throw exceptions only in debug mode
            .installDefaultEventBus()

        //or create custom instance by using build method
    }
}