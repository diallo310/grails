package fr.mbds.tp

import grails.converters.JSON
import grails.converters.XML

class ApiController {

    def index() {
      //  render"ok"  
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

    def user(){
        switch (request.getMethod()){
            case"POST":
                  def userInstance = new User(params)

                if(userInstance.save(flush:true))
                    response.status=201
                else
                    response.status=400
                break;
            default:
                response.status=405
                break;
        }
    }
}

