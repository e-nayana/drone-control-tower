package org.musalasoft.libs.response;

import org.springframework.http.HttpStatus;

/**
 * Starting class to build response
 */

public class RESTResponseManager {
    /**
     * Start building from HeaderBuilder
     * @param httpStatus
     * @return
     */
    public static Header.HeaderBuilder headerBuilder(HttpStatus httpStatus){
        return new Header.HeaderBuilder(httpStatus);
    }

}
