package br.com.helpdev.chronometerlib


import android.os.SystemClock
import androidx.test.runner.AndroidJUnit4
import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        println("elapsedRealtime: "+ SystemClock.elapsedRealtime())
        var cron = Chronometer()
        cron.start()
        Thread.sleep(2000)
        println("Current time = " + cron.getRunningTime())
        cron.lap()
        println("Current last lap = " + cron.getBaseLastLap())
        println("Current time after 2s = " + cron.getRunningTime())
        Thread.sleep(2000)
        cron.lap()
        println("Current last lap = " + cron.getBaseLastLap())
        println("Current time after 2s = " + cron.getRunningTime())
        Thread.sleep(2000)
        cron.lap()
        println("Current last lap = " + cron.getBaseLastLap())
        println("Current time after 2s = " + cron.getRunningTime())
        Thread.sleep(2000)
        cron.stop()
        println("Last before stop = " + cron.getBaseLastLap())
        println("Stopped time = " + cron.getRunningTime())
        Thread.sleep(2000)
        println("Stopped time after 2s = " + cron.getRunningTime())
        println("elapsedRealtime: "+ SystemClock.elapsedRealtime())

    }
}
