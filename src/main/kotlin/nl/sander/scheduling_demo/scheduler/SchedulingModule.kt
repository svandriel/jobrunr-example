package nl.sander.scheduling_demo.scheduler

import jakarta.annotation.PostConstruct
import nl.sander.scheduling_demo.UserRepository
import org.jobrunr.scheduling.JobScheduler
import org.springframework.context.annotation.Configuration
import java.time.Duration
import java.time.Instant
import kotlin.random.Random

@Configuration
class SchedulingModule(val jobScheduler: JobScheduler, val userRepository: UserRepository) {
    @PostConstruct
    fun queueSomething() {
        println("Queuing job")
        jobScheduler.schedule(Instant.now().plusSeconds(5)) {
            println("Running!")
        }

        jobScheduler.scheduleRecurrently(Duration.ofSeconds(5)) {
            Thread.sleep(1000)
            val userId = "${Random.nextInt()}"
            val user = userRepository.getUser(userId)

            println("User: $user")

        }
    }
}