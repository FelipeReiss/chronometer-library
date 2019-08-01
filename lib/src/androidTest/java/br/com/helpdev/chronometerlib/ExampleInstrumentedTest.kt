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
        println("Current time = " + cron.getRunningTime())
        Thread.sleep(6000)
        cron.lap()
        println("Current last lap = " + cron.getBaseLastLap())
        println("Current time after 2s = " + cron.getRunningTime())
        Thread.sleep(2000)
        cron.pause()
        Thread.sleep(4000)
        cron.start()
        Thread.sleep(2000)
        cron.lap()
        println("Current last lap = " + cron.getBaseLastLap())
        println("Current time after 2s = " + cron.getRunningTime())
        Thread.sleep(6000)
        cron.lap()
        println("Current last lap = " + cron.getBaseLastLap())
        println("Current time after 2s = " + cron.getRunningTime())
        Thread.sleep(4000)
        cron.stop()
        println("Last before stop = " + cron.getBaseLastLap())
        println("Stopped time = " + cron.getRunningTime())

        println("Before remove lap 2 (position 1)")
        cron.getObChronometer().laps.forEachIndexed { index, obLap ->
            println("Tempo ${index + 1}) " +
                    "End Time ${obLap.endTime} " +
                    "- Start Time ${obLap.startTime} " +
                    "+ Paused Time ${obLap.pausedTime} " +
                    "= Lap time ${obLap.getRunningTime()}")
        }

        cron.removelap(1)

        println("After remove lap 2 (position 1)")
        cron.getObChronometer().laps.forEachIndexed { index, obLap ->
            println("Tempo ${index + 1}) " +
                    "End Time ${obLap.endTime} " +
                    "- Start Time ${obLap.startTime} " +
                    "+ Paused Time ${obLap.pausedTime} " +
                    "= Lap time ${obLap.getRunningTime()}")
        }

    }
}
