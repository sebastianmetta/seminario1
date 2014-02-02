package seminariotp

import grails.transaction.Transactional

@Transactional
class PropertiesService {
	
    def getFrecuenciaLimpieza() {
		return config.almacenes.frecuenciaLimpieza
    }
	
}
