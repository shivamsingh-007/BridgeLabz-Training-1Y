package com.gla.collectionframework;

import java.util.*;

public class HospitalPatient {
    private Set<Patient> registeredPatients;
    private Queue<Patient> waitingQueue;
    private Stack<Patient> dischargeStack;
    private List<Patient> allVisits;

    public HospitalPatient() {
        this.registeredPatients = new HashSet<>();
        this.waitingQueue = new LinkedList<>();
        this.dischargeStack = new Stack<>();
        this.allVisits = new ArrayList<>();
    }

    public void registerPatient(Patient patient) {
        registeredPatients.add(patient);
        waitingQueue.offer(patient);
    }

    public void admitPatient() {
        Patient patient = waitingQueue.poll();
        if (patient != null) {
            patient.admit();
            allVisits.add(patient);
        }
    }

    public void dischargePatient() {
        if (!allVisits.isEmpty()) {
            Patient patient = allVisits.remove(allVisits.size() - 1);
            dischargeStack.push(patient);
            System.out.println("Discharged: " + patient.getName());
        }
    }

    public void undoDischarge() {
        if (!dischargeStack.isEmpty()) {
            Patient patient = dischargeStack.pop();
            allVisits.add(patient);
            System.out.println("Readmitted: " + patient.getName());
        }
    }

    public List<Patient> getPatientsByCondition(String condition) {
        List<Patient> conditionPatients = new ArrayList<>();
        for (Patient p : allVisits) {
            if (p.getCondition().equals(condition)) {
                conditionPatients.add(p);
            }
        }
        return conditionPatients;
    }

    public Set<Patient> getRegisteredPatients() {
        return registeredPatients;
    }

    public int getWaitingCount() {
        return waitingQueue.size();
    }

    public static void main(String[] args) {
        HospitalPatient hospital = new HospitalPatient();
        hospital.registerPatient(new Patient("PT001", "John", "Flu"));
        hospital.registerPatient(new Patient("PT002", "Jane", "Broken Bone"));
        hospital.registerPatient(new Patient("PT003", "Bob", "Flu"));
        System.out.println("Waiting: " + hospital.getWaitingCount());
        hospital.admitPatient();
        hospital.admitPatient();
        System.out.println("Currently admitted: " + hospital.allVisits.size());
        hospital.dischargePatient();
        hospital.undoDischarge();
    }
}

class Patient {
    private String patientId;
    private String name;
    private String condition;

    public Patient(String patientId, String name, String condition) {
        this.patientId = patientId;
        this.name = name;
        this.condition = condition;
    }

    public void admit() {
        System.out.println("Admitting patient: " + name);
    }

    public String getPatientId() { return patientId; }
    public String getName() { return name; }
    public String getCondition() { return condition; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patient patient = (Patient) o;
        return Objects.equals(patientId, patient.patientId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(patientId);
    }
}
