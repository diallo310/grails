package fr.mbds.tp

import grails.converters.JSON

class ApiController {

    UserService userService
    MatchService matchService
    MessageService messageService

    def user() {
        switch (request.getMethod()) {
            case "POST":
                User user = new User(request.JSON)
                if (user.save(flush:true)){
                    //userRoleDataService.role(user,request.JSON.role)
                    response.status = 201
                } else {
                    response.status = 404
                }
                break
            case "GET":
                if (params.id) {
                    if (userService.get(params.id)) {
                        render userService.get(params.id) as JSON
                    } else {
                        render(status: 404, 'Not Found')
                    }

                } else {
                    if (userService.list(params)) {
                        render userService.list(params) as JSON
                    } else {
                        render(status: 404, 'Not Found')
                    }
                }
                break
            case "PUT":
                def user = userService.get(request.JSON.id)
                if (user) {
                    user.properties=request.JSON
                    if (user.save(flush: true)) {
                        response.status = 200
                    }

                } else {
                    response.status = 404
                }

                break
            case "DELETE":
                def user = userService.get(request.JSON.id)
                if (user) {
                    userService.delete(request.JSON.id)
                    if(request.JSON.id){
                        response.status=200
                    }else{

                    }
                }else{
                    response.status=404
                }
                break
        }

    }

    def match(){
        switch (request.getMethod()) {
            case "GET":
                if(params.id) {
                    def match = matchService.get(params.id)
                    if (match) {
                        render match as JSON
                    } else {
                        //code erreur
                    }
                }else{
                    def match = matchService.list(params)
                    if(match){
                        render match as JSON
                    }else {
                        //code  erreur
                    }
                }

                break
            case "PUT":
                def match= matchService.get(request.JSON.id)
                if(match){
                    match.properties=request.JSON
                    if(match.save(flush:true)){
                        response.status=200
                    }else{
                        //code erreur
                    }
                }
                else{
                    //code erreur
                }

                break
            case "DELETE":
                break
            case "POST":
                break
        }
    }


    def message(){
        switch (request.getMethod()) {
            case "GET":
                if(params.id){
                    def message = messageService.get(params.id)
                    if(message){
                        render message as JSON
                    }
                    else {
                        //code erreur
                    }
                }else{
                    def message = messageService.list(params)
                    if(message){
                        render message as JSON
                    }
                    else{
                        //code erreur
                    }
                }

                break
            case "PUT":
                def message = messageService.get(request.JSON.id)
                if(message){
                    message.properties=request.JSON
                    if(message.save(flush:true)){
                        render message as JSON
                    }else{
                        //code erreur
                    }
                }else{
                    //code erreur
                }
                break
            case "POST":
                break
            case "DELETE":

                def message = messageService.get(request.JSON.id)
                    if(message){
                        messageService.delete(request.JSON.id)
                        response.status=200
                    }else{
                        //code erreur
                    }
                break
        }
    }

}

