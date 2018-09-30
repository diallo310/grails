package fr.mbds.tp

import grails.gorm.transactions.Transactional
import groovy.transform.CompileStatic
import groovy.util.logging.Slf4j

import java.text.SimpleDateFormat
@Transactional
@Slf4j
@CompileStatic
class MessageDataService {

    MessageService messageService

    def delete(Map params) {
     def messageList=Message.getAll()

        messageList.each{
            if(!it.isRead){
                println(it)
                log.info "delete author= ${it.author.username} target = ${it.target.username} content= ${it.content} "+new SimpleDateFormat("dd/M/yyyy hh:mm:ss").format(new Date())
                messageService.delete(it.id);
            }
        }

    }
}
