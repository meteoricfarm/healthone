package com.secui.healthone.reciever

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import com.secui.healthone.data.TimeDBLog
import com.secui.healthone.util.DBHelper
import com.secui.healthone.util.PreferenceUtil
import java.time.Duration
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.ZoneId

class ScreenReceiver : BroadcastReceiver() {

    lateinit var prefs:PreferenceUtil

    override fun onReceive(context: Context?, intent: Intent?) {

        prefs = PreferenceUtil(context!!); // context가 null이 오진 않는다.
        val nowTime = LocalDateTime.now(ZoneId.of("Asia/Seoul"));

        if (intent?.action == Intent.ACTION_SCREEN_ON) {
            // 스크린 ON
            Log.i("SCREEN", "스크린 켜짐 (ON) >> TIME : ${nowTime.toString()}")
            prefs.setString("wake_time", "${nowTime.toString()}")

            val result = saveUserSleepTime(PreferenceUtil(context));
            Log.i(LOG, "측정된 취침 시간 : $result");

            if(result.recordSleepTime > 0){
                // selectAll
                val dbHelper = DBHelper(context);
                dbHelper.saveScore(
                    context=context,
                    recordSleepTime = result.recordSleepTime,
                    strartTime = result.startTime,
                    endTime = result.endTime
                );
            }

        } else if (intent?.action == Intent.ACTION_SCREEN_OFF) {
            // 스크린 OFF
            Log.i("SCREEN", "스크린 꺼짐 (OFF) >> TIME : ${nowTime.toString()}")
            prefs.setString("sleep_time", "${nowTime.toString()}")
        }
    }

    companion object {
        const val ERR = "SLEEP_ERR!!!!"
        const val LOG = "SLEEP_LOG::::"
    }


    fun saveUserSleepTime(prefs:PreferenceUtil):TimeDBLog{
        /* 변수 설명
            userWakeTime : 사용자의 기상시간 → 화면이 켜진 시간
            userSleepTime : 사용자의 취침시간 → 화면이 꺼진 시간
            setWakeTime : 사용자가 설정한 기상 시간
            setSleepTime : 사용자가 설정한 취침 시간

            LDT : LocalDateTime 변수용 접미사
            LT : LocalTime 변수용 접미사
         */

        // step1. 기록된 시간의 유효성 체크
        // 기록된 시간1이 유효하지 않으면 시간 판정이 불가하므로 0을 리턴하고 함수 종료
        val userWakeTime = prefs.getString("wake_time", "X")
        val userSleepTime = prefs.getString("sleep_time", "X")

        if(userSleepTime.equals("X") || userWakeTime.equals("X")) {
            Log.e(ERR, "수면 측정 값에 문제 발생 : The sleep measurement value is not perfect.")
            return TimeDBLog();
        };

        // step 2. 목표 수면/기상 시간 설정
        // 사용자가 설정한 값이 없을 경우에는 오후 22시 ~ 오전 7시를 기본 값으로 잡는다.
        // 이를 위해 시간처리를 위한 현재시각 기준 localDateTime 객체 생성
        val nowDate = LocalDateTime.now(ZoneId.of("Asia/Seoul"));

        // 세팅 값이 없을 경우에는 아래 선언된 값을 기준으로 시간 계산을 하게 된다.
        var targetWakeLT = LocalTime.of(7, 0, 0)
        var targetSleepLT = LocalTime.of(22, 0,0)

        // 사용자가 설정한 취침 시간 객체를 불러온다.
        val setSleepTime = prefs.getString("setting_sleep_time", "X")
        val setWakeTime = prefs.getString("setting_wake_time", "X")

        // 값 자체가 유효한지 부터 판단한다.
        // 세팅 값이 없다면, 기본 값을 사용해야 한다.
        val isSetSleep = setSleepTime.equals("X")
        val isSetWake = setWakeTime.equals("X");
//        Log.d(LOG, "GET_SETTINGS >>> setSleepTime: $setSleepTime / setWakeTime: $setWakeTime")
//        Log.d(LOG, "GET_SETTINGS >>> isSetSleep: $isSetSleep / isSetWake: $isSetWake")

//        // 수면 시간을 설정했다면 값을 바꿔준다.
//        if(!isSetSleep){
//            Log.i(LOG, "수면시간 : $setSleepTime")
//            val hour = setSleepTime.substring(0, 2);
//            val min = setSleepTime.substring(3);
//
//            targetSleepLT =
//                LocalTime.of(
//                    hour.toInt(),
//                    min.toInt(),
//                    0)
//        }
//
//        // 기상 시간을 설정했다면 값을 바꿔준다.
//        if(!isSetWake){
//            Log.i(LOG, "취침시간 : $setWakeTime")
//            val hour = setWakeTime.substring(0, 2);
//            val min = setWakeTime.substring(3);
//
//            targetWakeLT =
//                LocalTime.of(
//                    hour.toInt(),
//                    min.toInt(),
//                    0)
//        }

        // step3. 수면 시간에 대해서 유효성 검사를 해준다 > 유효한 수면시간이었다 ? 수면으로 기록
        // 실제 수면기록 측정을 위하 string로 저장된 시간 값을 날짜 객체로 바꿔준다.

        val userSleepLDT = LocalDateTime.parse(userSleepTime);
        val userWakeLDT = LocalDateTime.parse(userWakeTime);

        Log.d(LOG, "수면시간 ${userSleepLDT.toString()} / 기상시간 ${userWakeLDT.toString()}");
        // 설정된 수면, 기상 시간과의 시간차 비교를 위해 LocalTime 객체로 바꿔준다
        val useSleepLT = LocalTime.of(userSleepLDT.hour, userSleepLDT.minute, userSleepLDT.second);

        //Log.d(LOG,"측정된 수면 시간 : ${useSleepLT.toString()}")

        // 목표 수면시간과 비교합니다.
        val sleepDur1 = Duration.between(targetSleepLT, useSleepLT);

        // 기상시간과 수면시간을 비교합니다.
        val sleepDur2 = Duration.between(targetWakeLT, useSleepLT) // <= 0 이어야 한다.

        // 유효한 수면 시간인가?
        val isSleepIn = sleepDur1.toMinutes()+120 > 0 || sleepDur2.toMinutes() < 0;
        // Log.d(LOG,"시간차이 결과 : ${sleepDur1.toMinutes()} | ${sleepDur2.toMinutes()}")

        if(isSleepIn){
            val sleepGapDur = Duration.between(userSleepLDT, userWakeLDT);
            Log.i(LOG, "수면시간을 기록합니다 : ${sleepGapDur.seconds}")
            // return TimeDBLog();
            return TimeDBLog(
                recordSleepTime = sleepGapDur.seconds,
                startTime = userSleepTime,
                endTime = userWakeTime
            )
            // sleepGapDur.seconds;
        }else {
            Log.d(LOG, "유효한 수면 시간이 아닙니다... DATETIME : $userSleepLDT")
            return TimeDBLog();
        }
    }
}

