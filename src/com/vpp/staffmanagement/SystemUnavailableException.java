package com.vpp.staffmanagement;

import javax.ejb.ApplicationException;

@ApplicationException(rollback=true)		// NOTE! This means that now each time this exception is thrown a rollback will occur. This might not
											// be the desired usage of this exception, in which case use the try/catch approach for rollback.
public class SystemUnavailableException extends Exception {

	private static final long serialVersionUID = 1L;

}
