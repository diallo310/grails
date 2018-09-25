package fr.mbds.tp

import grails.gorm.DetachedCriteria
import groovy.transform.ToString

import org.codehaus.groovy.util.HashCodeHelper
import grails.compiler.GrailsCompileStatic

@GrailsCompileStatic
@ToString(cache=true, includeNames=true, includePackage=false)
class UserRole implements Serializable {

	private static final long serialVersionUID = 1

	User user
	Role role

	boolean equals(o) {
		if (this.is(o)) return true
		if (getClass() != o.class) return false

		UserRole userRole = (UserRole) o

		if (org_grails_datastore_gorm_GormValidateable__skipValidate != userRole.org_grails_datastore_gorm_GormValidateable__skipValidate) return false
		if (id != userRole.id) return false
		if (org_grails_datastore_gorm_GormValidateable__errors != userRole.org_grails_datastore_gorm_GormValidateable__errors) return false
		if (org_grails_datastore_mapping_dirty_checking_DirtyCheckable__$changedProperties != userRole.org_grails_datastore_mapping_dirty_checking_DirtyCheckable__$changedProperties) return false
		if (role != userRole.role) return false
		if (user != userRole.user) return false
		if (version != userRole.version) return false

		return true
	}

	int hashCode() {
		int result
		result = (user != null ? user.hashCode() : 0)
		result = 31 * result + (role != null ? role.hashCode() : 0)
		result = 31 * result + (id != null ? id.hashCode() : 0)
		result = 31 * result + (version != null ? version.hashCode() : 0)
		result = 31 * result + (org_grails_datastore_mapping_dirty_checking_DirtyCheckable__$changedProperties != null ? org_grails_datastore_mapping_dirty_checking_DirtyCheckable__$changedProperties.hashCode() : 0)
		result = 31 * result + (org_grails_datastore_gorm_GormValidateable__skipValidate ? 1 : 0)
		result = 31 * result + (org_grails_datastore_gorm_GormValidateable__errors != null ? org_grails_datastore_gorm_GormValidateable__errors.hashCode() : 0)
		return result
	}

	static UserRole get(long userId, long roleId) {
		criteriaFor(userId, roleId).get()
	}

	static boolean exists(long userId, long roleId) {
		criteriaFor(userId, roleId).count()
	}

	private static DetachedCriteria criteriaFor(long userId, long roleId) {
		UserRole.where {
			user == User.load(userId) &&
			role == Role.load(roleId)
		}
	}

	static UserRole create(User user, Role role, boolean flush = false) {
		def instance = new UserRole(user: user, role: role)
		instance.save(flush: flush)
		instance
	}

	static boolean remove(User u, Role r) {
		if (u != null && r != null) {
			UserRole.where { user == u && role == r }.deleteAll()
		}
	}

	static int removeAll(User u) {
		u == null ? 0 : UserRole.where { user == u }.deleteAll() as int
	}

	static int removeAll(Role r) {
		r == null ? 0 : UserRole.where { role == r }.deleteAll() as int
	}

	static constraints = {
	    user nullable: false
		role nullable: false, validator: { Role r, UserRole ur ->
			if (ur.user?.id) {
				if (UserRole.exists(ur.user.id, r.id)) {
				    return ['userRole.exists']
				}
			}
		}
	}

	static mapping = {
		id composite: ['user', 'role']
		version false
	}
}
