package com.gl.kotsetup

import com.gl.kotsetup.service.ShowService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.AutoConfiguration
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.http.ResponseEntity
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import javax.sql.DataSource


@SpringBootApplication
@EnableAutoConfiguration
//@EnableAutoConfiguration(exclude= [DataSourceAutoConfiguration::class])
class KotsetupApplication

/*ModifierList*/

fun main(args: Array<String>) {
    runApplication<KotsetupApplication>(*args)
}

@Controller
class ShowController(@Autowired val showService: ShowService ){

    @GetMapping("/shows")
    fun getShows(@RequestParam(name= "jdbc", required = false) jdbc: Boolean) : ResponseEntity<*>{
        return ResponseEntity.status(200).body(showService.getShows(jdbc));
    }
}

