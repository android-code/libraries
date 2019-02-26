class App : Application() {

    //create Koin module
    val appModule = module {

        //single instance of something
        single { PreferenceManager.getDefaultSharedPreferences(get()) }

        //provide names to recognize instances of the same type
        single(name = "red") { SimpleDependency("red", "oval") }
        single(name = "blue") { SimpleDependency("blue", "triangle") }

        //get provided NetworkManager into ComplexDependency factory
        factory { ComplexDependency(get()) }
        single { NetworkManager("androidcode.pl", 80) }

        //single instance of ParentDependency provided by ChildDependency
        single<ParentDependency> { ChildDependency("text", 100) }
        //for providing single instance matching multiple types use code below:
        //single { ChildDependency("text", 100) } bind ParentDependency::class
    }

    val scopeModule = module {
        scope<ScopeActivity> {
            scoped("scoped") { SimpleDependency("black", "square") }
        }
    }

    val viewModelModule = module {
        single { SimpleDependency("white", "rectangle") }
        viewModel {
            SomeViewModel(get())
        }
    }

    override fun onCreate() {
        super.onCreate()

        //create and register KoinApplication instance
        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(appModule, scopeModule, viewModelModule)
        }
    }
}