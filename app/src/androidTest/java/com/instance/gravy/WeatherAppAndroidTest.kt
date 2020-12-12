package com.instance.gravy

import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.rule.GrantPermissionRule
import androidx.test.runner.AndroidJUnit4
import com.instance.gravy.view.GravyMainActivity
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
@LargeTest
class WeatherActivityTest {

    lateinit var webServer: MockWebServer

    @Rule
    @JvmField
    var activityRuleGravy: ActivityTestRule<GravyMainActivity> = ActivityTestRule(GravyMainActivity::class.java)

    @Rule
    @JvmField
    var permissionRule: GrantPermissionRule =
        GrantPermissionRule.grant(android.Manifest.permission.ACCESS_FINE_LOCATION)

    @Before
    fun initValidString() {
        webServer = MockWebServer()
        webServer.start(8080)
    }

    @After
    @Throws(Exception::class)
    fun tearDown() {
        webServer.shutdown()
    }

}