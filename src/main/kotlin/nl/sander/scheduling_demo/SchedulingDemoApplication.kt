package nl.sander.scheduling_demo

import nl.sander.scheduling_demo.scheduler.SchedulingModule
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Import


@SpringBootApplication
@Import(SchedulingModule::class)
class SchedulingDemoApplication {

//    @Bean
//    fun storageProvider(jobMapper: JobMapper, dataSource: DataSource): StorageProvider {
//        println(dataSource)
//        val storageProvider = SqlStorageProviderFactory
//            .using(dataSource)
//        storageProvider.setJobMapper(jobMapper)
//        return storageProvider
//    }
}

fun main(args: Array<String>) {
    runApplication<SchedulingDemoApplication>(*args)
}
