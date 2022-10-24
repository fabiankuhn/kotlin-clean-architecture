package jambda.camp.clean

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CleanArchitectureKotlinApplication

fun main(args: Array<String>) {
    runApplication<CleanArchitectureKotlinApplication>(*args)
}
