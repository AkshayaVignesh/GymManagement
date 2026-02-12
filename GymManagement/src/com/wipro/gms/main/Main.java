package com.wipro.gms.main;
import java.util.ArrayList;
import com.wipro.gms.entity.*;
import com.wipro.gms.service.GymService;
import com.wipro.gms.util.*;
public class Main {
	public static void main(String[] args) {
		ArrayList<Member> members = new ArrayList<>();
        members.add(new Member("M001", "Rahul Sharma", "Standard", 5));
        members.add(new Member("M002", "Anita Verma", "Premium", 10));

        ArrayList<Trainer> trainers = new ArrayList<>();
        trainers.add(new Trainer("T101", "Karan Patel", "Strength Training", 3, 0));
        trainers.add(new Trainer("T102", "Meera Joshi", "Yoga", 2, 0));

        ArrayList<SessionBooking> sessions = new ArrayList<>();

        GymService service = new GymService(members, trainers, sessions);

        try {
            System.out.println("Booking session...");
            SessionBooking booking = service.bookSession(
                    "M001", "T101", "2025-01-12", "10:00 AM");

            System.out.println("Session booked successfully!");
            System.out.println("Booking ID: " + booking.getBookingId());

            System.out.println("\n--- Member Session History ---");
            service
            System.out.println("\nCancelling session...");
            service.cancelSession(booking.getBookingId());
            System.out.println("Session cancelled successfully!");

            System.out.println("\n--- Member Session History After Cancellation ---");
            service.printMemberSessions("M001");

        } catch (InvalidMemberException e) {
            System.out.println(e);

        } catch (TrainerNotAvailableException e) {
            System.out.println(e);

        } catch (SessionException e) {
            System.out.println(e);

        } catch (Exception e) {
            System.out.println("Unexpected Error: " + e.getMessage());
        }
	}
}

trainer.setCurrentClients(trainer.getCurrentClients() + 1);
member.setRemainingSessions(member.getRemainingSessions() - 1);

String bookingId = "B" + bookingCounter++;
SessionBooking sb = new SessionBooking(
        bookingId, memberId, trainerId, date, time);

sessions.add(sb);
return sb;
}

public boolean cancelSession(String bookingId) throws SessionException {
for (SessionBooking sb : sessions) {
    if (sb.getBookingId().equals(bookingId)) {

        for (Trainer t : trainers) {
            if (t.getTrainerId().equals(sb.getTrainerId())) {
                t.setCurrentClients(t.getCurrentClients() - 1);
            }
        }

        for (Member m : members) {
            if (m.getMemberId().equals(sb.getMemberId())) {
            	m.setRemainingSessions(m.getRemainingSessions() + 1);
            }
        }

        sessions.remove(sb);
        return true;
    }
}
throw new SessionException();
}

public void printMemberSessions(String memberId) {
for (SessionBooking sb : sessions) {
    if (sb.getMemberId().equals(memberId)) {
        System.out.println("Booking ID: " + sb.getBookingId()
                + ", Trainer ID: " + sb.getTrainerId()
                + ", Date: " + sb.getSessionDate()
                + ", Time: " + sb.getSessionTime());
    }
}
}

	}

}
