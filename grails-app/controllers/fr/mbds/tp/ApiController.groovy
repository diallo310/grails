package fr.mbds.tp

import grails.converters.JSON
import grails.converters.XML

import java.sql.DriverManager

class ApiController {
    UserService userService;

    def index() {
        render"ok"
        /* switch (request.getMethod()){
             case"POST":
                 render "post"
                 println request.getHeader('Allow :text/xml')
                 break;
             case"GET":
                 render"get"
                 break;

         }*/
    }
    def getAllUser(){
        if(request.getMethod()=="GET"){
            if(userService.list(params)){
                render userService.list(params) as JSON
            }
            else{

            }

        }else{
            response.status=405
        }
    }

    def getUser(Long id){
        if(request.getMethod()=="GET"){
            if(userService.get(id)){
                render userService.get(id) as JSON
            }
            else{
                response.status=400
            }

        } else{
            response.status=405
        }

    }

    def createUser(User user){
        switch (request.getMethod()){
            case"POST":
                def userInstance = new User()

                if(userInstance.save(flush:true)){
                    response.status=201
               println('done')}
                else
                    response.status=400
                break;
            default:
                response.status=405
                break;
        }
    }
    def deleteUser(Long id){
        if(request.getMethod()=="DELETE"){
            if(userService.get(id)){
                if( userService.delete(id)){
                    response.status=200
                }
                else{
                    response.status=400 //a voir le code l'erreur
                }

            }
            else{
                response.status=400
            }

        }else{
            response.status=405
        }
    }

    def updateUser(){

    }
}

