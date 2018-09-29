package fr.mbds.tp

import grails.plugin.springsecurity.annotation.Secured
import grails.validation.ValidationException

import java.nio.file.SecureDirectoryStream

import static org.springframework.http.HttpStatus.*

class MessageController {

    MessageService messageService
//    UserProfileService userProfileService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond messageService.list(params), model:[messageCount: messageService.count()]
    }

    def show(Long id) {
        respond messageService.get(id)
    }

    def showMessageContent(Long id){
        messageService.get(id).isRead=true
        messageService.get(id).save(flush:true)
        redirect(controller:"message",action:"index")

    }

    def create() {
        respond new Message(params)
    }

    def save(Message msg) {
        if (msg == null) {
            notFound()
            return
        }

        try {
            messageService.save(msg)
        } catch (ValidationException e) {
            respond msg.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'msg.label', default: 'Message'), msg.id])
                redirect msg
            }
            '*' { respond msg, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond messageService.get(id)
    }

    def update(Message msg) {
        if (msg == null) {
            notFound()
            return
        }

        try {
            messageService.save(msg)
        } catch (ValidationException e) {
            respond msg.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'message.label', default: 'Message'), msg.id])
                redirect msg
            }
            '*'{ respond msg, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        messageService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'message.label', default: 'Message'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'message.label', default: 'Message'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }

    def UserProfile() {
        User utilisateurCourant = userProfileService.getCurrentUser()
        render view: '_table', model:[UserProfile: utilisateurCourant]
    }

}
