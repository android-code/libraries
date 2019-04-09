@GlideExtension
object CustomGlideExtension {
    
    //class with private constructor and static annotated methods

    @GlideOption
    @JvmStatic
    fun smallCircle(options: BaseRequestOptions<*>): BaseRequestOptions<*> {
        return options.circleCrop().override(100)
    }

    //more @GlideOption and @GlideType methods
}