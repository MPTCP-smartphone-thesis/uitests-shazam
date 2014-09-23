package shazam;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiScrollable;
import com.android.uiautomator.core.UiSelector;


public class LaunchSettings extends UiAutomatorTestCase {
	
	private static String ID_SHAZ_TAGGING = "com.shazam.android:id/tagging_place_holder";
	private static String ID_SHAZ_NEWS_FEED = "com.shazam.android:id/news_feed_list";
	
	private void shazamIt() {
		fetchNews();
		recognizeIt();
	}
	
	private void fetchNews() {
		sleep(1000);
		
		// Click on "NEWS" button
		UiObject news = new UiObject(new UiSelector()
  			.className("android.widget.LinearLayout").instance(0)
  			.childSelector(new UiSelector().text("NEWS")));
		Utils.click(news);
		
		sleep(1000);
		
		// Update the news feed
		UiScrollable list = new UiScrollable(new UiSelector().resourceId(ID_SHAZ_NEWS_FEED));
		Utils.scrollBackward(list);
		
		sleep(3000);
	}
	
	private void recognizeIt() {
		// Click on "TAGGING" button
		UiObject tagging = new UiObject(new UiSelector()
			.className("android.widget.LinearLayout").instance(0)
			.childSelector(new UiSelector().text("TAGGING")));
		Utils.click(tagging);
  
		sleep(1000);
		
		// Click on the Shazam button
		Utils.click(ID_SHAZ_TAGGING);
		
		sleep(15000);
	}

	public void testDemo() throws UiObjectNotFoundException{
		assertTrue("OOOOOpps",Utils.openApp(this, "Shazam", "com.shazam.android"));
		while(true) {
			shazamIt();
		}
  }

}