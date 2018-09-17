package fr.mbds.tp

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class HomeServiceSpec extends Specification {

    HomeService homeService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Home(...).save(flush: true, failOnError: true)
        //new Home(...).save(flush: true, failOnError: true)
        //Home home = new Home(...).save(flush: true, failOnError: true)
        //new Home(...).save(flush: true, failOnError: true)
        //new Home(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //home.id
    }

    void "test get"() {
        setupData()

        expect:
        homeService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Home> homeList = homeService.list(max: 2, offset: 2)

        then:
        homeList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        homeService.count() == 5
    }

    void "test delete"() {
        Long homeId = setupData()

        expect:
        homeService.count() == 5

        when:
        homeService.delete(homeId)
        sessionFactory.currentSession.flush()

        then:
        homeService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Home home = new Home()
        homeService.save(home)

        then:
        home.id != null
    }
}
