class SimpleDependencyTest: KoinTest {

    //define some test module dependencies
    val testModule = module {
        single { SimpleDependency("red", "oval") }
    }

    //inject instance into member or get inside method test
    val dependency: SimpleDependency by inject()

    //init test dependencies before each test
    @Before
    fun before() {
        startKoin {
            modules(testModule)
        }
    }

    //stop test dependencies after each test
    @After
    fun after() {
        stopKoin()
    }

    //test dependency
    @Test
    fun testChangeColorWithInjection() {
        assertEquals("SimpleDependency is red oval", dependency.getInfo())
        dependency.changeColor("orange")
        assertEquals("SimpleDependency is orange oval", dependency.getInfo())
    }

    //test mock
    @Test
    fun testCheckMock() {
        //declare and get mock
        declareMock<SimpleDependency>(name = "mock")
        val mock: SimpleDependency = get(name = "mock")

        //asserts, rules, verify
        assertNotNull(mock)
        Mockito.`when`(mock.getInfo()).thenReturn("SimpleDependency is green oval")
        assertEquals("SimpleDependency is green oval", mock.getInfo())
        Mockito.verify(mock, times(1)).getInfo()
    }
}