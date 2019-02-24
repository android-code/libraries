@Qualifier
@Retention(RUNTIME)
public @interface Type {

    //qualifier annotations to use like @Named, for example:
    //@Inject @Type("type") 
    SimpleDependency dependency
}