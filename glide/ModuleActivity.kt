class ModuleActivity : AppCompatActivity() {

    private val url = "http://androidcode.pl/assets/img/main_banner.jpg"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_module)
    }

    //use GlideApp to use custom module instead of Glide
    private fun loadImageByCustomModule() {
        //will draw circle crop 100px image with cross fade transition and custom log and cache settings
        GlideApp.with(this).load(url)
            .smallCircle() //new custom option
            .into(imageView)
    }
}