package com.secui.healthone.util

import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import com.secui.healthone.data.TimeDBLog
import java.time.LocalDateTime
import java.time.ZoneId

// 기록들을 저장하고 불러오기 위한 DB 클래스
class DBHelper: SQLiteOpenHelper {

    // 생성자 ( 데이터 베이스의 이름을 정해줌. )
    constructor(context: Context) :super(context, "health_one.db", null, 1);

    // 데이터 베이스 파일이 생성될 때 자동 호출되는 메서드
    // 테이블 생성 코드를  작성한다
    // 데이터 베이스 파일이 생성될 때 호출
    override fun onCreate(p0: SQLiteDatabase?) {
        // 생성 쿼리문 작성
        // 메모사항
        val sql = """
            create table sleep_record(
            	sleep_record_idx integer primary key autoincrement,
                record_sleep_time integer not null,
                rec_start_time string,
                rec_end_time string,                
                rec_time_log TIMESTAMP not null DEFAULT CURRENT_TIMESTAMP 
            );
        """.trimIndent()
        p0?.execSQL(sql);
    }

    // 데이터 베이스가 업데이트?? 될때 호출
    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
    }



    fun getTotalSleeTime(
        context: Context,
        time: LocalDateTime = LocalDateTime.now(ZoneId.of("Asia/Seoul"))
    ):Int{
        val dbHelper = DBHelper(context = context)
        val endDate = time.toLocalDate().atStartOfDay()
        val startDate = endDate.minusDays(1).plusSeconds(1)
        val args = arrayOf(startDate.toString(), endDate.toString())
        val query = """
            SELECT SUM(record_sleep_time) AS total_sleep_time
            FROM sleep_record
            WHERE rec_time_log BETWEEN ? AND ?
        """.trimIndent()

        var totalSleepTime = 0
        val cursor: Cursor = dbHelper.readableDatabase.rawQuery(query, args)
        if (cursor.moveToFirst()) {
            val sleepCursor = cursor.getColumnIndex("total_sleep_time")
            totalSleepTime = cursor.getInt(sleepCursor)
        }
        cursor.close()
        dbHelper.close()
        return totalSleepTime
    }

    // db 출력
    fun selectAllOneDay(
        context: Context,
        time: LocalDateTime = LocalDateTime.now(ZoneId.of("Asia/Seoul"))
    ):MutableList<TimeDBLog> {

        val dbHelper = DBHelper(context = context)
        val query = """
                            SELECT 
                            sleep_record_idx, 
                            record_sleep_time, 
                            rec_time_log, 
                            rec_start_time,
                            rec_end_time 
                            FROM sleep_record
                            WHERE rec_time_log BETWEEN ? AND ?
                        """.trimIndent()

        val endDate = time.toLocalDate().atStartOfDay()
        val startDate = endDate.minusDays(1).plusSeconds(1)
        val args = arrayOf(startDate.toString(), endDate.toString())

        val recordTimeList: MutableList<TimeDBLog> = mutableListOf() // 지난 1일간의
        val tableData: Cursor = dbHelper.writableDatabase.rawQuery(query, args)

        while (tableData.moveToNext()) {
            val srI = tableData.getColumnIndex("sleep_record_idx")
            val rstI = tableData.getColumnIndex("record_sleep_time")
            val rtI = tableData.getColumnIndex("rec_time_log")
            val startTimeI = tableData.getColumnIndex("rec_start_time")
            val endTimeI = tableData.getColumnIndex("rec_end_time")


            val sleepIndex = tableData.getInt(srI)
            val recordSleepTime = tableData.getInt(rstI)
            val recordTimeLog = tableData.getString(rtI)
            val startTimeLog = tableData.getString(startTimeI);
            val endTimeLog = tableData.getString(endTimeI);

            val timeLog = TimeDBLog(
                idx = sleepIndex,
                recordSleepTime = recordSleepTime.toLong(),
                recTimeLog = recordTimeLog,
                startTime = startTimeLog,
                endTime = endTimeLog
            )
            recordTimeList.add(timeLog)
        }

        dbHelper.writableDatabase.close()
        return recordTimeList
    }
    fun saveScore(context: Context, recordSleepTime: Long, startTime:String, endTime:String){
        // SQLite로 데이터를 삽입하는 코드
        // step 1. 데이터 베이스를 연다
        val dbHelper = DBHelper(context);
        // step 2. 삽입 코드를 작성한다
        val sql = """
            insert into sleep_record
            (record_sleep_time, rec_start_time, rec_end_time)
            values
            (?, ?, ?)
        """.trimIndent()
        // step 3. 세팅될 값을 배열로 선언해준다
        val values = arrayOf(recordSleepTime, startTime, endTime);
        // step 4. DBHelper를 통해 쿼리문을 실행한다.
        dbHelper.writableDatabase.execSQL(sql, values); // sql문, 값(배열) 순이다.
        // step 5. DB 사용이 끝났다면 쿼리문을 닫아 준다.
        Log.i(DBLOG, "데이터 베이스에 수면 시간 저장 $recordSleepTime")
        dbHelper.writableDatabase.close();
    }

    companion object {
        const val DBLOG ="DB HELPER::::"
    }

}