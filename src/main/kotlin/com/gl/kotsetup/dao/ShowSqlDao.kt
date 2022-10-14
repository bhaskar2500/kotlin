package com.gl.kotsetup.dao.ShowSqlDao

import com.gl.kotsetup.models.Hall
import com.gl.kotsetup.models.Seat
import com.gl.kotsetup.models.Show
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Repository
import java.sql.Connection
import org.springframework.jdbc.core.ResultSetExtractor


@Repository
class ShowSqlDao(
    @Autowired private val jdbcTemplate: JdbcTemplate,
    @Autowired private val connection: Connection
) {

    fun getShows(pool: Boolean): List<Show>? {
        if (pool) {
            return connection.createStatement()
                .executeQuery("select * from public.show; ")
                .let { rs ->
                    generateSequence {
                        if (rs.next()) {
                            rs.getTimestamp("startDate")
                            Show(
                                rs.getInt("id"),
                                Hall(rs.getInt("hallId")),
                                Seat(rs.getInt("seatId")),
                                rs.getTimestamp("startDate").toString(),
                                rs.getTimestamp("endDate").toString(),
                            )
                        } else null
                    }.toList()
                }
        } else {
            return jdbcTemplate.query("select * from show;", ResultSetExtractor { rs ->
                generateSequence {
                    if (rs.next()) {
                        rs.getTimestamp("startDate")
                        Show(
                            rs.getInt("id"),
                            Hall(rs.getInt("hallId")),
                            Seat(rs.getInt("seatId")),
                            rs.getTimestamp("startDate").toString(),
                            rs.getTimestamp("endDate").toString(),
                        )
                    } else null
                }.toList()
            })
        }
    }

}