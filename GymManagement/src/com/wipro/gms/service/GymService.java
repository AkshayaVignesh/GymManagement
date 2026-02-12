package com.wipro.gms.service;

public class GymService {
    private ArrayList<Member> members;
    private ArrayList<Trainer> trainers;
    private ArrayList<SessionBooking> sessions;
    private int bookingCounter = 1001;

    public GymService(ArrayList<Member> members,
                      ArrayList<Trainer> trainers,
                      ArrayList<SessionBooking> sessions) {
        this.members = members;
        this.trainers = trainers;
        this.sessions = sessions;
    }

    public boolean validateMember(String memberId) throws InvalidMemberException {
        for (Member m : members) {
            if (m.getMemberId().equals(memberId)) {
                return true;
            }
        }
        throw new InvalidMemberException();
    }

    public boolean checkTrainerAvailability(String trainerId)
            throws TrainerNotAvailableException {
        for (Trainer t : trainers) {
            if (t.getTrainerId().equals(trainerId)) {
                if (t.getCurrentClients() < t.getMaxClientsPerSession()) {
                    return true;
                }
                throw new TrainerNotAvailableException();
            }
        }
        throw new TrainerNotAvailableException();
    }

    public SessionBooking bookSession(String memberId, String trainerId,
                                      String date, String time) throws Exception {

        validateMember(memberId);
        checkTrainerAvailability(trainerId);

        Member member = null;
        Trainer trainer = null;

        for (Member m : members) {
            if (m.getMemberId().equals(memberId)) {
                member = m;
            }
        }

        if (member.getRemainingSessions() <= 0) {
            throw new SessionException();
        }

        for (Trainer t : trainers) {
            if (t.getTrainerId().equals(trainerId)) {
                trainer = t;
            }

}
