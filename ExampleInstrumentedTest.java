package ma.projet.android.uiautomatortests;

import android.content.Context;
import android.os.RemoteException;
import android.support.test.uiautomator.UiDevice;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;


/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(MainActivity.class);

    @After
    public void wrapUp() {
        System.out.println("Test done");
    }

    @Before
    public void setComponent() {
        System.out.println("Components initialize");
    }

    @Test
    public void testBackKeyPress() {
        UiDevice.getInstance(InstrumentationRegistry.getInstrumentation()).pressBack();
    }

    @Test
    public void testUi() throws RemoteException {
        UiDevice uiDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
        if (uiDevice.isScreenOn()) {
            uiDevice.setOrientationLeft();
            uiDevice.openNotification();
            uiDevice.openQuickSettings();
            uiDevice.pressHome();
        }
    }

    @Test
    public void testComplexUi() throws RemoteException {
        UiDevice uiDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
        if (uiDevice.isScreenOn()) {
            uiDevice.openNotification();
            uiDevice.pressBack();
            uiDevice.openQuickSettings();
            uiDevice.freezeRotation();
            uiDevice.setOrientationLeft();
            uiDevice.setOrientationRight();
            uiDevice.pressBack();
            uiDevice.pressHome();
        }
    }
}
