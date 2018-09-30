package fr.mbds.tp

import groovy.transform.CompileStatic
import groovy.util.logging.Slf4j
import org.springframework.scheduling.annotation.Scheduled
import java.text.SimpleDateFormat
class JobMessageService {

        MessageDataService messageDataService
        boolean lazyInit = false

        @Scheduled(cron = "0 00 4 1/1 * ?")
        def execute() {
            messageDataService.delete()
        }
    }

