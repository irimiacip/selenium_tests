/*package net.metrosystems.seleniumtests.management;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.HEAD;

@RestController

    private static final String LIVENESS_CHECK_LOG = "Liveness check returns {}";
    private static final String READINESS_CHECK_LOG = "Readiness check returns {}";

    private final Logger log = LoggerFactory.getLogger(CheckController.class);

    @RequestMapping(value = {"/.well-known/live"}, method = {GET, HEAD})
    public ResponseEntity<String> live() {
        return getStringResponseEntity(true, LIVENESS_CHECK_LOG);
    }

    @RequestMapping(value = {"/.well-known/ready"}, method = {GET, HEAD})
    public ResponseEntity<String> ready() {
        return getStringResponseEntity(true, READINESS_CHECK_LOG);
    }

    private ResponseEntity<String> getStringResponseEntity(boolean live, String livenessCheckLog) {
        if (live) {
            log.debug(livenessCheckLog, live);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            log.warn(livenessCheckLog, live);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
*/