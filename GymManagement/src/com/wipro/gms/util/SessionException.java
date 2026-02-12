package com.wipro.gms.util;

public class SessionException extends Exception {
	public String toString() {
        return "Session Error: Invalid or duplicate session booking";
    }
}
package com.wipro.gms.util;

public class TrainerNotAvailableException extends Exception{
	public String toString() {
        return "Trainer Not Available: Trainer is fully booked";
    }


}
