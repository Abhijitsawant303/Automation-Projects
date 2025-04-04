package digital.fms.tests.base;

public class Hooks {
//	static Config config = new Config();
//
//	@Before
//	public void setup() {
//        Configuration.timeout = config.getTimeout();
//        Configuration.browser = config.getBrowserName();
//        Configuration.downloadsFolder = config.getDownloadPath();
//    }
//
//	@After
//    public void teardown(Scenario scenario) {
//		//Take screenshot if scenario failed
//        try {
//            if (scenario.isFailed()) {
//                Allure.addAttachment(scenario.getName(),
//                        new ByteArrayInputStream(((TakesScreenshot)
//                                getWebDriver()).getScreenshotAs(OutputType.BYTES)));
//            }
//        }
//        catch (IllegalStateException e){
//            Log.info("Handled the exception");
//        }
//        Selenide.closeWebDriver();
//    }
//
//    public void clearCache() {
//        Log.info("clearCache");
//        clearBrowserCache();
//    }
//
//    public void clearCookies() {
//        Log.info("clearCookies");
//        clearBrowserCookies();
//    }
//
//    public void clearLocalStorage() {
//        Log.info("clearLocalStorage");
//        clearBrowserLocalStorage();
//    }
}