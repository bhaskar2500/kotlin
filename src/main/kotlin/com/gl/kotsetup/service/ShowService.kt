package com.gl.kotsetup.service

import com.gl.kotsetup.models.Show
import com.gl.kotsetup.dao.ShowSqlDao.ShowSqlDao
import org.springframework.beans.factory.annotation.Autowired

import org.springframework.stereotype.Service


@Service
class ShowService(
    @Autowired val showSqlDao: ShowSqlDao
) {
    fun getShows(pool: Boolean): List<Show>? {
        return showSqlDao.getShows(pool)
    }

}
